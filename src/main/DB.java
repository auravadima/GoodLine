package main;

import java.sql.*;
import java.util.ArrayList;

class DB {

    /**
     * Возвразает Connection с базой данных
     */
    Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager
                .getConnection("jdbc:h2:~/test", "auravadima", "rAAzhyGF1");
    }

    /**
     * Возвращает ResultSet sql запроса
     */
    ResultSet getRS(String sqlQuery, Connection conn) throws SQLException {
        Statement st = conn.createStatement();
        return st.executeQuery(sqlQuery);
    }

    /**
     * Возвращает коллекцию типа String, полученную из sql запроса
     */
    ArrayList<String> getResultArray(ResultSet rs, String column) throws SQLException {
        ArrayList<String> result = new ArrayList<>();
        while (rs.next()) {
            result.add(rs.getString(column));
        }
        return result;
    }
}
