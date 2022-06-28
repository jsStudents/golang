package com.hiperskill.simpleBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SimpleBot {
    Scanner scan = new Scanner(System.in);
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    String name = "Aid";
    int age = 2020;

    void greetings() {
        System.out.printf("Hello! My name is %s.\n", name);
        System.out.printf("I was created in %d.\n", age);
        System.out.println("Please, remind me your name.");
        String userName = scan.nextLine();
        System.out.printf("What a great name you have, %s!\n", userName);
    }

    void guessingGame() throws IOException {
        System.out.println("Let me guess your age.\n" +
                "Enter remainders of dividing your age by 3, 5 and 7.");
        int remainder3 = Integer.parseInt(read.readLine());
        int remainder5 = Integer.parseInt(read.readLine());
        int remainder7 = Integer.parseInt(read.readLine());
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.printf("Your age is %d; that's a good time to start programming!\n", age);
    }

    void learningNumbers() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int userNumber = scan.nextInt();
        for (int i = 0; i <= userNumber; i++) {
            System.out.println(i + "!");
        }
    }

    void test() {
        System.out.println("""
                Let's test your programming knowledge.
                Why do we use methods?
                1. To repeat a statement multiple times.
                2. To decompose a program into several small subroutines.
                3. To determine the execution time of a program.
                4. To interrupt the execution of a program.""");
        while (true) {
            int user_answer = scan.nextInt();
            if (user_answer == 4) {
                break;
            } else {
                System.out.println("Please, try again.");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleBot bot = new SimpleBot();
        bot.greetings();
        bot.guessingGame();
        bot.learningNumbers();
        bot.test();
        System.out.println("Congratulations, have a nice day!");
    }
}