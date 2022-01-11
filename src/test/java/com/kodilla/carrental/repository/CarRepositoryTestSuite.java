package com.kodilla.carrental.repository;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.domain.Gearbox;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarRepositoryTestSuite {

    @Autowired
    private CarDao carDao;

    @AfterEach
    public void cleanUpAfterTest() {
        carDao.deleteAll();
    }

    @Test
    public void testCreateCar() {
        //Given
        Car car = new Car("Kangoo", "Reanult", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        //When
        carDao.save(car);
        Long id = car.getId();
        //Then
        assertTrue(carDao.existsById(id));
    }

    @Test
    public void testFetchCar() {
        //Given
        Car car = new Car("Renault", "Kangoo", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        carDao.save(car);
        Long id = car.getId();
        //When
        Optional<Car> resultCar = carDao.findById(id);
        //Then
        assertNotNull(resultCar);
        assertEquals("Kangoo", resultCar.get().getModel());
    }

    @Test
    public void testFindAllCars() {
        //Given
        Car car1 = new Car("Renault", "Kangoo", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        Car car2 = new Car("Suzuki", "Swift", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        carDao.save(car1);
        carDao.save(car2);
        //When
        List<Car> resultList = carDao.findAll();
        //Then
        assertEquals(2, resultList.size());
        assertEquals("Suzuki", resultList.get(1).getBrand());
    }

    @Test
    public void testDeleteCar() {
        //Given
        Car car1 = new Car("Renault", "Kangoo", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        Car car2 = new Car("Suzuki", "Swift", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        carDao.save(car1);
        carDao.save(car2);
        //When
        Long id = car1.getId();
        carDao.deleteById(id);
        //Then
        assertEquals(1, carDao.findAll().size());
        assertEquals(Optional.empty(), carDao.findById(id));
    }
}
