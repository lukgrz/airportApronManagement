package com.kodilla.carrental.controller;

import com.kodilla.carrental.domain.Invoice;
import com.kodilla.carrental.dto.InvoiceDto;
import com.kodilla.carrental.mapper.InvoiceMapper;
import com.kodilla.carrental.repository.InvoiceDao;
import com.kodilla.carrental.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.atmosphere.config.service.Get;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceMapper invoiceMapper;

    @GetMapping(value = "/invoices/{id}")
    public InvoiceDto getInvoice(@PathVariable Long id) {
        Invoice invoice = invoiceService.getInvoice(id);
        return invoiceMapper.mapToInvoiceDto(invoice);
    }

    @GetMapping(value = "/invoices")
    public List<InvoiceDto> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getInvoices();
        return invoiceMapper.mapToInvoiceDtoList(invoices);
    }

    @PostMapping(value = "/invoices", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveInvoice (@RequestBody InvoiceDto invoiceDto) {
        invoiceService.saveInvoice(invoiceMapper.mapToInvoice(invoiceDto));
    }

}
