package com.example.homework9;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Accounts> accountss;

    public Users() {
    }

    public Users(String name){
        this.name = name;
    }

    public Users(String name, List<Accounts> accountss) {
        this.name = name;
        this.accountss = accountss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Accounts> getAccountss() {
        return accountss;
    }

    public void setAccountss(List<Accounts> accountss) {
        this.accountss = accountss;
    }

    public Long getId() {
        return id;
    }
}
