package codegym.c10.assignment.service;

import codegym.c10.assignment.model.User;

import java.util.List;

public interface IUserCRUD {
    List<User> displayAllUsers();
    void createUser(User user);
    boolean updateUser(int userId, User user);
    boolean deleteUser(int userId);
    User findById(int userId);
}
