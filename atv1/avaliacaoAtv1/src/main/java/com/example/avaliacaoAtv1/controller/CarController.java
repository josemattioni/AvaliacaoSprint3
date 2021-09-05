package com.example.avaliacaoAtv1.controller;


import com.example.avaliacaoAtv1.controller.dto.CarDto;

import com.example.avaliacaoAtv1.controller.form.CarForm;
import com.example.avaliacaoAtv1.model.Car;
import com.example.avaliacaoAtv1.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.math.BigDecimal;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/populate")
    @Transactional
    public ResponseEntity<?> registerNewCars(){
        Car car1 = new Car("8BBNSZPPA288003333","New Fiesta", "Ford", "white", new BigDecimal("28000"), 2015);
        Car car2 = new Car("7CCNSZPPA288003333","Onix", "Chevrolet", "black", new BigDecimal("40000"), 2017);
        Car car3 = new Car("9CCNSZPPA288003333","Civic", "Honda", "green", new BigDecimal("90000"), 2011);
        Car car4 = new Car("6CCNSZPPA288003333","Mustang", "Ford", "orange", new BigDecimal("150000"), 2020);
        Car car5 = new Car("5CCNSZPPA288003333","Fit", "Honda", "red", new BigDecimal("80000"), 2010);
        Car car6 = new Car("4CCNSZPPA288003333","Camaro", "Chevrolet", "grey", new BigDecimal("100000"), 2021);

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);
        carRepository.save(car5);
        carRepository.save(car6);

        return ResponseEntity.ok().build();
    }
    @PostMapping
    @Transactional
    public ResponseEntity<CarDto> register(@RequestBody CarForm carForm, UriComponentsBuilder uriComponentsBuilder){
        Car car = carForm.convert();
        carRepository.save(car);

        URI uri =uriComponentsBuilder.path("api/cars/{id}").buildAndExpand(car.getChassis()).toUri();
        return ResponseEntity.created(uri).body(new CarDto(car));
    }

    @GetMapping
    public List<CarDto> find(String brand,String name, String color, String orderName,String orderPrice, String orderYear){
        if (brand != null){
            List<Car> cars = carRepository.findByBrand(brand);
            return CarDto.convert(cars);
        }
        if (name != null){
            List<Car> cars = carRepository.findByName(name);
            return CarDto.convert(cars);
        }
        if (color != null){
            List<Car> cars = carRepository.findByColor(color);
            return CarDto.convert(cars);
        }
        if (orderName != null){
            List<Car> cars = carRepository.findAllByOrderByNameDesc();
            return CarDto.convert(cars);
        }
        if (orderPrice != null){
            List<Car> cars = carRepository.findAllByOrderByPriceDesc();
            return CarDto.convert(cars);
        }
        if (orderYear != null){
            List<Car> cars = carRepository.findAllByOrderByFabricationYearDesc();
            return CarDto.convert(cars);
        }else{
            List<Car> cars = carRepository.findAll();
            return CarDto.convert(cars);
        }
    }

}

