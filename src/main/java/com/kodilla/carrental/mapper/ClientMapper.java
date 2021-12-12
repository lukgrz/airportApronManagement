package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.Client;
import com.kodilla.carrental.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientMapper {

    @Autowired
    RentMapper rentMapper;

    public ClientDto mapToClientDto (Client client) {
        ClientDto clientDto = new ClientDto(client.getId(), client.getFirstName(), client.getLastName(), client.getAddress(),
                client.getEmail(), client.getContactNumber(), rentMapper.mapToRentDtoList(client.getRents()));
        return clientDto;
    }

    public Client mapToClient (ClientDto clientDto) {
        Client client = new Client(clientDto.getId(), clientDto.getFirstName(), clientDto.getLastName(), clientDto.getAddress(),
                clientDto.getEmail(), clientDto.getContactNumber(), rentMapper.mapToRentList(clientDto.getRents()));
    }

    public List<ClientDto> mapToClientDtoList (List<Client> clients) {
        clients.stream()
                .map(this::mapToClientDto)
                .collect(Collectors.toList());
    }

}
