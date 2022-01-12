package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.domain.Gearbox;
import com.kodilla.carrental.exception.CarNotFoundException;
import com.kodilla.carrental.repository.CarDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTestSuite {

    @InjectMocks
    private CarService carService;

    @Mock
    private CarDao carDao;

    @Test
    public void testReturnEmptyList() {
        //Given
        when(carDao.findAll()).thenReturn(List.of());
        //When
        List<Car> cars = carService.getCars();
        //Then
        assertNotNull(cars);
        assertEquals(0, cars.size());
    }

    @Test
    public void testReturnList() {
        //Given
        Car car1 = new Car("Renault", "Kangoo", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        Car car2 = new Car("Suzuki", "Swift", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        when(carDao.findAll()).thenReturn(List.of(car1, car2));
        //When
        List<Car> cars = carService.getCars();
        //Then
        assertNotNull(cars);
        assertEquals(2, cars.size());
    }

    @Test
    public void testThrowCarNotFoundException() {
        //Given
        Long id = 1l;
        when(carDao.findById(id)).thenReturn(Optional.empty());
        //When
        //Then
        assertThrows(CarNotFoundException.class, ()->carService.getCar(id));
    }

    @Test
    public void testFetchCar() {
        //Given
        Car car = new Car("Renault", "Kangoo", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        Long id = 1l;
        when(carDao.findById(id)).thenReturn(Optional.of(car));
        //When
        Car theCar = carService.getCar(id);
        //Then
        assertEquals(car, theCar);
    }

    @Test
    public void testSaveCar() {
        //Given
        Car car = new Car("Renault", "Kangoo", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        when(carDao.save(car)).thenReturn(car);
        //When
        Car theCar = carService.saveCar(car);
        //Then
        assertEquals(car, theCar);
    }

    @Test
    public void testUpdateExistingCar() {
        //Given
        Long id = 1l;
        Car car = new Car("Renault", "Kangoo", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        Car updatedCar = new Car("Renault", "Kangoo", "SL2222", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        when(carDao.findById(id)).thenReturn(Optional.of(car));
        when(carDao.save(car)).thenReturn(updatedCar);
        //When
        Car theCar = carService.updateCar(car, id);
        //Then
        assertEquals("SL2222", theCar.getRegistration());
    }

    @Test
    public void testUpdateNotExistingCar() {
        //Given
        Long id = 1l;
        Car car = new Car("Renault", "Kangoo", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        when(carDao.findById(id)).thenReturn(Optional.empty());
        when(carDao.save(car)).thenReturn(car);
        //When
        Car theCar = carService.updateCar(car, id);
        //Then
        assertEquals("SL1111", theCar.getRegistration());
    }


    @Test
    public void testDeleteCar() {
        //Given
        Long id = 1l;
        //When
        carService.deleteCar(id);
        //Then
        verify(carDao, times(1)).deleteById(id);
    }
}
