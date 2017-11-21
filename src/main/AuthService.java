package main;

import domain.Connect;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


class AuthService {

    static Boolean userExist(Connect cnt, String login) throws SQLException, ClassNotFoundException {
        try (Statement st = cnt.getConn().createStatement();
             ResultSet rs = st.executeQuery("SELECT LOGIN FROM USERS")) {
            ArrayList<String> logins = cnt.getDB().getArray(rs);

            for (String login1 : logins) {
                if (login.equals(login1)) {
                    return true;
                }
            }
            return false;
        }
    }

    static boolean isRightPass(Connect cnt, String usPass, String login) throws NoSuchAlgorithmException, SQLException, ClassNotFoundException {
        try (Statement st = cnt.getConn().createStatement();
             ResultSet rs = st.executeQuery(cnt.getDB().createQuery("USERS", login))) {
            String pass = null;
            String salt = null;
            if (rs.next()) {
                pass = rs.getString("PASS");
                salt = rs.getString("SALT");
            }
            return Passwords.safeCompare(pass, Passwords.getHash(usPass, salt));
        }
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

    static boolean hasAccess(Connect cnt, String res, String role, String login) throws SQLException, ClassNotFoundException {
        if (role == null) {
            return true;
        }
        res = res + ".";
        try (Statement st = cnt.getConn().createStatement();
             ResultSet rs = st.executeQuery(cnt.getDB().createQuery("AUTH", login))) {
            ArrayList<ArrayList<String>> auth = cnt.getDB().getAuth(rs);

            for (int i = 0; i < auth.get(0).size(); i++) {
                if (auth.get(1).get(i).equals(role) && res.startsWith(auth.get(0).get(i))) {
                    return true;
                }
            }
            return false;
        }
    }
}
