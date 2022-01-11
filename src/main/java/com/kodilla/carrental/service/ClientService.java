package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Client;
import com.kodilla.carrental.domain.Rent;
import com.kodilla.carrental.exception.ClientNotFoundException;
import com.kodilla.carrental.repository.ClientDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientDao clientDao;

    public Client getClient(final Long id) {
        return clientDao.findById(id).orElseThrow(()-> new ClientNotFoundException(id));
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

    public Client updateClient(final Client newClient, final long id) {
        return clientDao.findById(id)
                .map(client -> {
                    client.setFirstName(newClient.getFirstName());
                    client.setLastName(newClient.getLastName());
                    client.setAddress(newClient.getAddress());
                    client.setEmail(newClient.getEmail());
                    client.setContactNumber(newClient.getContactNumber());
                    return clientDao.save(client);
                })
                .orElseGet(() -> {
                    newClient.setId(id);
                    return  clientDao.save(newClient);
                });
    }
}
