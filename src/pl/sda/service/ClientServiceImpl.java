package pl.sda.service;

import pl.sda.dao.ClientDao;
import pl.sda.dao.ClientDaoFileImpl;
import pl.sda.model.Client;

import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao = new ClientDaoFileImpl();

    @Override
    public Optional<Client> getClientByPESEL(String pesel) {

        return clientDao.getClients()
                .stream()
                .filter(c -> c.getPESEL().equals(pesel))
                .findFirst();

    }

    @Override
    public Optional<Client> getClientByAccountNumber(String accountNumber) {
        return clientDao.getClients()
                .stream()
                .filter(c ->
                        c.getAccounts()
                                .stream()
                                .anyMatch(a -> a.getNumber().equals(accountNumber)))
                .findFirst();


    }
}
