package lesson16.task2.model;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private final static String insertQuery = "INSERT INTO shop.users (login, password) VALUES (?, ?);";
    private final static String getQuery = "SELECT login, password FROM shop.users;";

    public Map<String, String> getAll(String dbFileName) {
        Map<String, String> users = new HashMap<>();
        try (FileReader fr = new FileReader(dbFileName);
             BufferedReader br = new BufferedReader(fr)) {
            br.lines().forEach(s -> {
                String[] data = s.split(":");
                users.put(data[0], data[1]);
            });
        } catch (IOException e) {
            System.err.println("Users getting IOException: " + e);
        }
        return users;
    }

    public Map<String, String> getAll() {
        Map<String, String> users = new HashMap<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getQuery);
            while (resultSet.next()) {
                users.put(resultSet.getString("login"),
                        resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.err.println("Users getting SQLException: " + e);
        }
        return users;
    }

    public boolean insertEntity(User user, String dbFileName) {
        if (!getAll().containsKey(user.getLogin())) {
            try (FileWriter fw = new FileWriter(dbFileName, true);
                 BufferedWriter bw = new BufferedWriter(fw)) {
                bw.append("\n" + user.getLogin() + ":" + user.getPassword());
            } catch (IOException e) {
                System.err.println("User insertion IOException: " + e);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean insertEntity(User user) {
        int linesNumber = 0;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            linesNumber = statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("User insertion SQLException: " + e);
        }
        return linesNumber > 0;
    }
}
