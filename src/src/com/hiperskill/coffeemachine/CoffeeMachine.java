package com.hiperskill.coffeemachine;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeMachine {

    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int water = 400;
    int milk = 540;
    int coffeeBeans = 120;
    int disposableCups = 9;
    int money = 550;

    void buy() throws IOException {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int userChoice = Integer.parseInt(read.readLine());
        switch (userChoice) {
            case 1 -> {
                water -= 250;
                coffeeBeans -= 16;
                disposableCups -= 1;
                money += 4;
            }
            case 2 -> {
                water -= 350;
                milk -= 75;
                coffeeBeans -= 20;
                disposableCups -= 1;
                money += 7;
            }
            case 3 -> {
                water -= 200;
                milk -= 100;
                coffeeBeans -= 12;
                disposableCups -= 1;
                money += 6;
            }
            default -> {

            }
        }
    }

    void fill() throws IOException {
        System.out.println("Write how many ml of water you want to add:");
        water += Integer.parseInt(read.readLine());
        System.out.println("Write how many ml of milk you want to add:");
        milk += Integer.parseInt(read.readLine());
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += Integer.parseInt(read.readLine());
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCups += Integer.parseInt(read.readLine());
    }

    void take() {
        System.out.printf("I gave you $%d", money);
        money -= money;
    }

    void status() {
        System.out.println("The coffee machine has:");
        System.out.printf("""
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                %d of money""", water, milk, coffeeBeans, disposableCups, money);
    }

    void action() throws IOException {
        System.out.println("Write action (buy, fill, take): ");
        String userChoice = read.readLine();
        switch (userChoice) {
            case "buy" -> buy();
            case "fill" -> fill();
            case "take" -> take();
        }
    }
    public static void main(String[] args) throws IOException {
        CoffeeMachine machine = new CoffeeMachine();
        machine.status();
        machine.action();
        machine.status();
    }
}
