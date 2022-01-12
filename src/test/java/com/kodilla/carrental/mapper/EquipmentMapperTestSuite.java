package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.Equipment;
import com.kodilla.carrental.dto.EquipmentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EquipmentMapperTestSuite {

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Test
    public void mapToEquipment() {
        //Given
        EquipmentDto equipmentDto = new EquipmentDto(1l,"Baby seat", "Seat for baby", BigDecimal.valueOf(20));
        //When
        Equipment equipment = equipmentMapper.mapToEquipment(equipmentDto);
        //Then
        assertEquals(1l, equipment.getId());
        assertEquals("Baby seat", equipment.getName());
        assertEquals("Seat for baby", equipment.getDescription());
    }

    @Test
    public void mapToEquipmentDto() {
        //Given
        Equipment equipment = new Equipment(1l,"Baby seat", "Seat for baby", BigDecimal.valueOf(20));
        //When
        EquipmentDto equipmentDto = equipmentMapper.mapToEquipmentDto(equipment);
        //Then
        assertEquals(1l, equipmentDto.getId());
        assertEquals("Baby seat", equipmentDto.getName());
        assertEquals("Seat for baby", equipmentDto.getDescription());
    }

    @Test
    public void mapToEquipmentDtoList () {
        //Given
        Equipment equipment1 = new Equipment(1l,"Baby seat", "Seat for baby", BigDecimal.valueOf(20));
        Equipment equipment2 = new Equipment(2l,"Trailer", "Small trailer", BigDecimal.valueOf(40));
        List<Equipment> equipmentList = List.of(equipment1,equipment2);
        //When
        List<EquipmentDto> equipmentDtoList = equipmentMapper.mapToEquipmentDtoList(equipmentList);
        //Then
        assertNotNull(equipmentDtoList);
        assertTrue(equipmentDtoList.size() == 2);
        assertEquals("Trailer", equipmentDtoList.get(1).getName());
    }

    @Test
    public void testMapToEquipmentDtoEmptyList() {
        //Given
        List<Equipment> equipmentList = List.of();
        //When
        List<EquipmentDto> equipmentDtoList = equipmentMapper.mapToEquipmentDtoList(equipmentList);
        //Then
        assertNotNull(equipmentDtoList);
        assertTrue(equipmentDtoList.size() == 0);
    }
}
