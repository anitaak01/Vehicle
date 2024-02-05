package org.example.entity;

public class Vehicle {
    private long id;
    private String color;
    private String brand;
    private String model;
    private String productionDate;
    private String fuel;

    public Vehicle(String color, String brand, String model, String productionDate, String fuel) {
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.productionDate = productionDate;
        this.fuel = fuel;
    }

    public Vehicle() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", productionDate=" + productionDate +
                ", fuel='" + fuel + '\'' +
                '}';
    }
}
