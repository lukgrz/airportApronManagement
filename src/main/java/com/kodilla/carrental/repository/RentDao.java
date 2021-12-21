package com.kodilla.carrental.repository;

import com.kodilla.carrental.domain.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface RentDao extends CrudRepository<Rent, Long> {

    @Override
    Optional<Rent> findById(Long id);

    @Override
    List<Rent> findAll();

    @Override
    Rent save(Rent rent);

    @Override
    void deleteById(Long id);
}
