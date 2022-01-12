package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.domain.Equipment;
import com.kodilla.carrental.domain.Gearbox;
import com.kodilla.carrental.exception.CarNotFoundException;
import com.kodilla.carrental.exception.EquipmentNotFoundException;
import com.kodilla.carrental.repository.CarDao;
import com.kodilla.carrental.repository.EquipmentDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EquipmentServiceTestSuite {

    @InjectMocks
    private EquipmentService equipmentService;

    @Mock
    private EquipmentDao equipmentDao;

    @Test
    public void testReturnEmptyList() {
        //Given
        when(equipmentDao.findAll()).thenReturn(List.of());
        //When
        List<Equipment> equipmentList = equipmentService.getEquipmentList();
        //Then
        assertNotNull(equipmentList);
        assertEquals(0, equipmentList.size());
    }

    @Test
    public void testReturnList() {
        //Given
        Equipment equipment1 = new Equipment("Baby seat", "Seat fo baby", BigDecimal.valueOf(10));
        Equipment equipment2 = new Equipment("Trailer", "Small trailer", BigDecimal.valueOf(10));
              when(equipmentDao.findAll()).thenReturn(List.of(equipment1, equipment2));
        //When
        List<Equipment> equipmentList = equipmentService.getEquipmentList();
        //Then
        assertNotNull(equipmentList);
        assertEquals(2, equipmentList.size());
    }

    @Test
    public void testThrowEquipmentNotFoundException() {
        //Given
        Long id = 1l;
        when(equipmentDao.findById(id)).thenReturn(Optional.empty());
        //When
        //Then
        assertThrows(EquipmentNotFoundException.class, ()->equipmentService.getEquipment(id));
    }

    @Test
    public void testFetchEquipment() {
        //Given
        Equipment equipment = new Equipment("Baby seat", "Seat fo baby", BigDecimal.valueOf(10));
        Long id = 1l;
        when(equipmentDao.findById(id)).thenReturn(Optional.of(equipment));
        //When
        Equipment theEquipment = equipmentService.getEquipment(id);
        //Then
        assertEquals(equipment, theEquipment);
    }

    @Test
    public void testSaveEquipment() {
        //Given
        Equipment equipment = new Equipment("Baby seat", "Seat fo baby", BigDecimal.valueOf(10));
        when(equipmentDao.save(equipment)).thenReturn(equipment);
        //When
        Equipment theEquipment = equipmentService.saveEquipment(equipment);
        //Then
        assertEquals(equipment, theEquipment);
    }
}
