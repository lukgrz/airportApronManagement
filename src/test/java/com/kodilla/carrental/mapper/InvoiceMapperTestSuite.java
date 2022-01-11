package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.*;
import com.kodilla.carrental.dto.InvoiceDto;
import com.kodilla.carrental.dto.RentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceMapperTestSuite {

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Test
    public void mapToInvoice() {
        //Given
        RentDto rentDto = new RentDto(1l, LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 1, 5), List.of(new Equipment()), new Car(), new Client(),
                Currency.PLN, BigDecimal.valueOf(100));
        InvoiceDto invoiceDto = new InvoiceDto(1l, rentDto, "FV1234",LocalDate.now());
        //When
        Invoice invoice = invoiceMapper.mapToInvoice(invoiceDto);
        //Then
        assertEquals(1l, invoice.getId());
        assertEquals(5, invoice.getRent().numberOfDaysForRent());
    }

    @Test
    public void mapToInvoiceDto() {
        //Given
        Rent rent = new Rent(1l, LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 1, 5), List.of(new Equipment()), new Car(), new Client(),
                Currency.PLN, BigDecimal.valueOf(100));
        Invoice invoice = new Invoice(1l, "FV1234",LocalDate.now(), rent);
        //When
        InvoiceDto invoiceDto = invoiceMapper.mapToInvoiceDto(invoice);
        //Then
        assertEquals(1l, invoiceDto.getId());
        assertEquals(5, invoiceDto.getRentDto().getReturnDate().getDayOfMonth());
    }

    @Test
    public void mapToInvoiceDtoList() {
        //Given
        Rent rent1 = new Rent(19l, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5),
                List.of(new Equipment()), new Car(), new Client(), Currency.PLN, BigDecimal.valueOf(100));
        Rent rent2 = new Rent(20l, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5),
                List.of(new Equipment()), new Car(), new Client(), Currency.PLN, BigDecimal.valueOf(100));
        Invoice invoice1 = new Invoice(1l, "FV1234", LocalDate.now(), rent1);
        Invoice invoice2 = new Invoice(2l, "FV9876", LocalDate.now(), rent2);
        List<Invoice> invoices = List.of(invoice1, invoice2);
        //When
        List<InvoiceDto> invoiceDtos = invoiceMapper.mapToInvoiceDtoList(invoices);
        //Then
        assertNotNull(invoiceDtos);
        assertTrue(invoiceDtos.size() == 2);
        assertEquals(2, invoiceDtos.get(1).getId());
    }

    @Test
    public void mapToInvoiceDtoEmptyList() {
        //Given
        List<Invoice> invoices = List.of();
        //When
        List<InvoiceDto> invoiceDtos = invoiceMapper.mapToInvoiceDtoList(invoices);
        //Then
        assertNotNull(invoiceDtos);
        assertTrue(invoiceDtos.size() == 0);
    }
}
