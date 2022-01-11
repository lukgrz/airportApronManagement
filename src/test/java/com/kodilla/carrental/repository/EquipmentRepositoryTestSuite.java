package com.kodilla.carrental.repository;

import com.kodilla.carrental.domain.Equipment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EquipmentRepositoryTestSuite {

    @Autowired
    private EquipmentDao equipmentDao;

    @AfterEach
    public void cleanUpAfterTest() {
        equipmentDao.deleteAll();
    }

    @Test
    public void testCreateEquipment() {
        //Given
        Equipment equipment = new Equipment("Baby seat", "Seat fo baby", BigDecimal.valueOf(10));
        //When
        equipmentDao.save(equipment);
        Long id = equipment.getId();
        //Then
        assertTrue(equipmentDao.existsById(id));
    }

    @Test
    public void testFetchEquipment() {
        //Given
        Equipment equipment = new Equipment("Baby seat", "Seat fo baby", BigDecimal.valueOf(10));
        equipmentDao.save(equipment);
        Long id = equipment.getId();
        //When
        Optional<Equipment> resultEquipment = equipmentDao.findById(id);
        //Then
        assertNotNull(resultEquipment);
        assertEquals("Baby seat", resultEquipment.get().getName());
    }

    @Test
    public void testFindAllEquipment() {
        //Given
        Equipment equipment1 = new Equipment("Baby seat", "Seat fo baby", BigDecimal.valueOf(10));
        Equipment equipment2 = new Equipment("Trailer", "Small trailer", BigDecimal.valueOf(10));
        equipmentDao.save(equipment1);
        equipmentDao.save(equipment2);
        //When
        List<Equipment> resultList = equipmentDao.findAll();
        //Then
        assertEquals(2, resultList.size());
        assertEquals("Trailer", resultList.get(1).getName());
    }

    @Test
    public void testDeleteEquipment() {
        //Given
        Equipment equipment1 = new Equipment("Baby seat", "Seat fo baby", BigDecimal.valueOf(10));
        Equipment equipment2 = new Equipment("Baby seat", "Seat fo baby", BigDecimal.valueOf(20));
        equipmentDao.save(equipment1);
        equipmentDao.save(equipment2);
        //When
        Long id = equipment1.getId();
        equipmentDao.deleteById(id);
        //Then
        assertEquals(1, equipmentDao.findAll().size());
        assertEquals(Optional.empty(), equipmentDao.findById(id));
    }
}

