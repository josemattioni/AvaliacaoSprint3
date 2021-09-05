package com.example.avaliacaoAtv1.controller.dto;

import com.example.avaliacaoAtv1.model.Car;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CarDto {
    private String chassis;
    private String name;
    private String brand;
    private String color;
    private BigDecimal price;
    private int fabricationYear;

    public CarDto(Car car){
        this.chassis = car.getChassis();
        this.name = car.getName();
        this.brand = car.getBrand();
        this.color = car.getColor();
        this.price = car.getPrice();
        this.fabricationYear = car.getFabricationYear();
    }
    public static List<CarDto> convert(List<Car> cars) {
        return cars.stream().map(CarDto::new).collect(Collectors.toList());
    }

    public String getChassis() {
        return chassis;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getFabricationYear() {
        return fabricationYear;
    }
}
