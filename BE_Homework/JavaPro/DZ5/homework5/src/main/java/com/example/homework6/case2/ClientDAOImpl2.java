package com.example.homework6.case2;

import com.example.homework6.shared.Client;

import java.sql.Connection;

public class ClientDAOImpl2 extends AbstractDAO<Client> {
    public ClientDAOImpl2(Connection conn, String table) {
        super(conn, table);
    }
}
