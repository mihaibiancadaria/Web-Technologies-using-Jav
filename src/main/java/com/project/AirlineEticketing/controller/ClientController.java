package com.project.AirlineEticketing.controller;


import com.project.AirlineEticketing.dto.*;
import com.project.AirlineEticketing.mapper.*;
import com.project.AirlineEticketing.domain.*;
import com.project.AirlineEticketing.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private  ClientService clientService;
    private  ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(
            @RequestBody
            @Valid
                    ClientDto clientDto) {
        Client savedClient = clientService.createClient(clientMapper.clientDtoToClient(clientDto));
        return ResponseEntity
                .created(null)
                .body(savedClient);
    }

    @PutMapping("/{ClientID}")
    public void updateClient(
            @PathVariable
                    Long ClientID,
            @RequestBody
            @Valid
                    UpdateClientDto updateClientDto) {
        if(ClientID != updateClientDto.getClientID()) {
            throw new RuntimeException("Path variable doesn't match the request body id");
        }
        clientService.updateClient(clientMapper.updateClientDtoToClient(updateClientDto));
    }
}
