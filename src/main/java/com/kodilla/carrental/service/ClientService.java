package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Client;
import com.kodilla.carrental.domain.Rent;
import com.kodilla.carrental.repository.ClientDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientDao clientDao;

    public Optional<Client> getClient(final Long id) {
        return clientDao.findById(id);
    };

    public List<Client> getClients() {
        return clientDao.findAll();
    }

    public Client saveClient (final Client client) {
        return clientDao.save(client);
    }

    public void deleteClient (final Long id) {
        clientDao.deleteById(id);
    }
}
