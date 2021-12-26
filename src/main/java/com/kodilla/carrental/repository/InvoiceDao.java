package com.kodilla.carrental.repository;

import com.kodilla.carrental.domain.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface InvoiceDao extends CrudRepository<Invoice, Long> {

    @Override
    Optional<Invoice> findById(Long id);

    @Override
    List<Invoice> findAll();

    @Override
    Invoice save(Invoice invoice);
}
