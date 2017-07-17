package lesson16.task2.controller;

import lesson16.task2.model.*;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class BucketController {
    private final static String insertQuery = "INSERT INTO buckets (user_id, item_id, quantity) VALUES (" +
            "(SELECT user_id FROM shop.users WHERE login = ?), " +
            "(SELECT item_id FROM shop.items WHERE name = ?), " +
            "?);";
    private final static String deleteQuery = "DELETE FROM buckets WHERE user_id = " +
            "(SELECT user_id FROM users WHERE login = ?)";
    private final static String getQuery = "SELECT * FROM buckets INNER JOIN items " +
            "ON buckets.item_id = items.item_id " +
            "INNER JOIN categories " +
            "ON items.category_id = categories.category_id " +
            "WHERE user_id = " +
            "(SELECT user_id FROM users WHERE login = ?);";

    public static boolean serializeBucket(User user, String serFileName) {
        try (FileOutputStream fos = new FileOutputStream(serFileName);
             ObjectOutputStream os = new ObjectOutputStream(fos)) {
            os.writeObject(user.getBucket());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean deserializeBucket(User user, String serFileName) {
        try (FileInputStream fis = new FileInputStream(serFileName);
             ObjectInputStream is = new ObjectInputStream(fis)) {
            user.setBucket((Bucket) is.readObject());
            return true;
        } catch (IOException | ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean serializeBucket(User user) {
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            deleteStatement.setString(1, user.getLogin());
            deleteStatement.executeUpdate();
            insertStatement.setString(1, user.getLogin());
            for (Map.Entry<Item, Integer> entry : user.getBucket().getItems().entrySet()) {
                insertStatement.setString(2, entry.getKey().getName());
                insertStatement.setInt(3, entry.getValue());
                insertStatement.addBatch();
            }
            insertStatement.executeBatch();
            return true;
        } catch (SQLException e) {
            System.err.println("Serialize bucket SQLException: " + e);
        }
        return false;
    }

    public static boolean deserializeBucket(User user) {
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement getStatement = connection.prepareStatement(getQuery)) {
            getStatement.setString(1, user.getLogin());
            ResultSet resultSet = getStatement.executeQuery();
            while (resultSet.next()) {
                int quantity = resultSet.getInt("quantity");
                Item item = new Item(
                        resultSet.getString("items.name"),
                        resultSet.getDouble("cost"),
                        resultSet.getInt("rank"),
                        Category.valueOf(resultSet.getString("categories.name"))
                );
                while (quantity-- > 0) {
                    user.getBucket().addItem(item);
                }
            }
            return true;
        } catch (SQLException e) {
            System.err.println("Deserialize bucket SQLException: " + e);
        }
        return false;
    }
}
