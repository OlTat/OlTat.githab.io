package oop_dz_2_v2;

/*
 *  Проработать предметную область для приложения по букингу билетов в кинотеатр.
 *  Создать систему классов, позволяющую пользователям бронировать билеты на разные сеансы в
 *  разных залах (зал должен содержать ряды и места).
 *  Реализовать залы с помощью наследования (обычный, 4д, мини).
 *  Написать метод для бронирования конкретного места на конкретный сеанс.
 *  Написать метод для бронирования первого попавшегося свободного места на любой сеанс.
 */

import java.util.Scanner;
public class Booking {

    public Booking() {
    }

    public static void main(String[] args) {
        Afisha af = new Afisha();
        af.afisha_in ();

        Booking.ord();
    }

    public static void ord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип заказа. Срочный или Предварительный: ");
        String t = scanner.nextLine();
        while (!t.equals("Вввввддд")) {
            if (t.equals("Срочный")) {
                Order urgent = new Order(t); // срочный заказ //
                System.out.println(urgent);
                System.out.println();
                break;
            } else if (t.equals("Предварительный")) {
                Order preliminary = new Order(t); // предварительный заказ //
                System.out.println(preliminary);
                System.out.println();
                break;
            } else {
                System.out.println("Ошибка ввода типа заказа.");
                System.out.println("Введите тип заказа. Срочный или Предварительный: ");
                t = scanner.nextLine();
            }
        }
        System.out.println("Введите день заказа, согласно афиши: ");
        String d = scanner.nextLine();
        InputChecks ic = new InputChecks(t, d);
        ic.input_day_film(t, d);
    }
}
