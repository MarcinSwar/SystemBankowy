package pl.sda.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private String name;
    private String surname;
    private String PESEL;
    private String city;
    private String street;
    private String streetNumber;
    private List<Account> accounts;

    public Client(String name, String surname, String PESEL, String city, String street, String streetNumber, List<Account> accounts) {
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPESEL() {
        return PESEL;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public List<Account> getAccounts() {
        if (accounts == null){
            accounts = new ArrayList<>();
        }
        return accounts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(PESEL, client.PESEL) &&
                Objects.equals(city, client.city) &&
                Objects.equals(street, client.street) &&
                Objects.equals(streetNumber, client.streetNumber) &&
                Objects.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, surname, PESEL, city, street, streetNumber, accounts);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
