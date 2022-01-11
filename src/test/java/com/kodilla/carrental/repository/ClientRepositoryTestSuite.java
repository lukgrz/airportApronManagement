package com.kodilla.carrental.repository;

import com.kodilla.carrental.domain.Client;
import com.kodilla.carrental.domain.Equipment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClientRepositoryTestSuite {

    @Autowired
    private ClientDao clientDao;

    @AfterEach
    public void cleanUpAfterTest() {
        clientDao.deleteAll();
    }

    @Test
    public void testCreateClient() {
        //Given
        Client client = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        //When
        clientDao.save(client);
        Long id = client.getId();
        //Then
        assertTrue(clientDao.existsById(id));
    }

    @Test
    public void testFetchClient() {
        //Given
        Client client = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        clientDao.save(client);
        Long id = client.getId();
        //When
        Optional<Client> resultClient = clientDao.findById(id);
        //Then
        assertNotNull(resultClient);
        assertEquals("John", resultClient.get().getFirstName());
    }

    @Test
    public void testFindAllClient() {
        //Given
        Client client1 = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        Client client2 = new Client("Clint", "Eastwood", "Zabrze", "KE@gamil.com",
                "987654321");
        clientDao.save(client1);
        clientDao.save(client2);
        //When
        List<Client> clientList = clientDao.findAll();
        //Then
        assertEquals(2, clientList.size());
        assertEquals("Clint", clientList.get(1).getFirstName());
    }

    @Test
    public void testDeleteClient() {
        //Given
        Client client1 = new Client("John", "Malkovich", "Katowice", "JM@gamil.com",
                "123456789");
        Client client2 = new Client("Clint", "Eastwood", "Zabrze", "KE@gamil.com",
                "987654321");
        clientDao.save(client1);
        clientDao.save(client2);        //When
        Long id = client1.getId();
        clientDao.deleteById(id);
        //Then
        assertEquals(1, clientDao.findAll().size());
        assertEquals(Optional.empty(), clientDao.findById(id));
    }

}
