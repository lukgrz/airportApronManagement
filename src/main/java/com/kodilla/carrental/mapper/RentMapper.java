package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.Rent;
import com.kodilla.carrental.dto.RentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentMapper {

    public RentDto mapToRentDto (Rent rent) {
        RentDto rentDto = new RentDto(rent.getId(), rent.getRentDate(), rent.getReturnDate(), rent.getEquipmentList(),
                rent.getCar(), rent.getClient(), rent.getTotalPrice(), rent.getCurrency());
        return  rentDto;
    }

    public Rent mapToRent (RentDto rentDto) {
        Rent rent = new Rent(rentDto.getId(), rentDto.getRentDate(), rentDto.getReturnDate(), rentDto.getEquipmentList(),
                rentDto.getCar(), rentDto.getClient(), rentDto.getTotalPrice(), rentDto.getCurrency());
        return rent;
    }

    public List<RentDto> mapToRentDtoList(List<Rent> rents) {
        return rents.stream()
                .map(this::mapToRentDto)
                .collect(Collectors.toList());
    }

    public List<Rent> mapToRentList(List<RentDto> rentDtos) {
        return rentDtos.stream()
                .map(this::mapToRent)
                .collect(Collectors.toList());
    }
}
