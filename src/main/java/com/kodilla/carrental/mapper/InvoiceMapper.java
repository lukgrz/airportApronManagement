package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.Invoice;
import com.kodilla.carrental.dto.InvoiceDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceMapper {

    private RentMapper rentMapper;

    public InvoiceDto mapToInvoiceDto (Invoice invoice) {
        InvoiceDto invoiceDto = new InvoiceDto(invoice.getId(), rentMapper.mapToRentDto(invoice.getRent()));
        return invoiceDto;
    }

    public Invoice mapToInvoice (InvoiceDto invoiceDto) {
        Invoice invoice = new Invoice(invoiceDto.getId(), rentMapper.mapToRent(invoiceDto.getRentDto()));
        return invoice;
    }

    public List<InvoiceDto> mapToInvoiceDtoList (List<Invoice> invoices) {
        return invoices.stream()
                .map(this::mapToInvoiceDto)
                .collect(Collectors.toList());
    }
}
