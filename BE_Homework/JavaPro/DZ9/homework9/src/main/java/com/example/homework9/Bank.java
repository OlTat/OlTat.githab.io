package com.example.homework9;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;
public class Bank {
    private static EntityManagerFactory emFactory;
    private static EntityManager em;

    public static void main(String[] args) {
        emFactory = Persistence.createEntityManagerFactory("JPABankDatabase2");
        em = emFactory.createEntityManager();

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя первого пользователя: ");
        String name1 = sc.nextLine();
        Users users1 = new Users(name1);
        users1.setAccountss(Accounts.autoCreation(users1));
        System.out.print("Введите имя второго пользователя: ");
        String name2 = sc.nextLine();
        Users users2 = new Users(name2);
        users2.setAccountss(Accounts.autoCreation(users2));
        em.persist(users1);
        em.persist(users2);

        // Применение API ПриватБанка для получения курса обмена UAH/USD.
        depositFunds(users1.getId(), Currencies.USD, 100d);

        // Перевод средств со счета одного пользователя на счет другого.
        transferFunds(users1.getId(), Currencies.USD, users2.getId(), Currencies.UAH, 35d);

        // Конвертация валюты по курсу внутри аккаунтов одного пользователя.
        convertCurrencies(users1.getId(), Currencies.EUR, Currencies.UAH, 20d);

        // Получение общих средств на счет одного пользователя в UAН.
        Double total1 = getTotalFundsInUAH(users1.getId());
        System.out.printf("Всего средств у первого пользователя: %.2f грн.", total1);
        System.out.println();
        Double total2 = getTotalFundsInUAH(users2.getId());
        System.out.printf("Всего средств у второго пользователя: %.2f грн.", total2);
        System.out.println();

        // Проверка баланса каждого счета для одного пользователя
        checkEveryBalance(users1.getId());

        checkEveryBalance(users2.getId());

        em.close();
        emFactory.close();
    }

    private static void depositFunds(Long usersId, Currencies currencies, Double amount) {
        Users users = em.find(Users.class, usersId);
        Accounts accounts = getAccountsForUsersAndType(users, currencies);
        accounts.setBalance(accounts.getBalance() + amount);
        em.persist(accounts);
    }

    private static void transferFunds(Long fromUsersId, Currencies fromCurrencies, Long toUsersId, Currencies toCurrencies, Double amount) {
        EntityTransaction transactions = em.getTransaction();
        transactions.begin(); /////

        Users fromUsers = em.find(Users.class, fromUsersId);
        Accounts fromAccounts = getAccountsForUsersAndType(fromUsers, fromCurrencies);
        Double converted = amount;
        if (fromCurrencies.equals(toCurrencies)) {
            fromAccounts.setBalance(fromAccounts.getBalance() - amount);
            em.persist(fromAccounts);
        } else {
            Accounts sameCurrenciesAcc = getAccountsForUsersAndType(fromUsers, toCurrencies);
            converted = convertCurrencies(fromUsersId, fromCurrencies, toCurrencies, amount);
            sameCurrenciesAcc.setBalance(sameCurrenciesAcc.getBalance() - converted);
        }

        Users toUsers = em.find(Users.class, toUsersId);
        Accounts toAccounts = getAccountsForUsersAndType(toUsers, toCurrencies);
        toAccounts.setBalance(toAccounts.getBalance() + (converted));

        em.persist(toAccounts);

        transactions.commit(); /////
    }

    // Применение API ПриватБанка для получения курса обмена UAH/USD.
    private static Double convertCurrencies(Long usersId, Currencies fromCurrencies, Currencies toCurrencies, Double amount) {

        Users users = em.find(Users.class, usersId);
        Accounts fromAccounts = getAccountsForUsersAndType(users, fromCurrencies);
        Accounts toAccounts = getAccountsForUsersAndType(users, toCurrencies);

        // Расчет разницы валюты.
        Double convertedAmount = ExchangeRates.getPrivateBankAPI(fromCurrencies, toCurrencies, amount);

        fromAccounts.setBalance(fromAccounts.getBalance() - (amount));
        toAccounts.setBalance(toAccounts.getBalance() + (convertedAmount));

        em.persist(fromAccounts);
        em.persist(toAccounts);

        return convertedAmount;

    }

    private static Double getTotalFundsInUAH(Long usersId) {
        Users users = em.find(Users.class, usersId);
        List<Accounts> accountss = users.getAccountss();

        Double totalAmountInUAH = 0d;
        for (Accounts accounts : accountss) {

            Currencies accountsType = accounts.getCurrencies();
            ExchangeRates ex = new ExchangeRates(accountsType, Currencies.UAH);
            Double exchangeRates = ex.getRate();
            if (accountsType.equals(Currencies.UAH)) {
                totalAmountInUAH += accounts.getBalance();
            } else {
                totalAmountInUAH += Math.abs(accounts.getBalance() * (exchangeRates));
            }
        }
        return totalAmountInUAH;
    }

    private static void checkEveryBalance(Long usersId) {
        Users users = em.find(Users.class, usersId);
        List<Accounts> accountss = users.getAccountss();

        for (Accounts accounts : accountss) {
            Currencies accountsType = accounts.getCurrencies();
            ExchangeRates ex = new ExchangeRates(accountsType, Currencies.UAH);
            System.out.println(accounts.getBalance() + " " + accountsType);
        }
    }

    private static Accounts getAccountsForUsersAndType(Users users, Currencies currencies) {
        List<Accounts> accountss = users.getAccountss();
        for (Accounts accounts : accountss) {
            if (accounts.getCurrencies().equals(currencies)) {
                return accounts;
            }
        }
        return null;
    }
}
