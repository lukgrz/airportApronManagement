package com.kodilla.carrental.repository;

import com.kodilla.carrental.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ClientDao extends CrudRepository<Client, Long> {

    @Override
    List<Client> findAll();

    @Override
    Optional<Client> findById(Long id);

    @Override
    Client save(Client client);

    @Override
    void deleteById(Long id);

}
