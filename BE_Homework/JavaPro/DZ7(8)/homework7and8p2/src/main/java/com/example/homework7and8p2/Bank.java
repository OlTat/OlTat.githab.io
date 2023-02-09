package com.example.homework7and8p2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class Bank {
    static EntityManagerFactory emFactory;
    static EntityManager em;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            emFactory = Persistence.createEntityManagerFactory("JPABankDatabase");
            em = emFactory.createEntityManager();
            Transactions transactions = new Transactions();

            try {
                while (true) {
                    System.out.println("1: Ввод пользователя.");
                    System.out.println("2: Ввод денег.");
                    System.out.println("3: Перечисление денег.");
                    System.out.println("4: Конвертация валюты.");
                    System.out.println("5: Список всех клиентов.");
                    System.out.println("6: Подсчет всех денег.");
                    System.out.print("--> ");

                    String choice = sc.nextLine();
                    switch (choice) {
                        case "1":
                            transactions.addUsers(sc, em);
                            break;
                        case "2":
                            transactions.addMoney(sc, em);
                            break;
                        case "3":
                            transactions.transferOfFunds(sc, em);
                            break;
                        case "4":
                            transactions.conversion(sc, em);
                            break;
                        case "5":
                            showAllUsers();
                            break;
                        case "6":
                            transactions.countMoney(sc, em);
                            break;
                        default:
                            return;
                    }
                }

            } finally {
                emFactory.close();
                em.close();
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    // Подсчет всех денег.
    static void showAllUsers(){
        TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u", Users.class);
        List<Users> list = query.getResultList();
        for (Users users: list) {
            System.out.println(users);
        }
    }
}
