package com.kodilla.carrental.service;

import com.kodilla.carrental.exception.InvoiceNotFoundException;
import com.kodilla.carrental.domain.Invoice;
import com.kodilla.carrental.repository.InvoiceDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceService {

    private final InvoiceDao invoiceDao;

    public Invoice getInvoice(final Long id) {
        return invoiceDao.findById(id).orElseThrow(()-> new InvoiceNotFoundException(id));
    }

    public List<Invoice> getInvoices() {
        return invoiceDao.findAll();
    }

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceDao.save(invoice);
    }

}
