package com.example.homework7and8p2;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float uah = 0;
    private float usd = 0;
    private float eur = 0;
    @OneToOne(mappedBy = "accounts")
    private Users users;

    public Accounts() {
    }

    public Accounts(float uah, float usd, float eur) {
        this.uah = uah;
        this.usd = usd;
        this.eur = eur;

    }

    public int getId() {
        return id;
    }
    public float getUah() {
        return uah;
    }

    public void setUah(float uah) {
        this.uah = uah;
    }

    public float getUsd() {
        return usd;
    }

    public void setUsd(float usd) {
        this.usd = usd;
    }

    public float getEur() {
        return eur;
    }

    public void setEur(float eur) {
        this.eur = eur;
    }

    public Users getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Счет: {" +
                "id=" + id +
                ", Гривны: " + uah + "грн." +
                ", Доллары: " + usd + "$" +
                ", Евро: " + eur + "eur" +
                '}';
    }
}
