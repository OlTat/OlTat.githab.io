package com.example.homework6.case1;

import com.example.homework6.shared.Client;

import java.util.List;

public interface ClientDAO {
    void createTable();
    void addClient(String name, int age);
    List<Client> getAll();
    long count();
}
