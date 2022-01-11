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
    public CarDto getCar(@PathVariable Long id) {
        Car car = carService.getCar(id);
        return carMapper.mapToCarDto(car);
    }

    @PostMapping(value = "/cars", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCar(@RequestBody CarDto carDto) {
        Car car = carMapper.mapToCar(carDto);
        carService.saveCar(car);
    }

    @PutMapping(value = "/cars/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car updateCar(@RequestBody CarDto carDto, @PathVariable long id) {
        Car car = carMapper.mapToCar(carDto);
        return carService.updateCar(car,id);
    }

    @DeleteMapping(value = "/cars/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}
