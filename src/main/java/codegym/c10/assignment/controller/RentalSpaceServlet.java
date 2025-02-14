package codegym.c10.assignment.controller;

import codegym.c10.assignment.model.RentalSpace;
import codegym.c10.assignment.service.IRentalSpaceDAO;
import codegym.c10.assignment.service.RentalSpaceDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "rentalspace", urlPatterns = "/rental_space")
public class RentalSpaceServlet extends HttpServlet {
    private IRentalSpaceDAO rentalSpaceDAO = new RentalSpaceDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create":
                req.getRequestDispatcher("addRentalSpace.jsp").forward(req, resp);
                break;
            default:
                showAll(req, resp);
                break;
        }
    }

    private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RentalSpace> rentalSpaceList = rentalSpaceDAO.getAllRentalSpaces();
        req.setAttribute("rsList", rentalSpaceList);
        req.getRequestDispatcher("rental_space_list.jsp").forward(req, resp);
    }


}
