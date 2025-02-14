package codegym.c10.assignment.service;

import codegym.c10.assignment.eNum.SpaceType;
import codegym.c10.assignment.model.RentalSpace;

import java.util.List;

public interface IRentalSpaceDAO {
    // Thêm mới RentalSpace
    void addRentalSpace(RentalSpace rentalSpace);

    // Xóa RentalSpace (có xác nhận)
    boolean deleteRentalSpace(String spaceID);

    // Lấy danh sách tất cả RentalSpace
    List<RentalSpace> getAllRentalSpaces();

    List<RentalSpace> searchRentalSpaces(SpaceType spaceType, Integer floor, Integer minPrice, Integer maxPrice);

}
