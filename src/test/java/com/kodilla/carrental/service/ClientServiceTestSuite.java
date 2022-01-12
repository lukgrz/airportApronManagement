package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.domain.Client;
import com.kodilla.carrental.domain.Gearbox;
import com.kodilla.carrental.exception.CarNotFoundException;
import com.kodilla.carrental.exception.ClientNotFoundException;
import com.kodilla.carrental.repository.ClientDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTestSuite {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientDao clientDao;

    @Test
    public void testReturnEmptyList() {
        //Given
        when(clientDao.findAll()).thenReturn(List.of());
        //When
        List<Client> clients = clientService.getClients();
        //Then
        assertNotNull(clients);
        assertEquals(0, clients.size());
    }

    @Test
    public void testReturnList() {
        //Given
        Client client1 = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        Client client2 = new Client("Clint", "Eastwood", "Zabrze", "KE@gamil.com",
                "987654321");
        when(clientDao.findAll()).thenReturn(List.of(client1, client2));
        //When
        List<Client> clients = clientService.getClients();
        //Then
        assertNotNull(clients);
        assertEquals(2, clients.size());
    }

    @Test
    public void testThrowClientNotFoundException() {
        //Given
        Long id = 1l;
        when(clientDao.findById(id)).thenReturn(Optional.empty());
        //When
        //Then
        assertThrows(ClientNotFoundException.class, ()->clientService.getClient(id));
    }

    @Test
    public void testFetchClient() {
        //Given
        Client client = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        Long id = 1l;
        when(clientDao.findById(id)).thenReturn(Optional.of(client));
        //When
        Client theClient = clientService.getClient(id);
        //Then
        assertEquals(client, theClient);
    }

    @Test
    public void testSaveCar() {
        //Given
        Client client = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        when(clientDao.save(client)).thenReturn(client);
        //When
        Client theClient = clientService.saveClient(client);
        //Then
        assertEquals(client, theClient);
    }

    @Test
    public void testUpdateExistingClient() {
        //Given
        Long id = 1l;
        Client client = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        Client updatedClient = new Client("Clint", "Eastwood", "Zabrze", "KE@gamil.com",
                "987654321");
        when(clientDao.findById(id)).thenReturn(Optional.of(client));
        when(clientDao.save(client)).thenReturn(updatedClient);
        //When
        Client theClient = clientService.updateClient(updatedClient, id);
        //Then
        assertEquals("Eastwood", client.getLastName());
    }

    @Test
    public void testUpdateNotExistingClient() {
        //Given
        Long id = 1l;
        Client client = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        when(clientDao.findById(id)).thenReturn(Optional.empty());
        when(clientDao.save(client)).thenReturn(client);
        //When
        Client theClient = clientService.updateClient(client, id);
        //Then
        assertEquals("Malkovich", theClient.getLastName());
    }


    @Test
    public void testDeleteClient() {
        //Given
        Long id = 1l;
        //When
        clientService.deleteClient(id);
        //Then
        verify(clientDao, times(1)).deleteById(id);
    }

}
