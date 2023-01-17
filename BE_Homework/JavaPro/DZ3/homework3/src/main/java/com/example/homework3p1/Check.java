package com.example.homework3p1;

public class Check {

    @Test(a = 2, b = 5)
    public static void test(int a, int b) {
        System.out.println("Итог: " + (a + b) * b);
    }
}
