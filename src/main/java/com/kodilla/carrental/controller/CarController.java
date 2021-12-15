package com.kodilla.carrental.controller;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.dto.CarDto;
import com.kodilla.carrental.mapper.CarMapper;
import com.kodilla.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    @GetMapping(value = "/cars")
    public List<CarDto> getCars() {
        List<Car> cars = carService.getCars();
        return carMapper.mapToCarDtoList(cars);
    }

    @GetMapping(value = "/cars/{id}")
    public CarDto getCar(@RequestParam Long id) {
        Car car = carService.getCar(id).get();
        return carMapper.mapToCarDto(car);
    }

    @PostMapping(value = "/cars", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCar(@RequestBody CarDto carDto) {
        Car car = carMapper.mapToCar(carDto);
        carService.saveCar(car);
    }

    @PutMapping(value = "/cars", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCar(@RequestBody CarDto carDto) {
        Car car = carMapper.mapToCar(carDto);
        carService.saveCar(car);
    }

    @DeleteMapping(value = "/cars/{id}")
    public void deleteCar(@RequestParam Long id) {
        carService.deleteCar(id);
    }
}
