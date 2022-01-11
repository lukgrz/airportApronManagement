package com.kodilla.carrental.dto;

import com.kodilla.carrental.domain.Rent;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class InvoiceDto {

    private Long id;
    private RentDto rentDto;
    private String number;
    private LocalDate dateOfIssue;
}
