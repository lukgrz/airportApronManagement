package com.kodilla.carrental.repository;

import com.kodilla.carrental.domain.Equipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface EquipmentDao extends CrudRepository<Equipment, Long> {

    @Override
    Optional<Equipment> findById(Long id);

    @Override
    List<Equipment> findAll();

    @Override
    Equipment save(Equipment equipment);

    @Override
    void deleteById(Long id);

}
