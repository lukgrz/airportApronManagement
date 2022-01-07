package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.domain.Gearbox;
import com.kodilla.carrental.domain.Price;
import com.kodilla.carrental.dto.CarDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarMapperTestSuite {

    @Autowired
    private CarMapper carMapper;

    @Test
    public void MapToCar() {
        //Given
        Price startingPrice = new Price(new BigDecimal(50));
        Price pricePerDay = new Price(new BigDecimal(30));
        CarDto carDto = new CarDto(1l, "Renault", "Megane", "SL1111", "1.5",
                5, 4, Gearbox.MANUAL, startingPrice, pricePerDay);
        //When
        Car car = carMapper.mapToCar(carDto);
        //Then
        assertEquals("SL1111", car.getRegistration());
    }

    @Test
    public void MapToCarDto() {
        //Given
        Price startingPrice = new Price(new BigDecimal(50));
        Price pricePerDay = new Price(new BigDecimal(30));
        Car car = new Car(1l, "Renault", "Megane", "SL1111", "1.5",
                5, 4, Gearbox.MANUAL, startingPrice, pricePerDay);
        //When
        CarDto carDto = carMapper.mapToCarDto(car);
        //Then
        assertEquals("Renault", carDto.getBrand());
    }

    @Test
    public void testMapToCarDtoList() {
        //Given
        Price startingPrice = new Price(new BigDecimal(50));
        Price pricePerDay = new Price(new BigDecimal(30));
        Car car1 = new Car(1l, "Renault", "Megane", "SL1111", "1.5",
                5, 4, Gearbox.AUTOMATIC, startingPrice, pricePerDay);
        Car car2 = new Car(1l, "Suzuki", "Swift", "SL1111", "1.0",
                4, 3, Gearbox.MANUAL, startingPrice, pricePerDay);
        List<Car> cars = List.of(car1, car2);
        //When
        List<CarDto> carDtos = carMapper.mapToCarDtoList(cars);
        //Then
        assertNotNull(carDtos);
        assertTrue(carDtos.size() == 2);
        assertEquals("Swift", carDtos.get(1).getModel());
    }

    @Test
    public void testMapToCarDtoEmptyList() {
        //Given
        List<Car> cars = List.of();
        //When
        List<CarDto> carDtos = carMapper.mapToCarDtoList(cars);
        //Then
        assertNotNull(carDtos);
        assertTrue(carDtos.size() == 0);
    }
}