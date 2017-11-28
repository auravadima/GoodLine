package main;

import org.flywaydb.core.Flyway;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class DB {

    private Connection conn;
    private String dburl;
    private String driver;
    private String dbfile;
    private static final String dblogin = System.getenv("DBLOGIN");
    private static final String dbpass = System.getenv("DBPASS");

    private void migrate() throws IOException {
        Flyway flyway = new Flyway();
        flyway.setLocations("db/migration");
        flyway.setDataSource(dburl + dbfile, dblogin, dbpass);
        if (!new File(String.format("%s.mv.db", dbfile)).exists()) {
            flyway.migrate();
        }
    }

    DB() throws IOException, SQLException, ClassNotFoundException {
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("resources/connection.properties");
        Properties prop = new Properties();
        prop.load(input);
        dburl = prop.getProperty("url");
        driver = prop.getProperty("driver");
        dbfile = prop.getProperty("filedb");
        input.close();
        this.migrate();
        this.connect();
    }

    private void connect() throws IOException, ClassNotFoundException, SQLException {
        Class.forName(driver);
        this.conn = DriverManager
                .getConnection(dburl + dbfile, dblogin, dbpass);
    }

    Connection getConn() {
        return conn;
    }
}

