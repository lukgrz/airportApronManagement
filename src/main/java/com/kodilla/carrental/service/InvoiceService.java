package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Invoice;
import com.kodilla.carrental.repository.InvoiceDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InvoiceService {

    private final InvoiceDao invoiceDao;

    public Optional<Invoice> getInvoice(final Long id) {
        return invoiceDao.findById(id);
    }

    public List<Invoice> getInvoices() {
        return invoiceDao.findAll();
    }

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceDao.save(invoice);
    }

}
