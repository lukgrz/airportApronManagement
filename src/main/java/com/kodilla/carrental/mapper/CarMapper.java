package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.dto.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarMapper {

    public Car mapToCar(CarDto carDto) {
        Car car = new Car(carDto.getId(), carDto.getBrand(), carDto.getModel(), carDto.getRegistration(),
                carDto.getEngineCapacity(), carDto.getSeatsNumber(), carDto.getDoorsNumber(), carDto.getGearbox(),
                carDto.getStartingPrice(), carDto.getPricePerDay());
        return car;
    }

    public CarDto mapToCarDto(Car car) {
        CarDto carDto = new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getRegistration(),
                car.getEngineCapacity(), car.getSeatsNumber(), car.getDoorsNumber(), car.getGearbox(),
                car.getStartingPrice(), car.getPricePerDay());
        return carDto;
    }

    public List<CarDto> mapToCarDtoList(List<Car> cars) {
        return cars.stream()
                .map(this::mapToCarDto)
                .collect(Collectors.toList());
    }
}
