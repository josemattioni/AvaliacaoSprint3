package com.example.avaliacaoAtv1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Car {

    @Id
    private String chassis;
    private String name;
    private String brand;
    private String color;
    private BigDecimal price;
    private Integer fabricationYear;

    public Car(){}

    public Car(String chassis, String name, String brand, String color, BigDecimal price, int fabricationYear) {
        this.chassis = chassis;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.fabricationYear = fabricationYear;
    }

    public Integer getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(Integer fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
