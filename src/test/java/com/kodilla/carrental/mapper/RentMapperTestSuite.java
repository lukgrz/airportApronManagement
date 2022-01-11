package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.*;
import com.kodilla.carrental.dto.RentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RentMapperTestSuite {

    @Autowired
    private RentMapper rentMapper;

    @Test
    public void testMapToRent() {
        //Given
        RentDto rentDto = new RentDto(1l, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5),
                List.of(new Equipment()), new Car(), new Client(), Currency.PLN, BigDecimal.valueOf(100));
        //When
        Rent rent = rentMapper.mapToRent(rentDto);
        //Then
        assertTrue(1L == rent.getId());
        assertEquals(5, rent.numberOfDaysForRent());
    }

    @Test
    public void testMapToRentDto() {
        //Given
        Rent rent = new Rent(1l, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5),
                List.of(new Equipment()), new Car(), new Client(), Currency.PLN, BigDecimal.valueOf(100));
        //When
        RentDto rentDto = rentMapper.mapToRentDto(rent);
        //Then
        assertTrue(1L == rentDto.getId());
        assertEquals(5, rentDto.getReturnDate().getDayOfMonth());
    }

    @Test
    public void testMapToRentDtoList() {
        //Given
        Rent rent1 = new Rent(1l, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5),
                List.of(new Equipment()), new Car(), new Client(), Currency.PLN, BigDecimal.valueOf(100));
        Rent rent2 = new Rent(2l, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5),
                List.of(new Equipment()), new Car(), new Client(), Currency.PLN, BigDecimal.valueOf(100));
        List<Rent> rents = List.of(rent1, rent2);
        //When
        List<RentDto> rentDtos = rentMapper.mapToRentDtoList(rents);
        //Then
        assertNotNull(rentDtos);
        assertTrue(rentDtos.size() == 2);
        assertEquals(2l, rentDtos.get(1).getId());
    }

    @Test
    public void testMapToRentDtoEmptyList() {
        //Given
        List<Rent> rents = List.of();
        //When
        List<RentDto> rentDtos = rentMapper.mapToRentDtoList(rents);
        //Then
        assertNotNull(rentDtos);
        assertTrue(rentDtos.size() == 0);
    }


    @Test
    public void testMapToRentList() {
        //Given
        RentDto rent1 = new RentDto(1l, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5),
                List.of(new Equipment()), new Car(), new Client(), Currency.PLN, BigDecimal.valueOf(100));
        RentDto rent2 = new RentDto(2l, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5),
                List.of(new Equipment()), new Car(), new Client(), Currency.PLN, BigDecimal.valueOf(100));
        List<RentDto> rentDtos = List.of(rent1, rent2);
        //When
        List<Rent> rents = rentMapper.mapToRentList(rentDtos);
        //Then
        assertNotNull(rentDtos);
        assertTrue(rentDtos.size() == 2);
        assertEquals(2l, rentDtos.get(1).getId());
    }

    @Test
    public void testMapToRentEmptyList() {
        //Given
        List<RentDto> rentDtos = List.of();
        //When
        List<Rent> rents = rentMapper.mapToRentList(rentDtos);
        //Then
        assertNotNull(rentDtos);
        assertTrue(rentDtos.size() == 0);
    }
}
