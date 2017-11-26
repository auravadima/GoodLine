package main;

import org.flywaydb.core.Flyway;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private Connection conn;
    private String url;
    private String driver;

    void migrate() throws IOException {
        Flyway flyway = new Flyway();
        flyway.setLocations("db/migration");
        flyway.setDataSource(url, System.getenv("DBLOGIN"), System.getenv("DBPASS"));
        if (!new File("./database.mv.db").exists()) {
            flyway.migrate();
        }
    }

    DB() throws IOException {
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("connection.properties");
        Properties prop = new Properties();
        prop.load(input);
        url = prop.getProperty("url");
        driver = prop.getProperty("driver");
        input.close();
    }

    void connect() throws IOException, ClassNotFoundException, SQLException {
        Class.forName(driver);
        this.conn = DriverManager
                .getConnection(url, System.getenv("DBLOGIN"), System.getenv("DBPASS"));
    }

    public Connection getConn() {
        return conn;
    }
}

