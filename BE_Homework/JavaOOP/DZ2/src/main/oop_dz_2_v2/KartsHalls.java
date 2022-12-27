package oop_dz_2_v2;

import java.util.Arrays;
import java.util.Scanner;

public class KartsHalls {
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

    String zanytost_4D_urgent[][] = {
            {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
            {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
            {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"5", "1", "Х", "3", "Х", "5", "6", "Х", "8", "9", "10"},
            {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"7", "Х", "2", "Х", "4", "5", "6", "7", "8", "9", "10"},
            {"8", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};

    String zanytost_4D_preliminary[][] = {
            {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"6", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"7", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"8", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};

    String zanytost_mini_urgent[][] = {
            {"1", "Х", "Х", "Х", "4", "5", "Х", "7", "8", "Х", "10"},
            {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"3", "1", "2", "3", "4", "5", "Х", "7", "8", "Х", "10"},
            {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"5", "1", "Х", "3", "Х", "5", "Х", "7", "Х", "Х", "10"}};

    String zanytost_mini_preliminary[][] = {
            {"1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"2", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"3", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};

    final String type; // тип заказа (срочный или предварительный) //
    private String row; // ряд //
    private String place; // место //

    public KartsHalls(String type) {
        this.type = type;
    }

    public String getRow() {
        return row;
    }

    public String getPlace() {
        return place;
    }

    public void osn (String type) {
        System.out.println("   СВОБОДНЫЕ МЕСТА В ОСНОВНОМ ЗАЛЕ   ");
        System.out.println("РЯДЫ" + "            МЕСТА              ");
        if (type.equals("Срочный")) {
            Arrays.stream(zanytost_osn_urgent).map(Arrays::toString).forEach(System.out::println);
        } else {
            Arrays.stream(zanytost_osn_preliminary).map(Arrays::toString).forEach(System.out::println);
        }
    }

    public void checks_row_place_osn (String type) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ряд со свободным местом: ");
        String r = scanner.nextLine();
        System.out.println("Введите свободное место: ");
        String p = scanner.nextLine();
        row = r;
        place = p;
        KartsHalls kh = new KartsHalls(type);
        if (type.equals("Срочный")) {
            kh.checks_row_place_osn_urgent (r, p);
        } else {
            kh.checks_row_place_osn_preliminary (r, p);
        }
        row = kh.row;
        place = kh.place;
    }

    public void checks_row_place_osn_urgent (String r, String p) {
        Scanner scanner = new Scanner(System.in);
        int m = 0;
        int k = 0;
        for (int g = 0; g < 10; g++) {
            for (int i = 0; i < zanytost_osn_urgent.length; i++) {
                if (zanytost_osn_urgent[i][0].equals(r)) {
                    m = m + 1;
                }
                for (int j = 1; j < zanytost_osn_urgent[1].length; j++) {
                    if (zanytost_osn_urgent[i][0].equals(r) && zanytost_osn_urgent[i][j].equals(p)) {
                        k = k + 1;
                    }
                }
            }
            if (m == 0) {
                System.out.println("Ошибка ввода ряда. Введите заново свободный ряд: ");
                r = scanner.nextLine();
            } else {
                if (k == 0) {
                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                    p = scanner.nextLine();
                } else {
                    break;
                }
            }
        }
        this.row = r;
        this.place = p;
    }

    public void checks_row_place_osn_preliminary (String r, String p) {
        Scanner scanner = new Scanner(System.in);
        int m = 0;
        int k = 0;
        for (int g = 0; g < 10; g++) {
            for (int i = 0; i < zanytost_osn_preliminary.length; i++) {
                if (zanytost_osn_preliminary[i][0].equals(r)) {
                    m = m + 1;
                }
                for (int j = 1; j < zanytost_osn_preliminary[1].length; j++) {
                    if (zanytost_osn_preliminary[i][0].equals(r) && zanytost_osn_preliminary[i][j].equals(p)) {
                        k = k + 1;
                    }
                }
            }
            if (m == 0) {
                System.out.println("Ошибка ввода ряда. Введите заново свободный ряд: ");
                r = scanner.nextLine();
            } else {
                if (k == 0) {
                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                    p = scanner.nextLine();
                } else {
                    break;
                }
            }
        }
        this.row = r;
        this.place = p;
    }

    public void four_d (String t) {
        System.out.println("   СВОБОДНЫЕ МЕСТА В 4D ЗАЛЕ   ");
        System.out.println("РЯДЫ" + "            МЕСТА              ");
        if (t.equals("Срочный")) {
            Arrays.stream(zanytost_4D_urgent).map(Arrays::toString).forEach(System.out::println);
        } else {
            Arrays.stream(zanytost_4D_preliminary).map(Arrays::toString).forEach(System.out::println);
        }
    }

    public void checks_row_place_four_d (String t) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ряд со свободным местом: ");
        String r = scanner.nextLine();
        System.out.println("Введите свободное место: ");
        String p = scanner.nextLine();
        row = r;
        place = p;
        KartsHalls kh = new KartsHalls(t);
        if (t.equals("Срочный")) {
            kh.checks_row_place_four_d_urgent (r, p);
        } else {
            kh.checks_row_place_four_d_preliminary (r, p);
        }
        row = kh.row;
        place = kh.place;
    }

    public void checks_row_place_four_d_urgent (String r, String p) {
        Scanner scanner = new Scanner(System.in);
        int m = 0;
        int k = 0;
        for (int g = 0; g < 8; g++) {
            for (int i = 0; i < zanytost_4D_urgent.length; i++) {
                if (zanytost_4D_urgent[i][0].equals(r)) {
                    m = m + 1;
                }
                for (int j = 1; j < zanytost_4D_urgent[1].length; j++) {
                    if (zanytost_4D_urgent[i][0].equals(r) && zanytost_4D_urgent[i][j].equals(p)) {
                        k = k + 1;
                    }
                }
            }
            if (m == 0) {
                System.out.println("Ошибка ввода ряда. Введите заново свободный ряд: ");
                r = scanner.nextLine();
            } else {
                if (k == 0) {
                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                    p = scanner.nextLine();
                } else {
                    break;
                }
            }
        }
        this.row = r;
        this.place = p;
    }

    public void checks_row_place_four_d_preliminary (String r, String p) {
        Scanner scanner = new Scanner(System.in);
        int m = 0;
        int k = 0;
        for (int g = 0; g < 8; g++) {
            for (int i = 0; i < zanytost_4D_preliminary.length; i++) {
                if (zanytost_4D_preliminary[i][0].equals(r)) {
                    m = m + 1;
                }
                for (int j = 1; j < zanytost_4D_preliminary[1].length; j++) {
                    if (zanytost_4D_preliminary[i][0].equals(r) && zanytost_4D_preliminary[i][j].equals(p)) {
                        k = k + 1;
                    }
                }
            }
            if (m == 0) {
                System.out.println("Ошибка ввода ряда. Введите заново свободный ряд: ");
                r = scanner.nextLine();
            } else {
                if (k == 0) {
                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                    p = scanner.nextLine();
                } else {
                    break;
                }
            }
        }
        this.row = r;
        this.place = p;
    }

    public void mini (String t) {
        System.out.println("   СВОБОДНЫЕ МЕСТА В MINI ЗАЛЕ   ");
        System.out.println("РЯДЫ" + "            МЕСТА              ");
        if (t.equals("Срочный")) {
            Arrays.stream(zanytost_mini_urgent).map(Arrays::toString).forEach(System.out::println);
        } else {
            Arrays.stream(zanytost_mini_preliminary).map(Arrays::toString).forEach(System.out::println);
        }
    }

    public void checks_row_place_mini (String t) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ряд со свободным местом: ");
        String r = scanner.nextLine();
        System.out.println("Введите свободное место: ");
        String p = scanner.nextLine();
        row = r;
        place = p;
        KartsHalls kh = new KartsHalls(t);
        if (t.equals("Срочный")) {
            kh.checks_row_place_mini_urgent (r, p);
        } else {
            kh.checks_row_place_mini_preliminary (r, p);
        }
        row = kh.row;
        place = kh.place;
    }

    public void checks_row_place_mini_urgent (String r, String p) {
        Scanner scanner = new Scanner(System.in);
        int m = 0;
        int k = 0;
        for (int g = 0; g < 5; g++) {
            for (int i = 0; i < zanytost_mini_urgent.length; i++) {
                if (zanytost_mini_urgent[i][0].equals(r)) {
                    m = m + 1;
                }
                for (int j = 1; j < zanytost_mini_urgent[1].length; j++) {
                    if (zanytost_mini_urgent[i][0].equals(r) && zanytost_mini_urgent[i][j].equals(p)) {
                        k = k + 1;
                    }
                }
            }
            if (m == 0) {
                System.out.println("Ошибка ввода ряда. Введите заново свободный ряд: ");
                r = scanner.nextLine();
            } else {
                if (k == 0) {
                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                    p = scanner.nextLine();
                } else {
                    break;
                }
            }
        }
        this.row = r;
        this.place = p;
    }

    public void checks_row_place_mini_preliminary (String r, String p) {
        Scanner scanner = new Scanner(System.in);
        int m = 0;
        int k = 0;
        for (int g = 0; g < 5; g++) {
            for (int i = 0; i < zanytost_mini_preliminary.length; i++) {
                if (zanytost_mini_preliminary[i][0].equals(r)) {
                    m = m + 1;
                }
                for (int j = 1; j < zanytost_mini_preliminary[1].length; j++) {
                    if (zanytost_mini_preliminary[i][0].equals(r) && zanytost_mini_preliminary[i][j].equals(p)) {
                        k = k + 1;
                    }
                }
            }
            if (m == 0) {
                System.out.println("Ошибка ввода ряда. Введите заново свободный ряд: ");
                r = scanner.nextLine();
            } else {
                if (k == 0) {
                    System.out.println("Ошибка ввода места. Введите заново свободное место: ");
                    p = scanner.nextLine();
                } else {
                    break;
                }
            }
        }
        this.row = r;
        this.place = p;
    }
}
