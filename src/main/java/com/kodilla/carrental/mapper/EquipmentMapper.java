package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.Equipment;
import com.kodilla.carrental.dto.EquipmentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentMapper {

    public EquipmentDto mapToEquipmentDto(Equipment equipment) {
        EquipmentDto equipmentDto= new EquipmentDto(equipment.getId(), equipment.getName(), equipment.getDescription(),
                equipment.getPricePerDay());
        return equipmentDto;
    }

    public Equipment mapToEquipment(EquipmentDto equipmentDto) {
        Equipment equipment = new Equipment(equipmentDto.getId(), equipmentDto.getName(), equipmentDto.getDescription(),
                equipmentDto.getPricePerDay());
        return equipment;
    }

    public List<EquipmentDto> mapToEquipmentDtoList (List<Equipment> equipments) {
        return equipments.stream()
                .map(this::mapToEquipmentDto)
                .collect(Collectors.toList());
    }
}
