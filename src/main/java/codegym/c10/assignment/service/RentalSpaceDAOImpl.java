package codegym.c10.assignment.service;

import codegym.c10.assignment.eNum.SpaceType;
import codegym.c10.assignment.eNum.Status;
import codegym.c10.assignment.model.RentalSpace;
import codegym.c10.assignment.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalSpaceDAOImpl implements IRentalSpaceDAO {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM RentalSpace";

    private final Connection connection;

    public RentalSpaceDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void addRentalSpace(RentalSpace rentalSpace) {
        String sql = "INSERT INTO RentalSpace (SpaceID, Status, Area, Floor, SpaceType, Price, StartDate, EndDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, rentalSpace.getSpaceID());
            stmt.setString(2, rentalSpace.getStatus().name());
            stmt.setDouble(3, rentalSpace.getArea());
            stmt.setInt(4, rentalSpace.getFloor());
            stmt.setString(5, rentalSpace.getSpaceType().name());
            stmt.setLong(6, rentalSpace.getPrice());
            stmt.setDate(7, java.sql.Date.valueOf(rentalSpace.getStartDate()));
            stmt.setDate(8, java.sql.Date.valueOf(rentalSpace.getEndDate()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Debug lỗi
            throw new RuntimeException("Lỗi khi thêm RentalSpace", e);
        }
    }

    @Override
    public boolean deleteRentalSpace(String spaceID) {
        return false;
    }

    @Override
    public List<RentalSpace> getAllRentalSpaces() {
        List<RentalSpace> rentalSpaces = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                RentalSpace rentalSpace = new RentalSpace(
                        resultSet.getString("SpaceID"),
                        Status.valueOf(resultSet.getString("Status").toUpperCase()),
                        resultSet.getDouble("Area"),
                        resultSet.getInt("Floor"),
                        SpaceType.valueOf(resultSet.getString("SpaceType").toUpperCase()),
                        resultSet.getLong("Price"),
                        resultSet.getDate("StartDate").toLocalDate(),
                        resultSet.getDate("EndDate").toLocalDate()
                );
                rentalSpaces.add(rentalSpace);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving rental spaces from the database", e);
        }

        return rentalSpaces;
    }

    @Override
    public List<RentalSpace> sortByAreaAscending() {
        List<RentalSpace> rentalSpaces = new ArrayList<>();
        return rentalSpaces;
    }

    @Override
    public List<RentalSpace> searchBySpaceType(SpaceType spaceType) {
        List<RentalSpace> rentalSpaces = new ArrayList<>();
        return rentalSpaces;
    }

    @Override
    public List<RentalSpace> searchByFloor(int floor) {
        List<RentalSpace> rentalSpaces = new ArrayList<>();
        return rentalSpaces;
    }

    @Override
    public List<RentalSpace> searchByPriceRange(long minPrice, long maxPrice) {
        List<RentalSpace> rentalSpaces = new ArrayList<>();
        return rentalSpaces;
    }

    @Override
    public List<RentalSpace> searchByMultipleConditions(SpaceType spaceType, int floor, long maxPrice) {
        List<RentalSpace> rentalSpaces = new ArrayList<>();
        return rentalSpaces;
    }
}
