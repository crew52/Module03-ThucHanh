package codegym.c10.assignment.service;

import codegym.c10.assignment.model.User;
import codegym.c10.assignment.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserCRUDImpl implements IUserCRUD{
    private final Connection connection;

    public UserCRUDImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public List<User> displayAllUsers() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT id, name, age FROM users";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
                userList.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching customers", e);
        }

        return userList;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public boolean updateUser(int userId, User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        return false;
    }

    @Override
    public User findById(int userId) {
        return null;
    }
}
