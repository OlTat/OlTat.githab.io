package com.example.homework7and8p2;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String  name;
    @Column(name = "passport_number")
    private Integer passportNumber;
    private Integer phone;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet")
    private Accounts accounts;

    public Users() {
    }

    public Users(String name, Integer passportNumber, Integer phone) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Клиент: {" +
                "id=" + id +
                ", Имя: " + name +
                ", Паспорт: " + passportNumber +
                ", Телефон: " + phone +
                ", Счет: " + accounts +
                '}';
    }
}
