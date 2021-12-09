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

    @GetMapping(value = "/cars/{carId}")
    public CarDto getCar(@RequestParam Long carId) {
        return carMapper.mapToCarDto(carService.getCar(carId).get());
    }

    @PostMapping(value = "/cars", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCar(@RequestBody CarDto carDto) {
        Car car = carMapper.mapToCar(carDto);
        carService.saveCar(car);
    }

    @PutMapping(value = "/cars")
    public void updateCar(@RequestBody CarDto carDto) {
        Car car = carMapper.mapToCar(carDto);
        carService.saveCar(car);
    }

    @DeleteMapping(value = "/cars/{carId}")
    public void deleteCar(@RequestParam Long carId) {
        carService.deleteCar(carId);
    }
}
