package domain;

import main.DB;

import java.sql.Connection;

public class Connect {
    private DB db;
    private Connection conn;

    public Connect(DB db) {
        this.db = db;
    }

    public DB getDB() {
        return this.db;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return this.conn;
    }
}
