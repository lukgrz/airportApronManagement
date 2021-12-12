package com.kodilla.carrental.dto;

import com.kodilla.carrental.domain.Rent;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ClientDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String contactNumber;
    private List<RentDto> Rents;
}
