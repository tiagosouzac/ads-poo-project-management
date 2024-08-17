package br.edu.iftm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Database {
    private Connection connection;

    public Database() {
        this.connection = this.getConnection();
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "user", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> query(String sql, Function<ResultSet, T> transformer, Object... params) {
        List<T> items = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            for (int i = 1; i < params.length; i++) {
                statement.setObject(i, params[i]);
            }

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    T item = transformer.apply(results);
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return items;
    }
}
