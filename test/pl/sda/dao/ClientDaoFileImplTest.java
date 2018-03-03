package pl.sda.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.model.Account;
import pl.sda.model.Client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoFileImplTest {

    private ClientDaoFileImpl clientDaoFile = new ClientDaoFileImpl();

    @Test
    public void testSaveClients(){
        List<Client> clients = new ArrayList<>();
        List<Account> accountsOfFirstClient = new ArrayList<>();
        accountsOfFirstClient.add(new Account("1", new BigDecimal(100.0)));
        accountsOfFirstClient.add(new Account("2", new BigDecimal(150.0)));
        clients.add(new Client("Jan","Kowalski", "12345678910", "warszawa", "Kruczq", "1", accountsOfFirstClient));
        clientDaoFile.saveClients(clients);
    }

    @Test
    public void testGetClients(){
        clientDaoFile.getClients().forEach(System.out::println);
        Assertions.assertEquals(1,clientDaoFile.getClients().size());
        Client client = clientDaoFile.getClients().get(0);
        Assertions.assertEquals("Jan", client.getName());
        
        Assertions.assertEquals(new BigDecimal(150.0), client.getAccounts().get(1).getBalance());
    }


}
