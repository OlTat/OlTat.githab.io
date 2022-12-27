package oop_dz_2_v2;

import java.util.Scanner;

public class InputChecks {
    final String type; // тип заказа (срочный или предварительный) //
    final String day; // день недели (согласно афишы) //

    public InputChecks(String type, String day) {
        this.type = type;
        this.day = day;
    }

    public void input_day_film (String t, String d) {
        Scanner scanner = new Scanner(System.in);
        String q = null;
        while (!d.equals(q)) {
            switch (d) {
                case "Понедельник":
                    System.out.println("Введите фильм, согласно афиши: ");
                    String f = scanner.nextLine();
                    InputChecks.monday(t, d, f);
                    q = d;
                    break;
                case "Вторник":
                    System.out.println("Введите фильм, согласно афиши: ");
                    f = scanner.nextLine();
                    InputChecks.tuesday(t, d, f);
                    q = d;
                    break;
                case "Среда":
                    System.out.println("Введите фильм, согласно афиши: ");
                    f = scanner.nextLine();
                    InputChecks.wednesday(t, d, f);
                    q = d;
                    break;
                default:
                    System.out.println("Неверно введен день заказа.");
                    System.out.println("Введите день заказа, согласно афиши: ");
                    d = scanner.nextLine();
            }
        }
    }

    public static void monday (String type, String d, String f) {
        Scanner scanner = new Scanner(System.in);
        while (!d.equals(f)) {
            if (d.equals("Понедельник") && f.equals("Сталкер")) {
                String s = "10:00";
                Hall_common hc = new Hall_common(type, d, f, s);
                hc.fix_row_place(type, s);
                break;
            } else if (d.equals("Понедельник") && f.equals("Ясмин")) {
                String s = "14:00";
                Hall_four_d hfd = new Hall_four_d(type, d, f, s);
                hfd.fix_row_place(type, s);
                break;
            } else if (d.equals("Понедельник") && f.equals("Лолита")) {
                String s = "18:00";
                Hall_mini hm = new Hall_mini(type, d, f, s);
                hm.fix_row_place(type, s);
                break;
            } else if (d.equals("Понедельник") && f.equals("Харакири")) {
                String s = "22:00";
                Hall_common hc = new Hall_common(type, d, f, s);
                hc.fix_row_place(type, s);
                break;
            } else {
                System.out.println("Неверно введен фильм.");
                System.out.println("Введите фильм, согласно афиши: ");
                f = scanner.nextLine();
            }
        }
    }

    public static void tuesday (String type, String d, String f) {
        Scanner scanner = new Scanner(System.in);
        while (!d.equals(f)) {
            if (d.equals("Вторник") && f.equals("Харакири")) {
                String s = "10:00";
                Hall_four_d hfd = new Hall_four_d(type, d, f, s);
                hfd.fix_row_place(type, s);
                break;
            } else if (d.equals("Вторник") && f.equals("Сталкер")) {
                String s = "14:00";
                Hall_mini hm = new Hall_mini(type, d, f, s);
                hm.fix_row_place(type, s);
                break;
            } else if (d.equals("Вторник") && f.equals("Ясмин")) {
                String s = "18:00";
                Hall_common hc = new Hall_common(type, d, f, s);
                hc.fix_row_place(type, s);
                break;
            } else if (d.equals("Вторник") && f.equals("Лолита")) {
                String s = "22:00";
                Hall_four_d hfd = new Hall_four_d(type, d, f, s);
                hfd.fix_row_place(type, s);
                break;
            } else {
                System.out.println("Неверно введен фильм.");
                System.out.println("Введите фильм, согласно афиши: ");
                f = scanner.nextLine();
            }
        }
    }

    public static void wednesday (String type, String d, String f) {
        Scanner scanner = new Scanner(System.in);
        while (!d.equals(f)) {
            if (d.equals("Среда") && f.equals("Лолита")) {
                String s = "10:00";
                Hall_mini hm = new Hall_mini(type, d, f, s);
                hm.fix_row_place(type, s);
                break;
            } else if (d.equals("Среда") && f.equals("Харакири")) {
                String s = "14:00";
                Hall_common hc = new Hall_common(type, d, f, s);
                hc.fix_row_place(type, s);
                break;
            } else if (d.equals("Среда") && f.equals("Сталкер")) {
                String s = "18:00";
                Hall_four_d hfd = new Hall_four_d(type, d, f, s);
                hfd.fix_row_place(type, s);
                break;
            } else if (d.equals("Среда") && f.equals("Ясмин")) {
                String s = "22:00";
                Hall_mini hm = new Hall_mini(type, d, f, s);
                hm.fix_row_place(type, s);
                break;
            } else {
                System.out.println("Неверно введен фильм.");
                System.out.println("Введите фильм, согласно афиши: ");
                f = scanner.nextLine();
            }
        }
    }
}
