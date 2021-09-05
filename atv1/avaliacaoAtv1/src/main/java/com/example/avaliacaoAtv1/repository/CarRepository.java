package com.example.avaliacaoAtv1.repository;

import com.example.avaliacaoAtv1.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {
    List<Car> findByBrand(String brand);

    List<Car> findByName(String name);

    List<Car> findByColor(String color);

    List<Car> findAllByOrderByNameDesc();

    List<Car> findAllByOrderByPriceDesc();

    List<Car> findAllByOrderByFabricationYearDesc();
}
