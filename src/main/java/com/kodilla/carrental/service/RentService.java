package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Equipment;
import com.kodilla.carrental.domain.Rent;
import com.kodilla.carrental.exception.RentNotFoundException;
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
    private final RateService rateService;

    public Rent getRent(final Long id) {
        return rentDao.findById(id).orElseThrow(()->new RentNotFoundException(id));
    }

    public List<Rent> getRents() {
        return rentDao.findAll();
    }

    private void calculateTotalPrice(final Rent rent) {
        rent.calculateTotalPrice(rateService);
    }

    public Rent saveRent(final Rent rent) {
        calculateTotalPrice(rent);
        return rentDao.save(rent);
    }

    public void deleteRent(final Long id) {
        rentDao.deleteById(id);
    }

    public Rent addEquipmentToRent(final Rent rent, final Long equipmentId) {
        Equipment equipment = equipmentService.getEquipment(equipmentId);
        rent.getEquipmentList().add(equipment);
        rentDao.save(rent);
        return rent;
    }

    public Rent removeEquipmentFromRent(final Rent rent, final Long equipmentId) {
        Equipment equipment = equipmentService.getEquipment(equipmentId);
        rent.getEquipmentList().remove(equipment);
        rentDao.save(rent);
        return rent;
    }
}
