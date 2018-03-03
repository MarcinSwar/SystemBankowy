package pl.sda.service;

import pl.sda.model.Client;

import java.util.Optional;

public interface ClientService {

    Optional<Client> getClientByPESEL(String pesel);

    Optional<Client> getClientByAccountNumber(String accountNumber);
}
