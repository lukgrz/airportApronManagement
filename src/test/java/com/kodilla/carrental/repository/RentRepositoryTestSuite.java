package com.kodilla.carrental.repository;

import com.kodilla.carrental.domain.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RentRepositoryTestSuite {

    @Autowired
    private RentDao rentDao;
    @Autowired
    private CarDao carDao;
    @Autowired
    private ClientDao clientDao;

    @AfterEach
    public void cleanUpAfterTest() {
        rentDao.deleteAll();
        carDao.deleteAll();
        clientDao.deleteAll();
    }

    @Test
    public void testCreateRent() {
        //Given
        Car car = new Car("Kangoo", "Reanult", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        Client client = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        Rent rent = new Rent(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5),
                car, client);
        carDao.save(car);
        clientDao.save(client);
        //When
        rentDao.save(rent);
        Long id = rent.getId();
        //Then
        assertTrue(rentDao.existsById(id));
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
        carDao.save(car);
        clientDao.save(client);
        rentDao.save(rent);
        Long id = rent.getId();
        //When
        Optional<Rent> resultRent = rentDao.findById(id);
        //Then
        assertNotNull(resultRent);
        assertEquals("Renault", resultRent.get().getCar().getModel());
    }

    @Test
    public void testFindAllClient() {
        //Given
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

        carDao.save(car);
        clientDao.save(client);
        rentDao.save(rent1);
        rentDao.save(rent2);
        //When
        List<Rent> rentList = rentDao.findAll();
        //Then
        assertEquals(2, rentList.size());
        assertEquals(2022, rentList.get(1).getRentDate().getYear());
    }
}
