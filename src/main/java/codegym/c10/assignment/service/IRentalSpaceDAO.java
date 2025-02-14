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

    // Sắp xếp theo diện tích tăng dần
    List<RentalSpace> sortByAreaAscending();

    // Tìm kiếm theo loại mặt bằng
    List<RentalSpace> searchBySpaceType(SpaceType spaceType);

    // Tìm kiếm theo tầng
    List<RentalSpace> searchByFloor(int floor);

    // Tìm kiếm theo giá tiền (trả về danh sách các mặt bằng có giá trong khoảng)
    List<RentalSpace> searchByPriceRange(long minPrice, long maxPrice);

    // Tìm kiếm theo 3 điều kiện: loại mặt bằng, tầng, giá tiền
    List<RentalSpace> searchByMultipleConditions(SpaceType spaceType, int floor, long maxPrice);
}
