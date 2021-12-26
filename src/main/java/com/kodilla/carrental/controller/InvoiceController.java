package com.kodilla.carrental.controller;

import com.kodilla.carrental.domain.Invoice;
import com.kodilla.carrental.dto.InvoiceDto;
import com.kodilla.carrental.mapper.InvoiceMapper;
import com.kodilla.carrental.repository.InvoiceDao;
import lombok.RequiredArgsConstructor;
import org.atmosphere.config.service.Get;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1")
public class InvoiceController {

    private final InvoiceDao invoiceDao;
    private final InvoiceMapper invoiceMapper;

    @GetMapping(value = "/invoices/{id}")
    public InvoiceDto getInvoice(@RequestParam Long id) {
        Invoice invoice =  invoiceDao.findById(id).get();
        return invoiceMapper.mapToInvoiceDto(invoice);
    }

    @GetMapping(value = "/invoices")
    public List<InvoiceDto> getInvoices() {
        List<Invoice> invoices = invoiceDao.findAll();
        return invoiceMapper.mapToInvoiceDtoList(invoices);
    }

    @PostMapping(value = "/invoices", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveInvoice (@RequestBody InvoiceDto invoiceDto) {
        invoiceDao.save(invoiceMapper.mapToInvoice(invoiceDto));
    }

}
