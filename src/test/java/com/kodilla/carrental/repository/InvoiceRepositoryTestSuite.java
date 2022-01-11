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
public class InvoiceRepositoryTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private RentDao rentDao;
    @Autowired
    private CarDao carDao;
    @Autowired
    private ClientDao clientDao;

    @AfterEach
    public void cleanUpAfterTests() {
        invoiceDao.deleteAll();
        rentDao.deleteAll();
        carDao.deleteAll();
        clientDao.deleteAll();
    }

    @Test
    public void testCreateInvoice() {
        //Given
        Car car = new Car("Kangoo", "Reanult", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        Client client = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        Rent rent = new Rent(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5),
                car, client);
        Invoice invoice = new Invoice("FV1234", LocalDate.now(), rent);
        carDao.save(car);
        clientDao.save(client);
        //When
        invoiceDao.save(invoice);
        Long id = invoice.getId();
        //Then
        assertTrue(invoiceDao.existsById(id));
    }

    @Test
    public void testFetchInvoice() {
        //Given
        Car car = new Car("Kangoo", "Reanult", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        Client client = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        Rent rent = new Rent(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5),
                car, client);
        Invoice invoice = new Invoice("FV1234", LocalDate.now(), rent);
        carDao.save(car);
        clientDao.save(client);
        invoiceDao.save(invoice);
        Long id = invoice.getId();
        //When
        Optional<Invoice> resultInvoice = invoiceDao.findById(id);
        //Then
        assertNotNull(resultInvoice);
        assertEquals("FV1234", resultInvoice.get().getNumber());
    }

    @Test
    public void testFindAllInvoices() {
        //Given
        Car car = new Car("Kangoo", "Reanult", "SL1111", "1.4", 5,
                5, Gearbox.MANUAL, BigDecimal.valueOf(40), BigDecimal.valueOf(30));
        Client client = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        Rent rent1 = new Rent(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5),
                car, client);
        Rent rent2 = new Rent(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5),
                car, client);
        Invoice invoice1 = new Invoice("FV1234", LocalDate.now(), rent1);
        Invoice invoice2 = new Invoice("FV9876", LocalDate.now(), rent2);
        carDao.save(car);
        clientDao.save(client);
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        //When
        List<Invoice> invoiceList = invoiceDao.findAll();
        //Then
        assertEquals(2, invoiceList.size());
        assertEquals("FV9876", invoiceList.get(1).getNumber());
    }


}
