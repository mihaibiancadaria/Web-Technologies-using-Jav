package com.project.AirlineEticketing.service;

import com.project.AirlineEticketing.domain.Client;
import com.project.AirlineEticketing.exception.Duplicate;
import com.project.AirlineEticketing.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        Optional<Client> clientWithSameUsername = clientRepository.getByUsername(client.getUsername());
        if (clientWithSameUsername.isPresent()) {
            throw new Duplicate();
        }
        return clientRepository.createClient(client);
    }

    public void updateClient(Client client) {
        clientRepository.updateClient(client);
    }

    public boolean existsByUsername(String Username) {
        return clientRepository.existsByUsername(Username);
    }
}
