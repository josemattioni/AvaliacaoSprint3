package com.example.avaliacaoAtv1.controller.form;

import com.example.avaliacaoAtv1.model.Car;
import com.sun.istack.NotNull;
import java.math.BigDecimal;

public class CarForm {

    @NotNull
    private String chassis;
    @NotNull
    private String name;
    @NotNull
    private String brand;
    @NotNull
    private String color;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer fabricationYear;

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

    public Integer getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(Integer fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public Car convert(){
        return new Car(chassis,name,brand,color,price,fabricationYear);
    }
}
