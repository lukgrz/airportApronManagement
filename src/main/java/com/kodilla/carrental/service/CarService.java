package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Car;
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

    public Optional<Car> getCar(final long id) {
        return carDao.findById(id);
    }

    public List<Car> getCars() {
        return carDao.findAll();
    }

    public Car saveCar (final Car car) {
        return carDao.save(car);
    }

    public void deleteCar (final Long id) {
        carDao.deleteById(id);
    }
}
