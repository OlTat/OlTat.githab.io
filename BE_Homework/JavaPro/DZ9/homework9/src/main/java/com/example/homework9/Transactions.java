package com.example.homework9;

import javax.persistence.*;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double amount;

    @ManyToOne

    @JoinColumn(name = "from_accounts_id")
    private Accounts fromAccounts;

    @ManyToOne
    @JoinColumn(name = "to_accounts_id")
    private Accounts toAccounts;

    public Transactions() {
    }

    public Transactions(double amount, Accounts fromAccounts, Accounts toAccounts) {
        this.amount = amount;
        this.fromAccounts = fromAccounts;
        this.toAccounts = toAccounts;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Accounts getFromAccounts() {
        return fromAccounts;
    }

    public void setFromAccounts(Accounts fromAccounts) {
        this.fromAccounts = fromAccounts;
    }

    public Accounts getToAccounts() {
        return toAccounts;
    }

    public void setToAccounts(Accounts toAccounts) {
        this.toAccounts = toAccounts;
    }
}
