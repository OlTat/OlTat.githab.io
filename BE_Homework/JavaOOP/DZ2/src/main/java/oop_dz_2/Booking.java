package oop_dz_2;

/*
 *  Проработать предметную область для приложения по букингу билетов в кинотеатр.
 *  Создать систему классов, позволяющую пользователям бронировать билеты на разные сеансы в
 *  разных залах (зал должен содержать ряды и места).
 *  Реализовать залы с помощью наследования (обычный, 4д, мини).
 *  Написать метод для бронирования конкретного места на конкретный сеанс.
 *  Написать метод для бронирования первого попавшегося свободного места на любой сеанс.
 */

import org.example.Control;

import java.util.Arrays;
import java.util.Scanner;

public class Booking {
    public static void main(String[] args) {

        String afisha[][] = {{"_____________", "________", "______", "_________"},
                {"|___День____|", "_Фильм__|", "Сеанс|", "__Зал___|"},
                {"|Понедельник|", "Сталкер |", "10:00|", "Основной|"},
                {"|Понедельник|", "Ясмин   |", "14:00|", "4D      |"},
                {"|Понедельник|", "Лолита  |", "18:00|", "Mini    |"},
                {"|Понедельник|", "Харакири|", "22:00|", "Основной|"},
                {"_____________", "_________", "______", "_________"},
                {"|Вторник    |", "Харакири|", "10:00|", "4D      |"},
                {"|Вторник    |", "Сталкер |", "14:00|", "Mini    |"},
                {"|Вторник    |", "Ясмин   |", "18:00|", "Основной|"},
                {"|Вторник    |", "Лолита  |", "22:00|", "4D      |"},
                {"_____________", "_________", "______", "_________"},
                {"|Среда      |", "Лолита  |", "10:00|", "Mini    |"},
                {"|Среда      |", "Харакири|", "14:00|", "Основной|"},
                {"|Среда      |", "Сталкер |", "18:00|", "4D      |"},
                {"|Среда      |", "Ясмин   |", "22:00|", "Mini    |"},
                {"_____________", "________", "______", "__________"}};
        System.out.println("                     АФИША                    ");
        Arrays.stream(afisha).map(Arrays::toString).forEach(System.out::println);

        Scanner input = new Scanner(System.in);
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
        System.out.println("Введите фильм, согласно афиши: ");
        String f = scanner.nextLine();
        String s;
        String h;
        String r;
        String p;
        int gl;
        int pc;
        int cl;
        while (!d.equals(f)) {
            if (d.equals("Понедельник")) {
                while (!d.equals(f)) {
                    if (d.equals("Понедельник") && f.equals("Сталкер")) {
                        s = "10:00";
                        h = "Основной";
                        gl = 0;
                        pc = 0;
                        cl = 0;
                        if (t.equals("Срочный")) {
                            String zanytost_osn_urgent[][] = {
                                    {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "Х", "3", "Х", "5", "6", "Х", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "Х", "2", "Х", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"9", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"10", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ОСНОВНОМ ЗАЛЕ   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_osn_urgent).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд со свободным местом: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8") || r.equals("9")
                                        || r.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд со свободным местом: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите свободное место: ");
                            p = scanner.nextLine();
                            int k = 0;
                            for (int g = 0; g < 10; g++) {
                                for (int i = 0; i < zanytost_osn_urgent.length; i++) {
                                    for (int j = 1; j < zanytost_osn_urgent[1].length; j++) {
                                        if (zanytost_osn_urgent[i][0].equals(r) &&
                                                zanytost_osn_urgent[i][j].equals(p)) {
                                            k = k + 1;
                                        }
                                    }
                                }
                                if (k == 0) {
                                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                                    p = scanner.nextLine();
                                } else {
                                    g = 10;
                                    break;
                                }
                            }
                        } else {
                            String zanytost_osn_preliminary[][] = {
                                    {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"9", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"10", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ОСНОВНОМ ЗАЛЕ   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_osn_preliminary).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8")
                                        || r.equals("9") || r.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите место: ");
                            p = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4") ||
                                        p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") ||
                                        p.equals("9") || p.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода места. Введите заново место: ");
                                    p = scanner.nextLine();
                                }
                            }
                        }
                        Hall_common osn = new Hall_common(t, d, f, s, r, p); // основной зал //
                        System.out.println(osn);
                        System.out.println();
                        Fiscal_receipt fr = new Fiscal_receipt(t, d, f, s, h, r, p, gl, pc, cl); // расчет стоимости //
                        System.out.println(fr);
                        System.out.println();
                        break;
                    } else if (d.equals("Понедельник") && f.equals("Ясмин")) {
                        s = "14:00";
                        h = "4D";
                        pc = 0;
                        cl = 0;
                        if (t.equals("Срочный")) {
                            String zanytost_4D_urgent[][] = {
                                    {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "Х", "3", "Х", "5", "6", "Х", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "Х", "2", "Х", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D  ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_4D_urgent).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд со свободным местом: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд со свободным местом: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите свободное место: ");
                            p = scanner.nextLine();
                            int k = 0;
                            for (int g = 0; g < 10; g++) {
                                for (int i = 0; i < zanytost_4D_urgent.length; i++) {
                                    for (int j = 1; j < zanytost_4D_urgent[1].length; j++) {
                                        if (zanytost_4D_urgent[i][0].equals(r) && zanytost_4D_urgent[i][j].equals(p)) {
                                            k = k + 1;
                                        }
                                    }
                                }
                                if (k == 0) {
                                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                                    p = scanner.nextLine();
                                } else {
                                    g = 10;
                                    break;
                                }
                            }
                        } else {
                            String zanytost_4D_preliminary[][] = {
                                    {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_4D_preliminary).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите место: ");
                            p = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4") ||
                                        p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") ||
                                        p.equals("9") || p.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода места. Введите заново место: ");
                                    p = scanner.nextLine();
                                }
                            }
                        }

                        System.out.println("Введите количество 4D очков (из расчета 1 4D очки на 1 место): ");
                        gl = input.nextInt();
                        while (!d.equals(f)) {
                            if (gl == 1) {
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Ошибка ввода количества 4D очков. Введите заново " +
                                        "количество 4D очков (из расчета 1 4D очки на 1 место): ");
                                gl = input.nextInt();
                            }
                        }
                        Hall_four_d fd = new Hall_four_d(t, d, f, s, r, p, gl); // зал 4D //
                        System.out.println(fd);
                        System.out.println();
                        Fiscal_receipt fr = new Fiscal_receipt(t, d, f, s, h, r, p, gl, pc, cl); // расчет стоимости //
                        System.out.println(fr);
                        System.out.println();
                        break;
                    } else if (d.equals("Понедельник") && f.equals("Лолита")) {
                        s = "18:00";
                        h = "Mini";
                        gl = 0;
                        if (t.equals("Срочный")) {
                            String zanytost_mini_urgent[][] = {
                                    {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D  ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_mini_urgent).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд со свободным местом: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд со свободным местом: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите свободное место: ");
                            p = scanner.nextLine();
                            int k = 0;
                            for (int g = 0; g < 10; g++) {
                                for (int i = 0; i < zanytost_mini_urgent.length; i++) {
                                    for (int j = 1; j < zanytost_mini_urgent[1].length; j++) {
                                        if (zanytost_mini_urgent[i][0].equals(r) && zanytost_mini_urgent[i][j].equals(p)) {
                                            k = k + 1;
                                        }
                                    }
                                }
                                if (k == 0) {
                                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                                    p = scanner.nextLine();
                                } else {
                                    g = 10;
                                    break;
                                }
                            }
                        } else {
                            String zanytost_mini_preliminary[][] = {
                                    {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_mini_preliminary).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите место: ");
                            p = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4") ||
                                        p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") ||
                                        p.equals("9") || p.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода места. Введите заново место: ");
                                    p = scanner.nextLine();
                                }
                            }
                        }

                        System.out.println("Введите количество порций попкорна (лимит 10 порций): ");
                        pc = input.nextInt();
                        while (!d.equals(f)) {
                            if (pc > 0 && pc < 11) {
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Ошибка ввода количества порций попкорна. Введите заново " +
                                        "количество порций попкорна (лимит 10 порций): ");
                                pc = input.nextInt();
                            }
                        }

                        System.out.println("Введите количество порций колы (лимит 10 порций): ");
                        cl = input.nextInt();
                        while (!d.equals(f)) {
                            if (cl > 0 && cl < 11) {
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Ошибка ввода количества порций колы. Введите заново " +
                                        "количество порций колы (лимит 10 порций): ");
                                cl = input.nextInt();
                            }
                        }
                        Hall_mini m = new Hall_mini(t, d, f, s, r, p, pc, cl); // зал mini //
                        System.out.println(m);
                        System.out.println();
                        Fiscal_receipt fr = new Fiscal_receipt(t, d, f, s, h, r, p, gl, pc, cl); // расчет стоимости //
                        System.out.println(fr);
                        System.out.println();
                        break;
                    } else if (d.equals("Понедельник") && f.equals("Харакири")) {
                        s = "22:00";
                        h = "Основной";
                        gl = 0;
                        pc = 0;
                        cl = 0;
                        if (t.equals("Срочный")) {
                            String zanytost_osn_urgent[][] = {
                                    {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "Х", "3", "Х", "5", "6", "Х", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "Х", "2", "Х", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"9", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"10", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ОСНОВНОМ ЗАЛЕ   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_osn_urgent).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд со свободным местом: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8") || r.equals("9")
                                        || r.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд со свободным местом: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите свободное место: ");
                            p = scanner.nextLine();
                            int k = 0;
                            for (int g = 0; g < 10; g++) {
                                for (int i = 0; i < zanytost_osn_urgent.length; i++) {
                                    for (int j = 1; j < zanytost_osn_urgent[1].length; j++) {
                                        if (zanytost_osn_urgent[i][0].equals(r) && zanytost_osn_urgent[i][j].equals(p)) {
                                            k = k + 1;
                                        }
                                    }
                                }
                                if (k == 0) {
                                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                                    p = scanner.nextLine();
                                } else {
                                    g = 10;
                                    break;
                                }
                            }
                        } else {
                            String zanytost_osn_preliminary[][] = {
                                    {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"9", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"10", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ОСНОВНОМ ЗАЛЕ   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_osn_preliminary).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8")
                                        || r.equals("9") || r.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите место: ");
                            p = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4") ||
                                        p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") ||
                                        p.equals("9") || p.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода места. Введите заново место: ");
                                    p = scanner.nextLine();
                                }
                            }
                        }
                        Hall_common osn = new Hall_common(t, d, f, s, r, p); // основной зал //
                        System.out.println(osn);
                        System.out.println();
                        Fiscal_receipt fr = new Fiscal_receipt(t, d, f, s, h, r, p, gl, pc, cl); // расчет стоимости //
                        System.out.println(fr);
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Ошибка ввода данных в паре день заказа/фильм.");
                        System.out.println("Введите день заказа, согласно афиши: ");
                        d = scanner.nextLine();
                        System.out.println("Введите фильм, согласно афиши: ");
                        f = scanner.nextLine();
                    }
                }
                break;
            } else if (d.equals("Вторник")) {
                while (!d.equals(f)) {
                    if (d.equals("Вторник") && f.equals("Харакири")) {
                        s = "10:00";
                        h = "4D";
                        pc = 0;
                        cl = 0;
                        if (t.equals("Срочный")) {
                            String zanytost_4D_urgent[][] = {
                                    {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "Х", "3", "Х", "5", "6", "Х", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "Х", "2", "Х", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D  ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_4D_urgent).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд со свободным местом: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд со свободным местом: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите свободное место: ");
                            p = scanner.nextLine();
                            int k = 0;
                            for (int g = 0; g < 10; g++) {
                                for (int i = 0; i < zanytost_4D_urgent.length; i++) {
                                    for (int j = 1; j < zanytost_4D_urgent[1].length; j++) {
                                        if (zanytost_4D_urgent[i][0].equals(r) && zanytost_4D_urgent[i][j].equals(p)) {
                                            k = k + 1;
                                        }
                                    }
                                }
                                if (k == 0) {
                                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                                    p = scanner.nextLine();
                                } else {
                                    g = 10;
                                    break;
                                }
                            }
                        } else {
                            String zanytost_4D_preliminary[][] = {
                                    {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_4D_preliminary).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите место: ");
                            p = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4") ||
                                        p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") ||
                                        p.equals("9") || p.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода места. Введите заново место: ");
                                    p = scanner.nextLine();
                                }
                            }
                        }

                        System.out.println("Введите количество 4D очков (из расчета 1 4D очки на 1 место): ");
                        gl = input.nextInt();
                        while (!d.equals(f)) {
                            if (gl == 1) {
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Ошибка ввода количества 4D очков. Введите заново " +
                                        "количество 4D очков (из расчета 1 4D очки на 1 место): ");
                                gl = input.nextInt();
                            }
                        }
                        Hall_four_d fd = new Hall_four_d(t, d, f, s, r, p, gl); // зал 4D //
                        System.out.println(fd);
                        System.out.println();
                        Fiscal_receipt fr = new Fiscal_receipt(t, d, f, s, h, r, p, gl, pc, cl); // расчет стоимости //
                        System.out.println(fr);
                        System.out.println();
                        break;
                    } else if (d.equals("Вторник") && f.equals("Сталкер")) {
                        s = "14:00";
                        h = "Mini";
                        gl = 0;
                        if (t.equals("Срочный")) {
                            String zanytost_mini_urgent[][] = {
                                    {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D  ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_mini_urgent).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд со свободным местом: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд со свободным местом: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите свободное место: ");
                            p = scanner.nextLine();
                            int k = 0;
                            for (int g = 0; g < 10; g++) {
                                for (int i = 0; i < zanytost_mini_urgent.length; i++) {
                                    for (int j = 1; j < zanytost_mini_urgent[1].length; j++) {
                                        if (zanytost_mini_urgent[i][0].equals(r) && zanytost_mini_urgent[i][j].equals(p)) {
                                            k = k + 1;
                                        }
                                    }
                                }
                                if (k == 0) {
                                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                                    p = scanner.nextLine();
                                } else {
                                    g = 10;
                                    break;
                                }
                            }
                        } else {
                            String zanytost_mini_preliminary[][] = {
                                    {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_mini_preliminary).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите место: ");
                            p = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4") ||
                                        p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") ||
                                        p.equals("9") || p.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода места. Введите заново место: ");
                                    p = scanner.nextLine();
                                }
                            }
                        }

                        System.out.println("Введите количество порций попкорна (лимит 10 порций): ");
                        pc = input.nextInt();
                        while (!d.equals(f)) {
                            if (pc > 0 && pc < 11) {
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Ошибка ввода количества порций попкорна. Введите заново " +
                                        "количество порций попкорна (лимит 10 порций): ");
                                pc = input.nextInt();
                            }
                        }

                        System.out.println("Введите количество порций колы (лимит 10 порций): ");
                        cl = input.nextInt();
                        while (!d.equals(f)) {
                            if (cl > 0 && cl < 11) {
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Ошибка ввода количества порций колы. Введите заново " +
                                        "количество порций колы (лимит 10 порций): ");
                                cl = input.nextInt();
                            }
                        }
                        Hall_mini m = new Hall_mini(t, d, f, s, r, p, pc, cl); // зал mini //
                        System.out.println(m);
                        System.out.println();
                        Fiscal_receipt fr = new Fiscal_receipt(t, d, f, s, h, r, p, gl, pc, cl); // расчет стоимости //
                        System.out.println(fr);
                        System.out.println();
                        break;
                    } else if (d.equals("Вторник") && f.equals("Ясмин")) {
                        s = "18:00";
                        h = "Основной";
                        gl = 0;
                        pc = 0;
                        cl = 0;
                        if (t.equals("Срочный")) {
                            String zanytost_osn_urgent[][] = {
                                    {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "Х", "3", "Х", "5", "6", "Х", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "Х", "2", "Х", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"9", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"10", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ОСНОВНОМ ЗАЛЕ   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_osn_urgent).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд со свободным местом: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8") || r.equals("9")
                                        || r.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд со свободным местом: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите свободное место: ");
                            p = scanner.nextLine();
                            int k = 0;
                            for (int g = 0; g < 10; g++) {
                                for (int i = 0; i < zanytost_osn_urgent.length; i++) {
                                    for (int j = 1; j < zanytost_osn_urgent[1].length; j++) {
                                        if (zanytost_osn_urgent[i][0].equals(r) && zanytost_osn_urgent[i][j].equals(p)) {
                                            k = k + 1;
                                        }
                                    }
                                }
                                if (k == 0) {
                                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                                    p = scanner.nextLine();
                                } else {
                                    g = 10;
                                    break;
                                }
                            }
                        } else {
                            String zanytost_osn_preliminary[][] = {
                                    {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"9", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"10", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ОСНОВНОМ ЗАЛЕ   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_osn_preliminary).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8")
                                        || r.equals("9") || r.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите место: ");
                            p = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4") ||
                                        p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") ||
                                        p.equals("9") || p.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода места. Введите заново место: ");
                                    p = scanner.nextLine();
                                }
                            }
                        }
                        Hall_common osn = new Hall_common(t, d, f, s, r, p); // основной зал //
                        System.out.println(osn);
                        System.out.println();
                        Fiscal_receipt fr = new Fiscal_receipt(t, d, f, s, h, r, p, gl, pc, cl); // расчет стоимости //
                        System.out.println(fr);
                        System.out.println();
                        break;
                    } else if (d.equals("Вторник") && f.equals("Лолита")) {
                        s = "22:00";
                        h = "4D";
                        pc = 0;
                        cl = 0;
                        if (t.equals("Срочный")) {
                            String zanytost_4D_urgent[][] = {
                                    {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "Х", "3", "Х", "5", "6", "Х", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "Х", "2", "Х", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D  ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_4D_urgent).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд со свободным местом: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд со свободным местом: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите свободное место: ");
                            p = scanner.nextLine();
                            int k = 0;
                            for (int g = 0; g < 10; g++) {
                                for (int i = 0; i < zanytost_4D_urgent.length; i++) {
                                    for (int j = 1; j < zanytost_4D_urgent[1].length; j++) {
                                        if (zanytost_4D_urgent[i][0].equals(r) && zanytost_4D_urgent[i][j].equals(p)) {
                                            k = k + 1;
                                        }
                                    }
                                }
                                if (k == 0) {
                                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                                    p = scanner.nextLine();
                                } else {
                                    g = 10;
                                    break;
                                }
                            }
                        } else {
                            String zanytost_4D_preliminary[][] = {
                                    {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_4D_preliminary).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите место: ");
                            p = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4") ||
                                        p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") ||
                                        p.equals("9") || p.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода места. Введите заново место: ");
                                    p = scanner.nextLine();
                                }
                            }
                        }

                        System.out.println("Введите количество 4D очков (из расчета 1 4D очки на 1 место): ");
                        gl = input.nextInt();
                        while (!d.equals(f)) {
                            if (gl == 1) {
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Ошибка ввода количества 4D очков. Введите заново " +
                                        "количество 4D очков (из расчета 1 4D очки на 1 место): ");
                                gl = input.nextInt();
                            }
                        }
                        Hall_four_d fd = new Hall_four_d(t, d, f, s, r, p, gl); // зал 4D //
                        System.out.println(fd);
                        System.out.println();
                        Fiscal_receipt fr = new Fiscal_receipt(t, d, f, s, h, r, p, gl, pc, cl); // расчет стоимости //
                        System.out.println(fr);
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Ошибка ввода данных в паре день заказа/фильм.");
                        System.out.println("Введите день заказа, согласно афиши: ");
                        d = scanner.nextLine();
                        System.out.println("Введите фильм, согласно афиши: ");
                        f = scanner.nextLine();
                    }
                }
                break;
            } else if (d.equals("Среда")) {
                while (!d.equals(f)) {
                    if (d.equals("Среда") && f.equals("Лолита")) {
                        s = "10:00";
                        h = "Mini";
                        gl = 0;
                        if (t.equals("Срочный")) {
                            String zanytost_mini_urgent[][] = {
                                    {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D  ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_mini_urgent).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд со свободным местом: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд со свободным местом: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите свободное место: ");
                            p = scanner.nextLine();
                            int k = 0;
                            for (int g = 0; g < 10; g++) {
                                for (int i = 0; i < zanytost_mini_urgent.length; i++) {
                                    for (int j = 1; j < zanytost_mini_urgent[1].length; j++) {
                                        if (zanytost_mini_urgent[i][0].equals(r) && zanytost_mini_urgent[i][j].equals(p)) {
                                            k = k + 1;
                                        }
                                    }
                                }
                                if (k == 0) {
                                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                                    p = scanner.nextLine();
                                } else {
                                    g = 10;
                                    break;
                                }
                            }
                        } else {
                            String zanytost_mini_preliminary[][] = {
                                    {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_mini_preliminary).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите место: ");
                            p = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4") ||
                                        p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") ||
                                        p.equals("9") || p.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода места. Введите заново место: ");
                                    p = scanner.nextLine();
                                }
                            }
                        }

                        System.out.println("Введите количество порций попкорна (лимит 10 порций): ");
                        pc = input.nextInt();
                        while (!d.equals(f)) {
                            if (pc > 0 && pc < 11) {
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Ошибка ввода количества порций попкорна. Введите заново " +
                                        "количество порций попкорна (лимит 10 порций): ");
                                pc = input.nextInt();
                            }
                        }

                        System.out.println("Введите количество порций колы (лимит 10 порций): ");
                        cl = input.nextInt();
                        while (!d.equals(f)) {
                            if (cl > 0 && cl < 11) {
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Ошибка ввода количества порций колы. Введите заново " +
                                        "количество порций колы (лимит 10 порций): ");
                                cl = input.nextInt();
                            }
                        }
                        Hall_mini m = new Hall_mini(t, d, f, s, r, p, pc, cl); // зал mini //
                        System.out.println(m);
                        System.out.println();
                        Fiscal_receipt fr = new Fiscal_receipt(t, d, f, s, h, r, p, gl, pc, cl); // расчет стоимости //
                        System.out.println(fr);
                        System.out.println();
                        break;
                    } else if (d.equals("Среда") && f.equals("Харакири")) {
                        s = "14:00";
                        h = "Основной";
                        gl = 0;
                        pc = 0;
                        cl = 0;
                        if (t.equals("Срочный")) {
                            String zanytost_osn_urgent[][] = {
                                    {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "Х", "3", "Х", "5", "6", "Х", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "Х", "2", "Х", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"9", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"10", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ОСНОВНОМ ЗАЛЕ   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_osn_urgent).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд со свободным местом: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8") || r.equals("9")
                                        || r.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд со свободным местом: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите свободное место: ");
                            p = scanner.nextLine();
                            int k = 0;
                            for (int g = 0; g < 10; g++) {
                                for (int i = 0; i < zanytost_osn_urgent.length; i++) {
                                    for (int j = 1; j < zanytost_osn_urgent[1].length; j++) {
                                        if (zanytost_osn_urgent[i][0].equals(r) && zanytost_osn_urgent[i][j].equals(p)) {
                                            k = k + 1;
                                        }
                                    }
                                }
                                if (k == 0) {
                                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                                    p = scanner.nextLine();
                                } else {
                                    g = 10;
                                    break;
                                }
                            }
                        } else {
                            String zanytost_osn_preliminary[][] = {
                                    {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"9", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"10", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ОСНОВНОМ ЗАЛЕ   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_osn_preliminary).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8")
                                        || r.equals("9") || r.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите место: ");
                            p = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4") ||
                                        p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") ||
                                        p.equals("9") || p.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода места. Введите заново место: ");
                                    p = scanner.nextLine();
                                }
                            }
                        }
                        Hall_common osn = new Hall_common(t, d, f, s, r, p); // основной зал //
                        System.out.println(osn);
                        System.out.println();
                        Fiscal_receipt fr = new Fiscal_receipt(t, d, f, s, h, r, p, gl, pc, cl); // расчет стоимости //
                        System.out.println(fr);
                        System.out.println();
                        break;
                    } else if (d.equals("Среда") && f.equals("Сталкер")) {
                        s = "18:00";
                        h = "4D";
                        pc = 0;
                        cl = 0;
                        if (t.equals("Срочный")) {
                            String zanytost_4D_urgent[][] = {
                                    {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "Х", "3", "Х", "5", "6", "Х", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "Х", "2", "Х", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D  ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_4D_urgent).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд со свободным местом: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд со свободным местом: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите свободное место: ");
                            p = scanner.nextLine();
                            int k = 0;
                            for (int g = 0; g < 10; g++) {
                                for (int i = 0; i < zanytost_4D_urgent.length; i++) {
                                    for (int j = 1; j < zanytost_4D_urgent[1].length; j++) {
                                        if (zanytost_4D_urgent[i][0].equals(r) && zanytost_4D_urgent[i][j].equals(p)) {
                                            k = k + 1;
                                        }
                                    }
                                }
                                if (k == 0) {
                                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                                    p = scanner.nextLine();
                                } else {
                                    g = 10;
                                    break;
                                }
                            }
                        } else {
                            String zanytost_4D_preliminary[][] = {
                                    {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"7", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"8", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_4D_preliminary).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")
                                        || r.equals("6") || r.equals("7") || r.equals("8")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите место: ");
                            p = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4") ||
                                        p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") ||
                                        p.equals("9") || p.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода места. Введите заново место: ");
                                    p = scanner.nextLine();
                                }
                            }
                        }

                        System.out.println("Введите количество 4D очков (из расчета 1 4D очки на 1 место): ");
                        gl = input.nextInt();
                        while (!d.equals(f)) {
                            if (gl == 1) {
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Ошибка ввода количества 4D очков. Введите заново " +
                                        "количество 4D очков (из расчета 1 4D очки на 1 место): ");
                                gl = input.nextInt();
                            }
                        }
                        Hall_four_d fd = new Hall_four_d(t, d, f, s, r, p, gl); // зал 4D //
                        System.out.println(fd);
                        System.out.println();
                        Fiscal_receipt fr = new Fiscal_receipt(t, d, f, s, h, r, p, gl, pc, cl); // расчет стоимости //
                        System.out.println(fr);
                        System.out.println();
                        break;
                    } else if (d.equals("Среда") && f.equals("Ясмин")) {
                        s = "22:00";
                        h = "Mini";
                        gl = 0;
                        if (t.equals("Срочный")) {
                            String zanytost_mini_urgent[][] = {
                                    {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D  ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_mini_urgent).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд со свободным местом: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд со свободным местом: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите свободное место: ");
                            p = scanner.nextLine();
                            int k = 0;
                            for (int g = 0; g < 10; g++) {
                                for (int i = 0; i < zanytost_mini_urgent.length; i++) {
                                    for (int j = 1; j < zanytost_mini_urgent[1].length; j++) {
                                        if (zanytost_mini_urgent[i][0].equals(r) && zanytost_mini_urgent[i][j].equals(p)) {
                                            k = k + 1;
                                        }
                                    }
                                }
                                if (k == 0) {
                                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                                    p = scanner.nextLine();
                                } else {
                                    g = 10;
                                    break;
                                }
                            }
                        } else {
                            String zanytost_mini_preliminary[][] = {
                                    {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                                    {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};
                            System.out.println("   СВОБОДНЫЕ МЕСТА В ЗАЛЕ 4D   ");
                            System.out.println("РЯДЫ" + "            МЕСТА              ");
                            Arrays.stream(zanytost_mini_preliminary).map(Arrays::toString).forEach(System.out::println);

                            System.out.println("Введите ряд: ");
                            r = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4") || r.equals("5")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода ряда. Введите заново ряд: ");
                                    r = scanner.nextLine();
                                }
                            }

                            System.out.println("Введите место: ");
                            p = scanner.nextLine();
                            while (!d.equals(f)) {
                                if (p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4") ||
                                        p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") ||
                                        p.equals("9") || p.equals("10")) {
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ошибка ввода места. Введите заново место: ");
                                    p = scanner.nextLine();
                                }
                            }
                        }

                        System.out.println("Введите количество порций попкорна (лимит 10 порций): ");
                        pc = input.nextInt();
                        while (!d.equals(f)) {
                            if (pc > 0 && pc < 11) {
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Ошибка ввода количества порций попкорна. Введите заново " +
                                        "количество порций попкорна (лимит 10 порций): ");
                                pc = input.nextInt();
                            }
                        }

                        System.out.println("Введите количество порций колы (лимит 10 порций): ");
                        cl = input.nextInt();
                        while (!d.equals(f)) {
                            if (cl > 0 && cl < 11) {
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Ошибка ввода количества порций колы. Введите заново " +
                                        "количество порций колы (лимит 10 порций): ");
                                cl = input.nextInt();
                            }
                        }
                        Hall_mini m = new Hall_mini(t, d, f, s, r, p, pc, cl); // зал mini //
                        System.out.println(m);
                        System.out.println();
                        Fiscal_receipt fr = new Fiscal_receipt(t, d, f, s, h, r, p, gl, pc, cl); // расчет стоимости //
                        System.out.println(fr);
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Ошибка ввода данных в паре день заказа/фильм.");
                        System.out.println("Введите день заказа, согласно афиши: ");
                        d = scanner.nextLine();
                        System.out.println("Введите фильм, согласно афиши: ");
                        f = scanner.nextLine();
                    }
                }
                break;
            } else {
                System.out.println("Неверно введен день заказа.");
                System.out.println("Введите день заказа, согласно афиши: ");
                d = scanner.nextLine();
                System.out.println("Введите фильм, согласно афиши: ");
                f = scanner.nextLine();
            }
        }
    }
}

class Order {
    private String type; // тип заказа (срочный или предварительный) //

    public Order(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        if (type.equals("Срочный")) {
            return "Срочный заказ.";
        }
        return "Предварительный заказ.";
    }
}

class Hall_common {
    String type; // тип заказа (срочный или предварительный) //
    String day; // день недели (согласно афишы) //
    String film; // фильм (согласно афишы) //
    String session; // сеанс (согласно афишы) //
    String row; // ряд //
    String place; // место //


    public Hall_common(String type, String day, String film, String session, String row, String place) {
        this.type = type;
        this.day = day;
        this.film = film;
        this.session = session;
        this.row = row;
        this.place = place;
    }

    public Hall_common() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        if (type.equals("Срочный")) {
            return "Параметры срочного заказа на просмотр фильма в основном зале (согласно афишы): день " + day
                        + "; фильм " + film + "; время начала сеанса " + session + "; ряд " + row + "; " +
                    "место " + place + ".";
        }
        return "Параметры предварительного заказа на просмотр фильма в основном зале (согласно афишы): день " + day
                    + "; фильм " + film + "; время начала сеанса " + session + "; ряд " + row + "; " +
                "место " + place + ".";
    }
}

class Hall_four_d extends Hall_common {

    private String day; // день недели (согласно афишы) //
    private String film; // фильм (согласно афишы) //
    private String session; // сеанс (согласно афишы) //
    private String row; // ряд //
    private String place; // место //

        // Дополнительный сервис  //

    private int glasses; // 4D очки //

    public Hall_four_d(String type, String day, String film, String session, String row, String place, int glasses) {
        super.type = type;
        this.day = day;
        this.film = film;
        this.session = session;
        this.row = row;
        this.place = place;
        this.glasses = glasses;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getGlasses() {
        return glasses;
    }

    public void setGlasses(int glasses) {
        this.glasses = glasses;
    }

    @Override
    public String toString() {
        if (type.equals("Срочный")) {
            return "Параметры срочного заказа на просмотр фильма в зале 4D (согласно афишы): день " + day
                    + "; фильм " + film + "; время начала сеанса " + session + "; ряд " + row + "; " +
                    "место " + place + ". Дополнительный сервис: очки 4D "
                    + glasses + " шт.";
        }
        return "Параметры предварительного заказа на просмотр фильма в зале 4D (согласно афишы): день " + day
                + "; фильм " + film + "; время начала сеанса " + session + "; ряд " + row + "; " +
                "место " + place + ". Дополнительный сервис: очки 4D "
                + glasses + " шт.";
    }
}
class Hall_mini extends Hall_common {

    private String day; // день недели (согласно афишы) //
    private String film; // фильм (согласно афишы) //
    private String session; // сеанс (согласно афишы) //
    private String row; // ряд //
    private String place; // место //

    // Дополнительный сервис  //
    private int popcorn; // попкорн //
    private int cola; // кола //

    public Hall_mini(String type, String day, String film, String session, String row, String place, int popcorn,
                     int cola) {
        super.type = type;
        this.day = day;
        this.film = film;
        this.session = session;
        this.row = row;
        this.place = place;
        this.popcorn = popcorn;
        this.cola = cola;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPopcorn() {
        return popcorn;
    }

    public void setPopcorn(int popcorn) {
        this.popcorn = popcorn;
    }

    public int getCola() {
        return cola;
    }

    public void setCola(int cola) {
        this.cola = cola;
    }

    @Override
    public String toString() {
        if (type.equals("Срочный")) {
            return "Параметры срочного заказа на просмотр фильма в mini зале (согласно афишы): день " + day
                    + "; фильм " + film + "; время начала сеанса " + session + "; ряд " + row + "; " +
                    "место " + place + ". Дополнительный сервис: попкорн количество порций " + popcorn +
                    "; кола количество порций " + cola + " .";
        }
        return "Параметры предварительного заказа на просмотр фильма в mini зале (согласно афишы): день " + day
                + "; фильм " + film + "; время начала сеанса " + session + "; ряд " + row + "; " +
                "место " + place + ". Дополнительный сервис: попкорн количество порций " + popcorn +
                "; кола количество порций " + cola + " .";
    }
}

class Fiscal_receipt {
    // Основной сервис //
    private String type; // тип заказа (срочный или предварительный) //
    private String day; // день недели (согласно афишы) //
    private String film; // фильм (согласно афишы) //
    private String session; // сеанс (согласно афишы) //
    private String hall; // тип зала //
    private String row; // ряд //
    private String place; // место //

    // Основной сервис //

    private int glasses; // 4D очки //
    private int popcorn; // попкорн //
    private int cola; // кола //

    // Прайс //

    final double zakaz_urgent = 5.2; // стоимость срочного заказа в $ //
    final double zakaz_preliminary = 10.1; // стоимость предварительного заказа в $ //
    final double Kses10 = 0.9; // коэффициент стоимости сеанса на 10:00 //
    final double Kses14 = 1.0; // коэффициент стоимости сеанса на 14:00 //
    final double Kses18 = 1.5; // коэффициент стоимости сеанса на 18:00 //
    final double Kses22 = 2.0; // коэффициент стоимости сеанса на 22:00 //
    final double Koz = 1.0; // коэффициент стоимости основного зала //
    final double Kfd = 2.2; // коэффициент стоимости зала 4D //
    final double Km = 4.1; // коэффициент стоимости mini зала //
    final double sgfd = 2.0; // стоимость проката на сеанс очков 4D в $ за единицу //
    final double spn = 2.8; // стоимость порции попкорна в $ //
    final double scl = 1.7; // стоимость порции колы в $ //

    public Fiscal_receipt(String type, String day, String film, String session, String hall, String row, String place,
                          int glasses, int popcorn, int cola) {
        this.type = type;
        this.day = day;
        this.film = film;
        this.session = session;
        this.hall = hall;
        this.row = row;
        this.place = place;
        this.glasses = glasses;
        this.popcorn = popcorn;
        this.cola = cola;
    }

    public Fiscal_receipt() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getGlasses() {
        return glasses;
    }

    public void setGlasses(int glasses) {
        this.glasses = glasses;
    }

    public int getPopcorn() {
        return popcorn;
    }

    public void setPopcorn(int popcorn) {
        this.popcorn = popcorn;
    }

    public int getCola() {
        return cola;
    }

    public void setCola(int cola) {
        this.cola = cola;
    }

    @Override
    public String toString() {
        if (type.equals("Срочный")) {
            if (day.equals("Понедельник")) {
                if (film.equals("Сталкер")) {
                    return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                             + ((zakaz_urgent * Kses10 * Koz) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
                } else if (film.equals("Ясмин")) {
                    return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_urgent * Kses14 * Kfd) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
                } else if (film.equals("Лолита")) {
                    return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_urgent * Kses18 * Km) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
                } else if (film.equals("Харакири")) {
                    return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_urgent * Kses22 * Koz) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
                }
            } else if (day.equals("Вторник")) {
                if (film.equals("Харакири")) {
                    return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_urgent * Kses10 * Kfd) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
                } else if (film.equals("Сталкер")) {
                    return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_urgent * Kses14 * Km) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
                } else if (film.equals("Ясмин")) {
                    return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_urgent * Kses18 * Koz) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
                } else if (film.equals("Лолита")) {
                    return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_urgent * Kses22 * Kfd) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
                }
            } else if (day.equals("Среда")) {
                if (film.equals("Лолита")) {
                    return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_urgent * Kses10 * Km) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
                } else if (film.equals("Харакири")) {
                    return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_urgent * Kses14 * Koz) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
                } else if (film.equals("Сталкер")) {
                    return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_urgent * Kses18 * Kfd) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
                } else if (film.equals("Ясмин")) {
                    return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_urgent * Kses22 * Km) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
                }
            }
        }
        if (day.equals("Понедельник")) {
            if (film.equals("Сталкер")) {
                return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_preliminary * Kses10 * Koz) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
            } else if (film.equals("Ясмин")) {
                return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_preliminary * Kses14 * Kfd) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
            } else if (film.equals("Лолита")) {
                return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_preliminary * Kses18 * Km) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
            } else if (film.equals("Харакири")) {
                return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_preliminary * Kses22 * Koz) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
            }
        } else if (day.equals("Вторник")) {
            if (film.equals("Харакири")) {
                return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_preliminary * Kses10 * Kfd) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
            } else if (film.equals("Сталкер")) {
                return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_preliminary * Kses14 * Km) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
            } else if (film.equals("Ясмин")) {
                return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_preliminary * Kses18 * Koz) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
            } else if (film.equals("Лолита")) {
                return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_preliminary * Kses22 * Kfd) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
            }
        }
        if (film.equals("Лолита")) {
            return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                        + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_preliminary * Kses10 * Km) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
        } else if (film.equals("Харакири")) {
            return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_preliminary * Kses14 * Koz) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
        } else if (film.equals("Сталкер")) {
            return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_preliminary * Kses18 * Kfd) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
        }
        return "Расчет стоимости просмотра фильма из текущей афиши: Заказ " + type + ". День " + day
                            + ". Фильм " + film + ". Сеанс на " + session + ". Зал " + hall + ". Ряд " + row +
                            ". Место " + place + ". Дополнительный сервис: Очки 4D " + glasses +
                            ". Порций попкорна " + popcorn + ". Порций Колы " + cola + ". Итоговая сумма к оплате: "
                            + ((zakaz_preliminary * Kses22 * Km) + (glasses * sgfd) + (popcorn * spn) +
                            (cola * scl)) + " $.";
    }
}

