package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Equipment;
import com.kodilla.carrental.repository.EquipmentDao;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EquipmentService {

    private final EquipmentDao equipmentDao;

    public Optional<Equipment> getEquipment(final Long id) {
        return equipmentDao.findById(id);
    }

    public List<Equipment> getEquipmentList() {
        return equipmentDao.findAll();
    }

    public Equipment saveEquipment(final Equipment equipment) {
        return equipmentDao.save(equipment);
    }

    public void deleteEquipment(final Long id) {
        equipmentDao.deleteById(id);
    }
}
