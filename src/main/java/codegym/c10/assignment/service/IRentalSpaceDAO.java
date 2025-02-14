package codegym.c10.assignment.service;

import codegym.c10.assignment.eNum.SpaceType;
import codegym.c10.assignment.model.RentalSpace;

import java.util.List;

public interface IRentalSpaceDAO {
    void addRentalSpace(RentalSpace rentalSpace);

    boolean deleteRentalSpace(String spaceID);

    List<RentalSpace> getAllRentalSpaces();

    List<RentalSpace> searchRentalSpaces(SpaceType spaceType, Integer floor, Integer minPrice, Integer maxPrice);

}
