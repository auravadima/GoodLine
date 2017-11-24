package services;

import main.DB;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AuthService {

    public Boolean userExist(DB db, String login) throws SQLException, ClassNotFoundException {
        try (PreparedStatement ps = db.getConn().prepareStatement("SELECT LOGIN FROM USERS WHERE LOGIN=?")) {
            ps.setString(1, login);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (login.equals(rs.getString("LOGIN"))) {
                        return true;
                    }
                }
                return false;

            }
        }
    }

    public boolean isRightPass(DB db, String usPass, String login) throws NoSuchAlgorithmException, SQLException, ClassNotFoundException {
        try (PreparedStatement ps = db.getConn().prepareStatement("SELECT PASS,SALT FROM USERS WHERE LOGIN=?")) {
            ps.setString(1, login);
            try (ResultSet rs = ps.executeQuery()) {
                String pass = null;
                String salt = null;
                if (rs.next()) {
                    pass = rs.getString("PASS");
                    salt = rs.getString("SALT");
                }
                return Passwords.safeCompare(pass, Passwords.getHash(usPass, salt));
            }
        }
    }

    public boolean isVolValid(String vol) {
        try {
            Integer.parseInt(vol);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDateValid(String ds) {
        try {
            java.time.LocalDate.parse(ds);
            return true;
        } catch (java.time.format.DateTimeParseException e) {
            return false;
        }
    }

    public boolean hasAccess(DB db, String res, String role, String login) throws SQLException, ClassNotFoundException {
        if (role == null) {
            return true;
        }
        res = res + ".";
        try (PreparedStatement ps = db.getConn().prepareStatement("SELECT * FROM AUTH WHERE LOGIN=?")) {
            ps.setString(1, login);
            try (ResultSet rs = ps.executeQuery()) {
                ArrayList<String> resList = new ArrayList<>();
                ArrayList<String> roleList = new ArrayList<>();
                while (rs.next()) {
                    roleList.add(rs.getString("ROLE"));
                    resList.add(rs.getString("RES") + ".");
                }
                for (int i = 0; i < resList.size(); i++) {
                    if (roleList.get(i).equals(role) && res.startsWith(resList.get(i))) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
