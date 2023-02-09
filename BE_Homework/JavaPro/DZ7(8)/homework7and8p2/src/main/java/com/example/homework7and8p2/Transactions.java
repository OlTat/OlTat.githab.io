package com.example.homework7and8p2;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class Transactions extends ExchangeRates {
    // Добавление пользователя.
    public void addUsers(Scanner sc, EntityManager em) {
        System.out.print("Введите имя: ");
        String name = sc.nextLine();
        System.out.print("Введите номер паспорта: ");
        String strPassport = sc.nextLine();
        System.out.print("Введите номер телефона: ");
        String strPhone = sc.nextLine();
        Integer passport = Integer.parseInt(strPassport);
        Integer phone = Integer.parseInt(strPhone);

        Users users = new Users(name, passport, phone);
        Accounts accounts = new Accounts();

        users.setAccounts(accounts);

        try {
            em.getTransaction().begin();
            em.persist(users);
            em.getTransaction().commit();
            System.out.println(users);
            System.out.println("Готово");
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    // Пополнение счета в нужной валюте.
    public void addMoney(Scanner sc, EntityManager em) {
        System.out.print("Введите имя пользователя: ");
        String name = sc.nextLine();
        System.out.println("Выберите валюту: ");
        System.out.println("UAH, EUR, USD");
        System.out.print("--> ");
        String currency = sc.nextLine();
        System.out.println("Введите сумму: ");
        String strSum = sc.nextLine();
        float sum = Long.parseLong(strSum);

        try {
            TypedQuery<Users> query = em.createQuery("SELECT ur FROM Users ur where ur.name = :name", Users.class);
            query.setParameter("name", name);
            Users users = query.getSingleResult();
            Accounts accounts = em.find(Accounts.class, users.getAccounts().getId());

            if (currency.equalsIgnoreCase("UAH")) {
                float walletUah = accounts.getUah();
                walletUah += sum;
                accounts.setUah(walletUah);
            } else if (currency.equalsIgnoreCase("EUR")) {
                float walletEur = accounts.getEur();
                walletEur += sum;
                accounts.setEur(walletEur);
            } else if (currency.equalsIgnoreCase("USD")) {
                float walletUsd = accounts.getUsd();
                walletUsd += sum;
                accounts.setUsd(walletUsd);
            } else {
                System.out.println("Ошибка ввода валюты.");
                return;
            }
            try {
                em.getTransaction().begin();
                em.persist(accounts);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
            }

        } catch (NoResultException nre) {
            System.out.println("Данный пользователь не найден.");
        } catch (NonUniqueResultException n) {
            System.out.println("Не найден ни один пользователь.");
        }
    }

    // Перевод средств с одного счета на другой.
    public void transferOfFunds(Scanner sc, EntityManager em) {
        System.out.print("Введите имя отправителя: ");
        String senderName = sc.nextLine();
        System.out.print("Введите имя получателя: ");
        String receiverName = sc.nextLine();

        try {
            TypedQuery<Users> querySender = em.createQuery("SELECT send FROM Users send WHERE send.name = :name", Users.class);
            TypedQuery<Users> queryReceiver = em.createQuery("SELECT recv FROM Users recv WHERE recv.name = :name", Users.class);
            querySender.setParameter("name", senderName);
            queryReceiver.setParameter("name", receiverName);
            Users sender = querySender.getSingleResult();
            Users receiver = queryReceiver.getSingleResult();
            Accounts walletSender = em.find(Accounts.class, sender.getAccounts().getId());
            Accounts walletReceiver = em.find(Accounts.class, receiver.getAccounts().getId());

            System.out.print("Введите валюту: ");
            String currency = sc.nextLine();

            if (currency.equalsIgnoreCase("UAH")) {
                float wSender = walletSender.getUah();
                float wReceiver = walletReceiver.getUah();
                System.out.println("У Вас есть " + wSender + "uah");
                System.out.print("Введите сумму, которую хотите отправить: ");
                String strSum = sc.nextLine();
                float sum = Float.parseFloat(strSum);
                if (wSender >= sum) {
                    wSender -= sum;
                    walletSender.setUah(wSender);
                    wReceiver += sum;
                    walletReceiver.setUah(wReceiver);

                } else {
                    System.out.println("Имеющаяся в наличии сумма не достаточна.");
                    return;
                }

            } else if (currency.equalsIgnoreCase("EUR")) {
                float wSender = walletSender.getEur();
                float wReceiver2 = walletReceiver.getEur();
                System.out.println("У Вас есть " + wSender + "eur");
                System.out.print("Введите сумму, которую хотите отправить: ");
                String strSum = sc.nextLine();
                float sum = Float.parseFloat(strSum);
                if (wSender >= sum) {
                    wSender -= sum;
                    walletSender.setEur(wSender);
                    wReceiver2 += sum;
                    walletReceiver.setEur(wReceiver2);

                } else {
                    System.out.println("Имеющаяся в наличии сумма не достаточна.");
                    return;
                }

            } else if (currency.equalsIgnoreCase("USD")) {
                float wSender = walletSender.getUsd();
                float wReceiver = walletReceiver.getUsd();
                System.out.println("У Вас есть " + wSender + "usd");
                System.out.print("Введите сумму, которую хотите отправить: ");
                String strSum = sc.nextLine();
                float sum = Float.parseFloat(strSum);
                if (wSender >= sum) {
                    wSender -= sum;
                    walletSender.setUsd(wSender);
                    wReceiver += sum;
                    walletReceiver.setUsd(wReceiver);

                } else {
                    System.out.println("Имеющаяся в наличии сумма не достаточна.");
                    return;
                }
            } else {
                System.out.println("Введена неверная валюта.");
                return;
            }

            try {
                em.getTransaction().begin();
                em.persist(walletSender);
                em.persist(walletReceiver);
                em.getTransaction().commit();

            } catch (Exception e) {
                em.getTransaction().rollback();
            }
            System.out.println("Транзакция завершена успешно.");
        } catch (NonUniqueResultException n) {
            System.out.println("Не найден ни один пользователь.");
        } catch (NoResultException noRes) {
            System.out.println("Данный пользователь не найден.");
        }
    }

    // Конвертация валюты по курсу в рамках счетов одного пользователя.
    public void conversion(Scanner sc, EntityManager em) {
        System.out.print("Введите Ваше имя: ");
        String name = sc.nextLine();
        System.out.println("Выберите валюту");
        System.out.println("UAH, EUR, USD");
        String currency = sc.nextLine();

        try {
            TypedQuery<Users> usersQuery = em.createQuery("SELECT u FROM Users u WHERE u.name = :name", Users.class);
            usersQuery.setParameter("name", name);
            Users users = usersQuery.getSingleResult();
            float sum;
            Accounts accounts = em.find(Accounts.class, users.getAccounts().getId());

            // Конвертация гривны в доллары или в евро.

            if (currency.equalsIgnoreCase("UAH")) {
                System.out.println("У Вас есть: " + accounts.getUah() + "uah");
                System.out.println("Какую валюту желаете приобрести?");
                System.out.println("USD, EUR");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("USD")) {
                    System.out.println("Введите сумму.");
                    String strSum = sc.nextLine();
                    sum = Float.parseFloat(strSum);
                    float walletUah = accounts.getUah();
                    if (walletUah >= sum) {
                        float walletUsd = accounts.getUsd();
                        walletUah -= sum;
                        sum = sum / USD;
                        walletUsd += sum;
                        accounts.setUah(walletUah);
                        accounts.setUsd(walletUsd);
                    } else {
                        System.out.println("Вы ввели сумму больше, чем у вас есть.");
                        return;
                    }
                } else if (choice.equalsIgnoreCase("EUR")) {
                    System.out.println("Введите сумму.");
                    String strSum = sc.nextLine();
                    sum = Long.parseLong(strSum);
                    float walletUah = accounts.getUah();
                    if (walletUah >= sum) {
                        float walletEur = accounts.getEur();
                        walletUah -= sum;
                        sum = sum / EUR;
                        walletEur += sum;
                        accounts.setUah(walletUah);
                        accounts.setEur(walletEur);
                    } else {
                        System.out.println("Вы ввели сумму больше, чем у вас есть.");
                        return;
                    }
                } else {
                    System.out.println("Вы выбрали неверную валюту.");
                }
            }

            // Конвертация доллара в гривну или в евро.

            if (currency.equalsIgnoreCase("USD")) {
                System.out.println("У Вас есть " + accounts.getUsd() + "usd");
                System.out.println("Какую валюту желаете приобрести?");
                System.out.println("UAH, EUR");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("UAH")) {
                    System.out.println("Введите сумму.");
                    String strSum = sc.nextLine();
                    sum = Float.parseFloat(strSum);
                    float walletUsd = accounts.getUsd();
                    if (walletUsd >= sum) {
                        float walletUah = accounts.getUah();
                        walletUsd -= sum;
                        sum = sum * USD;
                        walletUah += sum;
                        accounts.setUsd(walletUsd);
                        accounts.setUah(walletUah);

                    }else {
                        System.out.println("Вы ввели сумму больше, чем у вас есть.");
                        return;
                    }
                } else if (choice.equalsIgnoreCase("EUR")) {
                    System.out.println("Введите сумму.");
                    String strSum = sc.nextLine();
                    sum = Float.parseFloat(strSum);
                    float walletUsd = accounts.getUsd();
                    if (walletUsd >= sum){
                        float walletEur = accounts.getEur();
                        walletUsd -= sum;
                        sum = sum * USD / EUR;
                        walletEur += sum;
                        accounts.setUsd(walletUsd);
                        accounts.setEur(walletEur);
                    }else {
                        System.out.println("Вы ввели сумму больше, чем у вас есть.");
                        return;
                    }
                }
            }else {
                System.out.println("Вы выбрали неверную валюту.");
            }

            // Конвертация евро в гривну или в доллар.

            if (currency.equalsIgnoreCase("EUR")){
                System.out.println("У Вас есть " + accounts.getEur() + "eur");
                System.out.println("Какую валюту желаете приобрести?");
                System.out.println("UAH, USD");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("UAH")){
                    System.out.println("Введите сумму.");
                    String strSum = sc.nextLine();
                    sum = Float.parseFloat(strSum);
                    float walletEur = accounts.getEur();
                    if (walletEur >= sum) {
                        float walletUah = accounts.getUah();
                        walletEur -= sum;
                        sum = sum * USD;
                        walletUah += sum;
                        accounts.setEur(walletEur);
                        accounts.setUah(walletUah);
                    }else {
                        System.out.println("Вы ввели сумму больше, чем у вас есть.");
                        return;
                    }
                } else if (choice.equalsIgnoreCase("USD")) {
                    System.out.println("Введите сумму.");
                    String strSum = sc.nextLine();
                    sum = Float.parseFloat(strSum);
                    float walletEur = accounts.getEur();
                    if (walletEur >= sum) {
                        float walletUsd = accounts.getUsd();
                        walletEur -= sum;
                        sum = sum * EUR / USD;
                        walletUsd += sum;
                        accounts.setEur(walletEur);
                        accounts.setUsd(walletUsd);
                    }
                }
            }

            try {
                em.getTransaction().begin();
                em.persist(accounts);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }

        } catch (NoResultException nre) {
            System.out.println("Данный пользователь не найден.");
        } catch (NonUniqueResultException nue) {
            System.out.println("Не найден ни один пользователь.");
        }
    }

    // Получение суммарных средств на счету одного пользователя в UAH (расчет по курсу).
    public void countMoney(Scanner sc, EntityManager em){
        System.out.print("Введите имя: ");
        String name = sc.nextLine();
        float result;
        try{
            TypedQuery<Users> typedQuery = em.createQuery("SELECT u FROM Users u WHERE u.name = :name", Users.class);
            typedQuery.setParameter("name", name);
            Users users = typedQuery.getSingleResult();
            Accounts accounts = em.find(Accounts.class, users.getAccounts().getId());
            float usd = accounts.getUsd() * USD;
            float uah = accounts.getUah();
            float eur = accounts.getEur() * EUR;
            result  = usd + uah + eur;

            System.out.println("Все ваши средства: " +result + " грн.");
        }catch (NoResultException nre){
            System.out.println("Данный пользователь не найден.");
        }catch (NonUniqueResultException nue) {
            System.out.println("Не найден ни один пользователь.");
        }
    }
}
