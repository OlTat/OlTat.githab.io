package com.example.homework7and8p1;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class Database {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            emf = Persistence.createEntityManagerFactory("JPAOrderDatabase");
            em = emf.createEntityManager();

            try{
                while(true) {
                    System.out.println("1: Добавление клиента.");
                    System.out.println("2: Добавление товара.");
                    System.out.println("3: Оформление заказа.");
                    System.out.println("4: Посмотр всех товаров.");
                    System.out.println("5: Просмотр всех клиентов.");
                    System.out.print("--> ");

                    String options = sc.nextLine();
                    switch (options) {
                        case "1":
                            addClient(sc);
                            break;
                        case "2":
                            addGood(sc);
                            break;
                        case "3":
                            createOrder(sc);
                            break;
                        case "4":
                            showGoods();
                            break;
                        case "5":
                            showClients();
                            break;
                        default:
                            return;
                    }
                }
            } finally {
                sc.close();
                em.close();
                emf.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addClient(Scanner sc) {
        System.out.print("Введите имя клиента: ");
        String name = sc.nextLine();
        System.out.print("Введите email клиента: ");
        String email = sc.nextLine();
        System.out.print("Введите адрес клиента: ");
        String address = sc.nextLine();
        System.out.print("Введите телефон клиента: ");
        String phone = sc.nextLine();

        em.getTransaction().begin();
        try {
            Clients c = new Clients(name, email, address, phone);
            em.persist(c);
            em.getTransaction().commit();
            System.out.println(c.getId());
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    public static void addGood(Scanner sc) {
        System.out.print("Введите наименование товара: ");
        String nProd = sc.nextLine();
        System.out.print("Введите производителя: ");
        String company = sc.nextLine();
        System.out.print("Введите цену: ");
        String sPrice = sc.nextLine();
        Double price = Double.parseDouble(sPrice);

        em.getTransaction().begin();
        try {
            Goods g = new Goods(nProd, price, company);
            em.persist(g);
            em.getTransaction().commit();

            System.out.println(g.getId());
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    public static void createOrder(Scanner sc) {

        int countGoods = showGoods();


        int countClients = showClients();

        System.out.print("Введите id клиента: ");
        String sId = sc.nextLine();
        long clientId = 0;
        try{
            clientId = Long.parseLong(sId);
            if (clientId == 0 || clientId > countClients) throw new Exception();
        } catch (Exception ex) {
            System.out.println("Нет клиента с таким id.");
            return;
        }

        Clients c = em.getReference(Clients.class, clientId);


        long orderId = 0;
        em.getTransaction().begin();
        try {
            Orders order = new Orders(c.getName(), c.getEmail(), c.getAddress(), c.getPhone());
            System.out.println(order);
            order.setClient(c);

            em.persist(order);
            em.getTransaction().commit();

            orderId = order.getId();
            System.out.println("Id заказа: " + orderId);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return;
        }

        Orders order = em.getReference(Orders.class, orderId);

        Boolean check = true;
        while (check) {
            System.out.print("Введите id товара ('0' для выхода): ");
            String sProdId = sc.nextLine();
            try{
                long prodId = Long.parseLong(sProdId);
                if (prodId == 0) check = false;
                else if(prodId > countGoods) throw new Exception();
                else {
                    em.getTransaction().begin();
                    try {
                        Goods good = em.getReference(Goods.class, prodId);
                        System.out.println(good);
                        order.addGood(good);
                        em.persist(order);
                        em.getTransaction().commit();
                        System.out.println("Добавлен товар.");
                    } catch (Exception ex) {
                        em.getTransaction().rollback();
                    }
                }
            } catch (Exception ex) {
                System.out.println("Такого товара нет.");
            }
        }
    }

    public static int showGoods() {
        Query query = em.createQuery("SELECT g FROM Goods g", Goods.class);
        List<Goods> list = (List<Goods>) query.getResultList();

        System.out.println("---------Товары----------");
        for (Goods g: list) {
            System.out.println(g.getId() + ". " + g.getGoodName() + " - " + g.getPrice());
        }
        System.out.println("Счетчик товаров: " + list.size());
        System.out.println("--------------------------");
        return list.size();
    }

    public static int showClients() {
        Query query = em.createQuery("SELECT c FROM Clients c", Clients.class);
        List<Clients> list = (List<Clients>) query.getResultList();

        System.out.println("---------Клиенты----------");
        for (Clients c: list) {
            System.out.println(c);
        }
        System.out.println("Счетчик клиентов: " + list.size());
        System.out.println("--------------------------");
        return list.size();
    }
}
