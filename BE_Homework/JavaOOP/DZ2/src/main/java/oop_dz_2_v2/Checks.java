package oop_dz_2_v2;

import java.util.Scanner;

public class Checks {
    private int popcorn; // попкорн //
    private int cola; // кола //

    public Checks() {
    }

    public int getPopcorn() {
        return popcorn;
    }

    public int getCola() {
        return cola;
    }

    public void checks_dop () {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество порций попкорна (лимит 10 порций): ");
        int pc = input.nextInt();
        while (3 > 2) {
            if (pc > 0 && pc < 11) {
                popcorn = pc;
                break;
            } else {
                System.out.println("Ошибка ввода количества порций попкорна. Введите заново " +
                        "количество порций попкорна (лимит 10 порций): ");
                pc = input.nextInt();
            }
        }

        System.out.println("Введите количество порций колы (лимит 10 порций): ");
        int cl = input.nextInt();
        while (3 > 2) {
            if (cl > 0 && cl < 11) {
                cola = cl;
                break;
            } else {
                System.out.println("Ошибка ввода количества порций колы. Введите заново " +
                        "количество порций колы (лимит 10 порций): ");
                cl = input.nextInt();
            }
        }
    }
}
