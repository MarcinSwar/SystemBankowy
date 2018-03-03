package pl.sda.view;

import pl.sda.model.Client;
import pl.sda.service.ClientService;
import pl.sda.service.ClientServiceImpl;

import java.util.Optional;
import java.util.Scanner;

public class BankTextView {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ClientService clientService = new ClientServiceImpl();
        int input;


        do{
            System.out.println("Wybierz operację: ");
            System.out.println("0. Zakończ");
            System.out.println("1. Wyszukaj klienta po numerze PESEL");
            System.out.println("2. Wyszukaj klienta po numerze konta");
            input = scanner.nextInt();

            switch (input){
                case 0: System.exit(0);
                case 1: operation1(clientService); break;
                case 2: operation2(clientService);break;
                default:
                    System.out.println("Niepoprawna operacja"); break;
            }

        }while (true);
    }
    private static void operation1(ClientService clientService){
        System.out.println("Podaj PESEL: ");
        String pesel = scanner.next();
        clientService.getClientByPESEL(pesel)
                .ifPresent(System.out::println);
    }

    private static void operation2(ClientService clientService){
        System.out.println("Podaj nr konta");
        String accountNumber = scanner.next();
        Optional<Client> clientOpt = clientService.getClientByAccountNumber(accountNumber);
        if (clientOpt.isPresent()){
            Client client = clientOpt.get();
            System.out.println(client.getName() +" "+ client.getSurname());
            client.getAccounts()
                    .stream()
                    .filter(a-> a.getNumber().equals(accountNumber))
                    .findFirst()
                    .map(a-> a.getBalance())
                    .ifPresent(d-> System.out.println("Stan konta: " + d));
        }

    }
}

