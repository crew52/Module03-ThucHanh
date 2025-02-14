package codegym.c10.assignment.controller;

import codegym.c10.assignment.eNum.SpaceType;
import codegym.c10.assignment.eNum.Status;
import codegym.c10.assignment.model.RentalSpace;
import codegym.c10.assignment.service.IRentalSpaceDAO;
import codegym.c10.assignment.service.RentalSpaceDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
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
                showFormAdd(req, resp);
                break;
            case "search":
                handleSearch(req, resp);
                break;
            case "delete":
                deleteRentalSpace(req, resp);
                break;
            default:
                showAll(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {
            case "create":
                addRentalSpace(req, resp);
                break;
            default:
                showAll(req, resp);
                break;
        }
    }

    private void addRentalSpace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String spaceID = req.getParameter("spaceID");
        Status status = Status.valueOf(req.getParameter("status"));
        double area = Double.parseDouble(req.getParameter("area"));
        int floor = Integer.parseInt(req.getParameter("floor"));
        SpaceType spaceType = SpaceType.valueOf(req.getParameter("spaceType"));
        long price = Long.parseLong(req.getParameter("price"));
        LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));

        RentalSpace rentalSpace = new RentalSpace(spaceID, status, area, floor, spaceType, price, startDate, endDate);

        rentalSpaceDAO.addRentalSpace(rentalSpace);

        resp.sendRedirect("/rental_space");
    }


    private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RentalSpace> rentalSpaceList = rentalSpaceDAO.getAllRentalSpaces();
        req.setAttribute("rsList", rentalSpaceList);
        req.getRequestDispatcher("rental_space_list.jsp").forward(req, resp);
    }

    private static void showFormAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addRentalSpace.jsp").forward(req, resp);
    }

    private void deleteRentalSpace(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String spaceID = req.getParameter("id");

        if (rentalSpaceDAO.deleteRentalSpace(spaceID)) {
            resp.sendRedirect("/rental_space");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }

    private void handleSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String spaceTypeParam = request.getParameter("spaceType");
        SpaceType spaceType = null;

        if (spaceTypeParam != null && !spaceTypeParam.isEmpty()) {
            try {
                spaceType = SpaceType.valueOf(spaceTypeParam.toUpperCase());
            } catch (IllegalArgumentException e) {
                spaceType = null;
            }
        }
        Integer floor = parseInteger(request.getParameter("floor"));
        Integer minPrice = parseInteger(request.getParameter("minPrice"));
        Integer maxPrice = parseInteger(request.getParameter("maxPrice"));

        List<RentalSpace> spaces = rentalSpaceDAO.searchRentalSpaces(spaceType, floor, minPrice, maxPrice);
        request.setAttribute("rsList", spaces);
        request.getRequestDispatcher("rental_space_list.jsp").forward(request, response);
    }

    private Integer parseInteger(String str) {
        try {
            return (str != null && !str.isEmpty()) ? Integer.parseInt(str) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
