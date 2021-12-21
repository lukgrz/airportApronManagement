package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Equipment;
import com.kodilla.carrental.domain.Rent;
import com.kodilla.carrental.repository.RentDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RentService {

    private final RentDao rentDao;
    private final EquipmentService equipmentService;

    public Optional<Rent> getRent(final Long id) {
        return rentDao.findById(id);
    }

    public List<Rent> getRents() {
        return rentDao.findAll();
    }

    public Rent saveRent(final Rent rent) {
        return rentDao.save(rent);
    }

    public void deleteRent(final Long id) {
        rentDao.deleteById(id);
    }

    public Rent addEquipmentToRent(final Rent rent, final Long equipmentId) {
        Equipment equipment = equipmentService.getEquipment(equipmentId).get();
        rent.getEquipmentList().add(equipment);
        rentDao.save(rent);
        return rent;
    }

    public Rent removeEquipmentFromREnt(final Rent rent, final Long equipmentId) {
        Equipment equipment = equipmentService.getEquipment(equipmentId).get();
        rent.getEquipmentList().remove(equipment);
        rentDao.save(rent);
        return rent;
    }
}
