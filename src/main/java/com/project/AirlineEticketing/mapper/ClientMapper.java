package com.project.AirlineEticketing.mapper;


import com.project.AirlineEticketing.dto.*;
import com.project.AirlineEticketing.domain.*;
import org.springframework.stereotype.*;

@Component
public class ClientMapper {

    public Client clientDtoToClient(ClientDto clientDto) {
        return new Client(clientDto.getUsername(), clientDto.getPassword(), clientDto.getFullName(), clientDto.getCNP(), clientDto.getMail(), clientDto.getGender());
    }

    public Client updateClientDtoToClient(UpdateClientDto updateClientDto) {
        return new Client(updateClientDto.getClientID(), updateClientDto.getUsername(), updateClientDto.getPassword(), updateClientDto.getFullName(), updateClientDto.getCNP(), updateClientDto.getMail(), updateClientDto.getGender());
    }
//    @Mappings(
//            {
//                    @Mapping(target = "ClientID", source = "Clients.ClientID"),
//                    @Mapping(target = "Username", source = "Clients.Username"),
//                    @Mapping(target = "Password", source = "Clients.Password"),
//                    @Mapping(target = "FullName", source = "Clients.FullName"),
//                    @Mapping(target = "CNP", source = "Clients.CNP"),
//                    @Mapping(target = "Mail", source = "Clients.Mail"),
//                    @Mapping(target = "Gender", source = "Clients.Gender")
//            }
//    )
//    ClientDto mapToDto(Client client);
//
//    @Mappings(
//            {
//                    @Mapping(target = "Clients.ClientID", source = "ClientID"),
//                    @Mapping(target = "Clients.Username", source = "Username"),
//                    @Mapping(target = "Clients.Password", source = "Password"),
//                    @Mapping(target = "Clients.FullName", source = "FullName"),
//                    @Mapping(target = "Clients.CNP", source = "CNP"),
//                    @Mapping(target = "Clients.Mail", source = "Mail"),
//                    @Mapping(target = "Clients.Gender", source = "Gender")
//            }
//    )
//    Client mapToEntity(ClientDto clientDto);

}
