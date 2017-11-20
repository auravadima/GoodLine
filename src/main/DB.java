package main;

import java.sql.*;
import java.util.ArrayList;

class DB {

    Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager
                .getConnection("jdbc:h2:file:~/database", "auravadima", "rAAzhyGF1");
    }

    ResultSet getRS(String sqlQuery, Connection conn) throws SQLException {
        Statement st = conn.createStatement();
        return st.executeQuery(sqlQuery);
    }

    ArrayList<String> getResultArray(ResultSet rs, String column) throws SQLException {
        ArrayList<String> result = new ArrayList<>();
        while (rs.next()) {
            result.add(rs.getString(column));
        }
        rs.close();
        return result;
    }

    String createQuery(String table, String row) {
        return String.format("SELECT * FROM %s WHERE LOGIN='%s'", table, row);
    }

}

