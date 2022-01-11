package com.kodilla.carrental.controller;

import com.kodilla.carrental.domain.Equipment;
import com.kodilla.carrental.dto.EquipmentDto;
import com.kodilla.carrental.mapper.EquipmentMapper;
import com.kodilla.carrental.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentMapper equipmentMapper;
    private final EquipmentService equipmentService;

    @GetMapping(value = "/equipment")
    public List<EquipmentDto> getEquipmentList() {
        List<Equipment> equipmentList = equipmentService.getEquipmentList();
        return equipmentMapper.mapToEquipmentDtoList(equipmentList);
    }

    @GetMapping(value = "/equipment/{id}")
    public EquipmentDto getEquipment(@PathVariable Long id) {
        Equipment equipment = equipmentService.getEquipment(id);
        return equipmentMapper.mapToEquipmentDto(equipment);
    }

    @PostMapping(value = "/equipment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveEquipment(@RequestBody EquipmentDto equipmentDto) {
        Equipment equipment = equipmentMapper.mapToEquipment(equipmentDto);
        equipmentService.saveEquipment(equipment);
    }


    @PutMapping(value = "/equipment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEquipment(@RequestBody EquipmentDto equipmentDto) {
        Equipment equipment = equipmentMapper.mapToEquipment(equipmentDto);
        equipmentService.saveEquipment(equipment);
    }

    @DeleteMapping(value = "/equipment/{id}")
    public void deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
    }
}
