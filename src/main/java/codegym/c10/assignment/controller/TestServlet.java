package codegym.c10.assignment.controller;

import codegym.c10.assignment.model.User;
import codegym.c10.assignment.service.IUserCRUD;
import codegym.c10.assignment.service.UserCRUDImpl;
import codegym.c10.assignment.utils.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "testServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    private IUserCRUD userCRUD = new UserCRUDImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = userCRUD.displayAllUsers();
        req.setAttribute("users", userList);
        req.getRequestDispatcher("hihi.jsp").forward(req, resp);
    }
}
