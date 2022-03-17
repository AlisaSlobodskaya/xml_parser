package application.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private final String databaseProperties = "database.properties";
    private final Properties properties;

    public DatabaseConnection() {
        this.properties = new Properties();
        loadProperties(databaseProperties);
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"),
                    properties.getProperty("DB_PASS"));
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void loadProperties(String file) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
