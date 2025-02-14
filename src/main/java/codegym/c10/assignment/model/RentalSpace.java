package codegym.c10.assignment.model;

import codegym.c10.assignment.eNum.SpaceType;
import codegym.c10.assignment.eNum.Status;

import java.time.LocalDate;

public class RentalSpace {
    private String spaceID;
    private Status status;
    private double area;
    private int floor;
    private SpaceType spaceType;
    private long price;
    private LocalDate startDate;
    private LocalDate endDate;

    public RentalSpace(String spaceID, Status status, double area, int floor, SpaceType spaceType, long price, LocalDate startDate, LocalDate endDate) {
        this.spaceID = spaceID;
        this.status = status;
        this.area = area;
        this.floor = floor;
        this.spaceType = spaceType;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SpaceType getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(SpaceType spaceType) {
        this.spaceType = spaceType;
    }

    // Getters and Setters
    public String getSpaceID() {
        return spaceID;
    }

    public void setSpaceID(String spaceID) {
        this.spaceID = spaceID;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area > 20) {
            this.area = area;
        } else {
            throw new IllegalArgumentException("Area must be greater than 20m²");
        }
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        if (floor >= 1 && floor <= 15) {
            this.floor = floor;
        } else {
            throw new IllegalArgumentException("Floor must be between 1 and 15");
        }
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        if (price > 1000000) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price must be greater than 1,000,000 VND");
        }
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if (endDate.isAfter(startDate.plusMonths(6))) {
            this.endDate = endDate;
        } else {
            throw new IllegalArgumentException("EndDate must be at least 6 months after StartDate");
        }
    }

    @Override
    public String toString() {
        return "RentalSpace{" +
                "spaceID='" + spaceID + '\'' +
                ", status='" + status + '\'' +
                ", area=" + area +
                ", floor=" + floor +
                ", spaceType='" + spaceType + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
