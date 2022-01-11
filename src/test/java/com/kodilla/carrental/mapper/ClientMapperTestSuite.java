package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.*;
import com.kodilla.carrental.dto.CarDto;
import com.kodilla.carrental.dto.ClientDto;
import com.kodilla.carrental.dto.RentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ClientMapperTestSuite {

    @Autowired
    private ClientMapper clientMapper;

    @Test
    public void MapToClient() {
        //Given
        ClientDto clientDto = new ClientDto(1l,"George", "Kowalsky","Katowice",
                "g.kowalsky@gmail.com", "11111111", List.of(new RentDto()));
        //When
        Client client = clientMapper.mapToClient(clientDto);
        //Then
        assertEquals("George", client.getFirstName());
    }

    @Test
    public void MapToClientDto() {
        //Given
        Client client = new Client(1l,"George", "Kowalsky","Katowice",
                "g.kowalsky@gmail.com", "11111111", List.of(new Rent()));
        //When
        ClientDto clientDto = clientMapper.mapToClientDto(client);
        //Then
        assertEquals("George", client.getFirstName());
    }

    @Test
    public void testMapToClientDtoList() {
        //Given
        Client client1 = new Client(1l,"George", "Kowalsky","Katowice",
                "g.kowalsky@gmail.com", "11111111", List.of(new Rent()));
        Client client2 = new Client(1l,"Mike", "Marvelous","Zabrze",
                "m.m@gmail.com", "11111111", List.of(new Rent()));

        List<Client> clients = List.of(client1, client2);
        //When
        List<ClientDto> clientDtos = clientMapper.mapToClientDtoList(clients);
        //Then
        assertNotNull(clientDtos);
        assertTrue(clientDtos.size() == 2);
        assertEquals("Mike", clientDtos.get(1).getFirstName());
    }

    @Test
    public void testMapToCarDtoEmptyList() {
        //Given
        List<Client> clients = List.of();
        //When
        List<ClientDto> clientDtos = clientMapper.mapToClientDtoList(clients);
        //Then
        assertNotNull(clientDtos);
        assertTrue(clientDtos.size() == 0);
    }

}
