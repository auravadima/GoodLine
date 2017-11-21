package main;

import java.sql.*;
import java.util.ArrayList;

public class DB {

    Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager
                .getConnection("jdbc:h2:file:./database", "auravadima", "rAAzhyGF1");
    }

    ArrayList<ArrayList<String>> getAuth(ResultSet rs) throws SQLException {
        ArrayList<ArrayList<String>> auth = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> role = new ArrayList<>();
        while (rs.next()) {
            res.add(rs.getString("RES") + ".");
            role.add(rs.getString("ROLE"));
        }
        auth.add(res);
        auth.add(role);
        return auth;
    }

    ArrayList<String> getArray(ResultSet rs) throws SQLException {
        ArrayList<String> logins = new ArrayList<>();
        while (rs.next()) {
            logins.add(rs.getString("LOGIN"));
        }
        return logins;
    }

    String createQuery(String table, String row) {
        return String.format("SELECT * FROM %s WHERE LOGIN='%s'", table, row);
    }

}

