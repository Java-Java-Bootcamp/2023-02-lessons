package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5433/postgres";

    private static final String SELECT_ADMIN_USERS = "SELECT u.id, u.login FROM user_to_role " +
            "JOIN users u ON user_id = u.id " +
            "JOIN roles r ON role_role = r.id " +
            "WHERE r.name = ?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String roleName = scanner.nextLine().toUpperCase();


        try(Connection connection = DriverManager.getConnection(DATABASE_URL, "postgres", "postgres")) {
            try(PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ADMIN_USERS)) {
                prepareStatement.setString(1, roleName);
                try(ResultSet resultSet = prepareStatement.executeQuery()) {
                    while (resultSet.next()) {
                        long id = resultSet.getLong(1);
                        String login = resultSet.getString(2);
                        User user = new User();
                        user.setId(id);
                        user.setLogin(login);
                        System.out.println(user);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
