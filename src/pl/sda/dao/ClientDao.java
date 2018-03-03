package pl.sda.dao;

import pl.sda.model.Client;

import java.util.List;

public interface ClientDao {

    List<Client> getClients();
    boolean saveClients(List<Client> clients);
    //boolean readClients

}
