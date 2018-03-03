package pl.sda.dao;

import pl.sda.model.Account;
import pl.sda.model.Client;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoFileImpl implements ClientDao {

    private static final String FILE_NAME = "datasource.txt";
    private static final String CLIENT = "CLIENT";
    private static final String ACCOUNT = "ACCOUNT";
    private static final String DELIMITER = ";";
    private static final Path PATH = Paths.get(FILE_NAME);

    @Override
    public List<Client> getClients() {

        List<Client> clients = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(PATH);
            for (String line: lines){
                String[] tab = line.split(DELIMITER);
                if(tab[0].equals(CLIENT)){
                    clients.add(getClientWithGivenParams(tab));
                }else if (tab[0].equals(ACCOUNT)){
                    clients.get(clients.size() - 1)
                            .getAccounts()
                            .add(getAccountWithGivenParams(tab));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }

    private Client getClientWithGivenParams(String[] params){

        return new Client(params[1], params[2], params[3], params[4], params[5], params[6], new ArrayList<>());
    }

    private Account getAccountWithGivenParams(String[] params){
        return new Account(params[1], new BigDecimal(params[2]));
    }

    @Override
    public boolean saveClients(List<Client> clients) {

        try {
            for (Client client: clients){
                Files.write(PATH, getClientAsString(client).getBytes(), StandardOpenOption.APPEND);

                for (Account account: client.getAccounts()) {
                    Files.write(PATH, getAccountAsString(account).getBytes(), StandardOpenOption.APPEND);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String getClientAsString(Client client){

        StringBuilder sb = new StringBuilder();
        sb.append(CLIENT)
                .append(DELIMITER)
                .append(client.getName())
                .append(DELIMITER)
                .append(client.getSurname())
                .append(DELIMITER)
                .append(client.getPESEL())
                .append(DELIMITER)
                .append(client.getCity())
                .append(DELIMITER)
                .append(client.getStreet())
                .append(DELIMITER)
                .append(client.getStreetNumber())
                .append("\n");

        return sb.toString();
    }

    private String getAccountAsString(Account account){
        StringBuilder sb = new StringBuilder();

        sb.append(ACCOUNT)
                .append(DELIMITER)
                .append(account.getNumber())
                .append(DELIMITER)
                .append(account.getBalance())
                .append("\n");
        return sb.toString();
    }
}
