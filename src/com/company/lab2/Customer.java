package com.company.lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    public final int id;
    public String firstName;
    public String middleName;
    public String lastName;
    private String cardNumber = "";
    private String bankNumber = "";

    public Customer (int id, String surname, String name, String middleName) {
        this.id = id;
        this.firstName = name;
        this.middleName = middleName;
        this.lastName = surname;
    }

    public Customer (int id) {
        this.id = id;
        this.firstName = "Тест" + this.id;
        this.middleName = "Тестович" + this.id;
        this.lastName = "Тестовый" + this.id;
    }

    public void setCredentials(String cardNumber, String bankNumber) throws IllegalArgumentException {
        // Some extra validation required
        if (!cardNumber.matches("[0-9]+") | cardNumber.length() < 16)  {
            throw new IllegalArgumentException("Something wrong with card number");
        }
        else if (!bankNumber.matches("[0-9]+") | bankNumber.length() < 16) {
            throw new IllegalArgumentException("Something wrong with bank number");
        }
        this.cardNumber = cardNumber;
        this.bankNumber = bankNumber;
    }

    public Map<String, String> getCredentials() {
        Map<String, String> out = new HashMap<>();
        out.put("card", this.cardNumber);
        out.put("bank", this.bankNumber);
        return out;
    }

    public String toString() {
        return String.format("[%d] : %s, %s %s]",
                this.id, this.lastName, this.firstName, this.middleName);
    }
}
