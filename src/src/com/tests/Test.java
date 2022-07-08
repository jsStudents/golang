package com.tests;


import java.util.Random;

class Test {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 11; i++) {
            System.out.println("nextInt() = " + random.nextInt());
            System.out.println("nextInt(101) = " + random.nextInt(101));
            System.out.println("nextInt(50, 100) = " + (random.nextInt(100 - 50 + 1) + 50));
        }
    }
}
