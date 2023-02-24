package com.example.homework9;

import javax.persistence.*;
import java.util.List;

@Entity
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double balance;

    private Currencies currencies;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    @OneToMany(mappedBy = "fromAccounts", cascade = CascadeType.ALL)
    private List<Transactions> transactionssFrom;

    @OneToMany(mappedBy = "toAccounts", cascade = CascadeType.ALL)
    private List<Transactions> transactionssTo;

    public Accounts() {
    }

    public Accounts(Double balance, Currencies currencies, Users users) {
        this.balance = balance;
        this.currencies = currencies;
        this.users = users;
    }

    public static List<Accounts> autoCreation(Users users){
        Accounts accountsEUR = new Accounts(0d, Currencies.EUR, users);
        Accounts accountsUSD = new Accounts(0d, Currencies.USD, users);
        Accounts accountsUAH = new Accounts(0d, Currencies.UAH, users);
        return List.of(accountsEUR, accountsUAH, accountsUSD);
    }

    public Long getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currencies currencies) {
        this.currencies = currencies;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Transactions> getTransactionssFrom() {
        return transactionssFrom;
    }

    public void setTransactionssFrom(List<Transactions> transactionssFrom) {
        this.transactionssFrom = transactionssFrom;
    }

    public List<Transactions> getTransactionssTo() {
        return transactionssTo;
    }

    public void setTransactionssTo(List<Transactions> transactionssTo) {
        this.transactionssTo = transactionssTo;
    }
}
