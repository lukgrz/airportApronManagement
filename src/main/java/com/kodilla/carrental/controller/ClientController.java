package com.kodilla.carrental.controller;

import com.kodilla.carrental.domain.Client;
import com.kodilla.carrental.dto.ClientDto;
import com.kodilla.carrental.mapper.ClientMapper;
import com.kodilla.carrental.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.atmosphere.config.service.Get;
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

    @GetMapping(value = "/clients/{clientId}")
    public ClientDto getClient(@RequestParam Long clientId) {
        Client client = clientService.getClient(clientId).get();
        return clientMapper.mapToClientDto(client);
    }

    @PostMapping(value = "/clients", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveClient(ClientDto clientDto) {
        Client client = clientMapper.mapToClient(clientDto);
        clientService.saveClient(client);
    }

    @PutMapping(value = "/clients")
    public void updateClient(@RequestBody ClientDto clientDto) {
        Client client = clientMapper.mapToClient(clientDto);
        clientService.saveClient(client);
    }

    @DeleteMapping(value = "/clients/{clientId}")
    public void deleteClient(@RequestParam Long clientId) {
        clientService.deleteClient(clientId);
    }
}