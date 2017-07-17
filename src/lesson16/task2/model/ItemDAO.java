package lesson16.task2.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class ItemDAO {
    private final static String getQuery = "SELECT * FROM shop.items " +
            "INNER JOIN shop.categories " +
            "ON items.category_id = categories.category_id;";

    public Set<Item> getAll(String dbFileName) {
        Set<Item> itemSet = new HashSet<>();
        try (FileReader fr = new FileReader(dbFileName);
             BufferedReader br = new BufferedReader(fr)) {
            br.lines().forEach(s -> {
                String[] data = s.split(":");
                itemSet.add(new Item(
                        data[0],
                        Double.parseDouble(data[1]),
                        Integer.parseInt(data[2]),
                        Category.byName(data[3])
                ));
            });
        } catch (IOException e) {
            System.err.println("Items getting IOException: " + e);
        }
        return itemSet;
    }

    public Set<Item> getAll() {
        Set<Item> itemSet = new HashSet<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getQuery);
            while (resultSet.next()) {
                itemSet.add(new Item(
                        resultSet.getString("name"),
                        resultSet.getDouble("cost"),
                        resultSet.getInt("rank"),
                        Category.valueOf(resultSet.getString("categories.name"))
                ));
            }
        } catch (SQLException e) {
            System.err.println("Items getting SQLException: " + e);
        }
        return itemSet;
    }
}
