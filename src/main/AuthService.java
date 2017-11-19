package main;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


class AuthService {

    static Boolean userExist(String login) throws SQLException, ClassNotFoundException {
        DB db = new DB();
        Connection conn = db.getConn();
        ResultSet rs = db.getRS("SELECT LOGIN FROM USERS", conn);
        ArrayList<String> logins = db.getResultArray(rs, "LOGIN");
        for (String login1 : logins) {
            if (login.equals(login1)) {
                return true;
            }
        }
        return false;
    }

    static boolean isRightPass(String usPass, String login) throws NoSuchAlgorithmException, SQLException, ClassNotFoundException {
        DB db = new DB();
        Connection conn = db.getConn();
        ResultSet rs = db.getRS(String.format("SELECT * FROM USERS WHERE LOGIN='%s'", login), conn);
        rs.next();
        return Passwords.safeCompare(rs.getString("PASS"), Passwords.getHash(usPass, rs.getString("SALT")));
    }

    static boolean isVolValid(String vol) {
        try {
            Integer.parseInt(vol);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean isDateValid(String ds) {
        try {
            java.time.LocalDate.parse(ds);
            return true;
        } catch (java.time.format.DateTimeParseException e) {
            return false;
        }
    }

    static boolean hasAccess(String res, String role, String login) throws SQLException, ClassNotFoundException {
        if (role == null) {
            return true;
        }
        res = res + ".";
        DB db = new DB();
        Connection conn = db.getConn();
        ResultSet rs = db.getRS(String.format("SELECT RES FROM AUTH WHERE LOGIN='%s'", login), conn);
        ArrayList<String> ress = db.getResultArray(rs, "RES");
        rs = db.getRS(String.format("SELECT ROLE FROM AUTH WHERE LOGIN='%s'", login), conn);
        ArrayList<String> roles = db.getResultArray(rs, "ROLE");
        for (int i = 0; i < ress.size(); i++) {
            if (roles.get(i).equals(role)) {
                String usRes = ress.get(i) + ".";
                if (res.startsWith(usRes)) {
                    return true;
                }
            }
        }
        return false;
    }
}
