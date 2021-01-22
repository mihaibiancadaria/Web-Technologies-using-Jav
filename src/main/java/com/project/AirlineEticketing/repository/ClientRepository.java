package com.project.AirlineEticketing.repository;
import com.project.AirlineEticketing.domain.Airport;
import com.project.AirlineEticketing.domain.Client;
import com.project.AirlineEticketing.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {


    private JdbcTemplate jdbcTemplate;


    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Client createClient(Client client) {
        String sql = "insert into clients values (null, ?, ?, ?, ?, ?, ?)";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getUsername());
            preparedStatement.setString(2, client.getPassword());
            preparedStatement.setString(3, client.getFullName());
            preparedStatement.setString(4, client.getCNP());
            preparedStatement.setString(5, client.getMail());
            preparedStatement.setString(6, client.getGender());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);


        return client;
    }

    public Optional<Client> getByUsername(String Username) {
        String sql = "select * from clients c where c.Username = ?";
        List<Client> result = jdbcTemplate.query(sql, getClientRowMapper(), Username);
        if (result != null && !result.isEmpty()) {
            return Optional.of(result.get(0));
        } else {
            return Optional.empty();
        }
    }

    public void updateClient(Client client) {
        String sql = "update clients c set c.Username = ?, c.Password = ?, c.FullName = ?, c.CNP = ?, c.Mail = ?, c.Gender = ? where c.ClientID = ?";
        jdbcTemplate.update(sql, client.getClientID(), client.getUsername(), client.getPassword(), client.getFullName(), client.getCNP(), client.getMail(), client.getGender());
    }

    public boolean existsByUsername(String Username) {
        String sql = "select * from clients c where c.Username = ?";
        List<Client> result = jdbcTemplate.query(sql, getClientRowMapper(), Username);
        if (result != null && !result.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private RowMapper<Client> getClientRowMapper() {
        return (resultSet, rowNum) -> {
            Client client = new Client();
            client.setUsername(resultSet.getString("Username"));
            client.setPassword(resultSet.getString("Password"));
            client.setFullName(resultSet.getString("FullName"));
            client.setCNP(resultSet.getString("CNP"));
            client.setMail(resultSet.getString("Mail"));
            client.setGender(resultSet.getString("Gender"));
            return client;
        };
    }


//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public Client save(Client client) {
//        String saveClientSql = "INSERT INTO clients (Username, Password, FullName, CNP, Mail, Gender) VALUES (?, ?, ?, ?, ?, ?)";
//        jdbcTemplate.update(saveClientSql, client.getUsername(), client.getFullName(), client.getCNP(), client.getMail(), client.getGender());
//
//        Client savedClient = getClientWith(client.getUsername());
//
//
//        return savedClient;
//    }
//
//    public List<Client> getAll() {
//        String selectSql = "SELECT * from clients";
//
//        RowMapper<Client> rowMapper = (resultSet, rowNo) -> Client.builder()
//                .Username(resultSet.getString("Username"))
//                .FullName(resultSet.getString("FullName"))
//                .Mail(resultSet.getString("Mail"))
//                .Gender(resultSet.getString("Gender"))
//                .build();
//
//        return jdbcTemplate.query(selectSql, rowMapper);
//    }
//
//    public Client get(String Username) {
//        return getClientWith(Username);
//    }
//
//    private Client getClientWith(String Username) {
//        String selectSql = "SELECT * from Clints WHERE Client.Username = ?";
//
//        RowMapper<Client> rowMapper = (resultSet, rowNo) -> Client.builder()
//                .Username(resultSet.getString("Username"))
//                .FullName(resultSet.getString("FullName"))
//                .Mail(resultSet.getString("Mail"))
//                .Gender(resultSet.getString("Gender"))
//                .build();
//
//        List<Client> clients = jdbcTemplate.query(selectSql, rowMapper, Username);
//
//        if (null != clients && !clients.isEmpty()) {
//            return clients.get(0);
//        }
//        throw new EntityNotFoundException(Username);
//    }
}
