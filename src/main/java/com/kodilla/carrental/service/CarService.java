package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.exception.CarNotFoundException;
import com.kodilla.carrental.repository.CarDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarService {

    private final CarDao carDao;

    public Car getCar(final long id) {
        return carDao.findById(id).orElseThrow(()->new CarNotFoundException(id));
    }

    public List<Car> getCars() {
        return carDao.findAll();
    }

    public Car saveCar (final Car car) {
        return carDao.save(car);
    }

    public Car updateCar (final Car newCar, final long id) {
        return carDao.findById(id)
                .map(car -> {
                    car.setBrand(newCar.getBrand());
                    car.setModel(newCar.getModel());
                    car.setRegistration(newCar.getRegistration());
                    car.setEngineCapacity(newCar.getEngineCapacity());
                    car.setSeatsNumber(newCar.getSeatsNumber());
                    car.setDoorsNumber(newCar.getDoorsNumber());
                    car.setGearbox(newCar.getGearbox());
                    car.setStartingPrice(newCar.getStartingPrice());
                    car.setPricePerDay(newCar.getPricePerDay());
                    return carDao.save(car);
                })
                .orElseGet(() -> {
                    newCar.setId(id);
                    return carDao.save(newCar);
                });
    }

    public void deleteCar (final Long id) {
        carDao.deleteById(id);
    }
}
