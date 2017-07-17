package lesson16.task2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB {
    private static String url;
    private static String user;
    private static String password;
    private static String dbName;
    private static String driver;

    private ConnectorDB() {
    }

    private static void initializeDB() {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        url = resource.getString("url");
        user = resource.getString("user");
        password = resource.getString("password");
        dbName = resource.getString("name");
        driver = resource.getString("driver");
    }

    public static Connection getConnection() throws SQLException {
            initializeDB();
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return DriverManager.getConnection(url + dbName, user, password);
    }
}
