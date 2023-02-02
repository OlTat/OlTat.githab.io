package com.example.homework6;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class App {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            emf = Persistence.createEntityManagerFactory("JPAHousing");
            em = emf.createEntityManager();
            try {
                while (true) {
                    System.out.println("1: Добавление квартиры.");
                    System.out.println("2: Поиск квартиры по параметру.");
                    System.out.println("3: Демонстрация всех квартир.");
                    System.out.println("4: Удаление квартиры.");
                    System.out.print("--> ");

                    String options = sc.nextLine();
                    switch (options) {
                        case "1":
                            addHousing(sc);
                            break;
                        case "2":
                            apartmentOptions(sc);
                            break;
                        case "3":
                            showAllApartments();
                            break;
                        case "4":
                            deleteHousing(sc);
                            break;
                        default:
                            return;
                    }
                }

            } finally {
                emf.close();
                em.close();


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public static void addHousing(Scanner sc) {
        System.out.print("Введите район: ");
        String area = sc.nextLine();
        System.out.print("Введите адрес: ");
        String address = sc.nextLine();
        System.out.print("Введите площадь квартиры (м2): ");
        String strSpace = sc.nextLine();
        System.out.print("Введите количество комнат: ");
        String strRoom = sc.nextLine();
        System.out.print("Введите цену (за м2 в грн.): ");
        String strPrice = sc.nextLine();

        float space = Float.parseFloat(strSpace);
        int room = Integer.parseInt(strRoom);
        int price = Integer.parseInt(strPrice);

        em.getTransaction().begin();
        try {
            Housing housing = new Housing(area, address, space, room, price);
            em.persist(housing);
            em.getTransaction().commit();
            System.out.println(housing.getId());
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public static void apartmentOptions(Scanner sc) {
        System.out.println("Выберите интересующий Вас параметр.");
        System.out.println("1: Район");
        System.out.println("2: Адрес");
        System.out.println("3: Площадь квартиры");
        System.out.println("4: Количество комнат");
        System.out.println("5: Цена");

        System.out.print("--> ");
        String userOptions = sc.nextLine();
        Housing hous = null;

        try{
            if (userOptions.equals("1")) {
                System.out.print("Укажите район: ");
                String area = sc.nextLine();
                Query query = em.createQuery("SELECT a FROM Housing a WHERE a.area = :area", Housing.class);
                query.setParameter("area", area);
                hous = (Housing) query.getSingleResult();
                System.out.println(hous);

            } else if (userOptions.equals("2")) {
                System.out.print("Укажите адрес: ");
                String address = sc.nextLine();
                Query query = em.createQuery("SELECT a FROM Housing a WHERE a.address = :address", Housing.class);
                query.setParameter("address", address);
                hous = (Housing) query.getSingleResult();
                System.out.println(hous);

            } else if (userOptions.equals("3")) {
                System.out.print("Укажите площадь: ");
                String strSpace = sc.nextLine();
                double space = Double.parseDouble(strSpace);
                Query query = em.createQuery("SELECT a FROM Housing a WHERE a.space = :space", Housing.class);
                query.setParameter("space", space);
                hous = (Housing) query.getSingleResult();
                System.out.println(hous);

            } else if (userOptions.equals("4")) {
                System.out.print("Укажите количество комнат: ");
                String strRoom = sc.nextLine();
                int room  = Integer.parseInt(strRoom);
                Query query = em.createQuery("SELECT a FROM Housing a WHERE a.room = :room", Housing.class);
                query.setParameter("room", room);
                hous = (Housing) query.getSingleResult();
                System.out.println(hous);

            } else if (userOptions.equals("5")) {
                System.out.print("Укажите цену: ");
                String strPrice = sc.nextLine();
                int price = Integer.parseInt(strPrice);
                Query query = em.createQuery("SELECT a FROM Housing a WHERE a.price = :price", Housing.class);
                query.setParameter("price", price);
                hous = (Housing) query.getSingleResult();
                System.out.println(hous);


            } else {
                System.out.println("Ошибка ввода номера.");
                return;
            }
        }catch (NoResultException nre) {
            System.out.println("Такой квартиры нет.");
            return;
        } catch (NonUniqueResultException nure) {
            System.out.println("Таких квартир больше одной. Воспользуйтесь общим просмотром квартир");
            return;
        }
    }

    public static void showAllApartments(){
        Query query = em.createQuery("SELECT x FROM Housing x", Housing.class);
        List<Housing> list = query.getResultList();
        for (Housing h: list) {
            System.out.println(h);
        }
    }

    private static void deleteHousing(Scanner sc) {
        System.out.print("Введите id удаляемой квартиры: ");
        String sId = sc.nextLine();
        int id = Integer.parseInt(sId);

        Housing hs = em.getReference(Housing.class, id);
        if (hs == null) {
            System.out.println("Ошибка ввода.");
            return;
        }

        em.getTransaction().begin();
        try {
            em.remove(hs);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }
}
