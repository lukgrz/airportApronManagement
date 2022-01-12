package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.domain.Client;
import com.kodilla.carrental.domain.Gearbox;
import com.kodilla.carrental.domain.Rent;
import com.kodilla.carrental.exception.RentNotFoundException;
import com.kodilla.carrental.repository.CarDao;
import com.kodilla.carrental.repository.ClientDao;
import com.kodilla.carrental.repository.RentDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RentServiceTestSuite {

    @InjectMocks
    private RentService rentService;
    @Mock
    private RentDao rentDao;
    @Mock
    private ClientDao clientDao;
    @Mock
    private CarDao carDao;
    @Mock
    private EquipmentService equipmentService;

    @Test
    public void testReturnEmptyList() {
        //Given
        when(rentDao.findAll()).thenReturn(List.of());
        //When
        List<Rent> rents = rentService.getRents();
        //Then
        assertNotNull(rents);
        assertEquals(0, rents.size());
    }

    @Test
    public void testReturnList() {
        //Given
        Car car = new Car("Kangoo", "Renault", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        Client client = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        Rent rent1 = new Rent.RentBuilder()
                .rentDate(LocalDate.of(2021, 1, 1))
                .returnDate(LocalDate.of(2021, 1, 5))
                .car(car)
                .client(client)
                .build();

        Rent rent2 = new Rent.RentBuilder()
                .rentDate(LocalDate.of(2022, 1, 1))
                .returnDate(LocalDate.of(2022, 1, 5))
                .car(car)
                .client(client)
                .build();

        when(rentDao.findAll()).thenReturn(List.of(rent1, rent2));
        //When
        List<Rent> rents = rentService.getRents();
        //Then
        assertNotNull(rents);
        assertEquals(2, rents.size());
    }

    @Test
    public void testThrowRentNotFoundException() {
        //Given
        Long id = 1l;
        when(rentDao.findById(id)).thenReturn(Optional.empty());
        //When
        //Then
        assertThrows(RentNotFoundException.class, () -> rentService.getRent(id));
    }

    @Test
    public void testFetchRent() {
        //Given
        Car car = new Car("Kangoo", "Renault", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        Client client = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        Rent rent = new Rent.RentBuilder()
                .rentDate(LocalDate.of(2021, 1, 1))
                .returnDate(LocalDate.of(2021, 1, 5))
                .car(car)
                .client(client)
                .build();

        Long id = 1l;
        when(rentDao.findById(id)).thenReturn(Optional.of(rent));
        //When
        Rent theRent = rentService.getRent(id);
        //Then
        assertEquals(rent, theRent);
    }

    @Test
    public void testSaveRent() {
        //Given
        Car car = new Car("Kangoo", "Renault", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        Client client = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");

        Rent rent = new Rent.RentBuilder()
                .rentDate(LocalDate.of(2021, 1, 1))
                .returnDate(LocalDate.of(2021, 1, 5))
                .car(car)
                .client(client)
                .build();

        when(rentDao.save(rent)).thenReturn(rent);
        //When
        Rent theRent = rentService.saveRent(rent);
        //Then
        assertEquals(rent, theRent);
    }
}
