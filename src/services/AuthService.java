package services;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthService {

    private Connection conn;

    public AuthService(Connection conn){
        this.conn = conn;
    }

    public Boolean userExist(String login) throws SQLException, ClassNotFoundException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT LOGIN FROM USERS WHERE LOGIN=?")) {
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

    public boolean isRightPass(String usPass, String login) throws NoSuchAlgorithmException, SQLException, ClassNotFoundException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT PASS,SALT FROM USERS WHERE LOGIN=?")) {
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

    public boolean hasAccess(String res, String role, String login) throws SQLException, ClassNotFoundException {
        if (role == null) {
            return true;
        }
        res = res + ".";
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM AUTH WHERE LOGIN=? AND ROLE=?")) {
            ps.setString(1, login);
            ps.setString(2, role);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if ((res.startsWith(rs.getString("RES") + "."))) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
