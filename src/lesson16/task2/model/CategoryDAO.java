package lesson16.task2.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CategoryDAO {
    private final static String getQuery = "SELECT * from shop.categories where category_id<>1;";

    public Set<Category> getAll() {
        SortedSet<Category> categories = new TreeSet<>(Comparator.comparing(Category::getName));
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getQuery);
            while (resultSet.next()) {
                categories.add(Category.valueOf(resultSet.getString("name")));
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e);
        }
        return categories;
    }
}
