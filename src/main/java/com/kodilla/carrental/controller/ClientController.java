package com.kodilla.carrental.controller;

import com.kodilla.carrental.domain.Client;
import com.kodilla.carrental.dto.ClientDto;
import com.kodilla.carrental.dto.RentDto;
import com.kodilla.carrental.mapper.ClientMapper;
import com.kodilla.carrental.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @GetMapping(value = "/clients")
    public List<ClientDto> getClients() {
        List<Client> clients = clientService.getClients();
        return clientMapper.mapToClientDtoList(clients);
    }

    @GetMapping(value = "/clients/{id}")
    public ClientDto getClient(@PathVariable Long id) {
        Client client = clientService.getClient(id);
        return clientMapper.mapToClientDto(client);
    }

    @PostMapping(value = "/clients", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Client saveClient(ClientDto clientDto) {
        Client client = clientMapper.mapToClient(clientDto);
        return clientService.saveClient(client);
    }

    @PutMapping(value = "/clients/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Client updateClient(@RequestBody ClientDto clientDto, @PathVariable Long id) {
        Client client = clientMapper.mapToClient(clientDto);
        return clientService.updateClient(client, id);
    }

    @DeleteMapping(value = "/clients/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping(value = "/clients/{id}/rents")
    public List<RentDto> getAllClientRents (@PathVariable Long id) {
        ClientDto client = clientMapper.mapToClientDto(clientService.getClient(id));
        return client.getRents();
    }
}