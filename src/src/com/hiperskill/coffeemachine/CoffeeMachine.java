package com.hiperskill.coffeemachine;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeMachine {

    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int water;
    int milk;
    int coffeeBeans;
    int disposableCups;
    int money;

    CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disposableCups = 9;
        this.money = 550;
    }



    String checkIngredients(String name, int water, int milk, int coffeeBeans, int disposableCups) {
        String answer = "";
        switch (name) {
            case "espresso" -> {
                if (water < 250) {
                    answer = "Sorry, not enough water!";
                } else if (coffeeBeans < 16) {
                    answer = "Sorry, not enough coffee beans!";
                } else if (disposableCups < 1) {
                    answer = "Sorry, not enough disposable cups!";
                } else {
                    answer = "I have enough resources, making you a coffee!";
                }
            }
            case "latte" -> {
                if (water < 350) {
                    answer = "Sorry, not enough water!";
                } else if (milk < 75) {
                    answer = "Sorry, not enough milk!";
                } else if (coffeeBeans < 20) {
                    answer = "Sorry, not enough coffee beans!";
                } else if (disposableCups < 1) {
                    answer = "Sorry, not enough disposable cups!";
                }
                else {
                    answer = "I have enough resources, making you a coffee!";
                }
            }
            case "cappuccino" -> {
                if (water < 200) {
                    answer = "Sorry, not enough water!";
                } else if (milk < 100) {
                    answer = "Sorry, not enough milk!";
                } else if (coffeeBeans < 12) {
                    answer = "Sorry, not enough coffee beans!";
                } else if (disposableCups < 1) {
                    answer = "Sorry, not enough disposable cups!";
                }
                else {
                    answer = "I have enough resources, making you a coffee!";
                }
            }
        }
        return answer;
    }

    void buy() throws IOException {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
        String userChoice = read.readLine();
        if (!userChoice.equals("back")) {
            switch (userChoice) {
                case "1" -> {
                    String answer = checkIngredients("espresso", this.water, this.milk, this.coffeeBeans, this.disposableCups);
                    if (answer.equals("I have enough resources, making you a coffee!")) {
                        System.out.println(answer);
                        this.water -= 250;
                        this.coffeeBeans -= 16;
                        this.disposableCups -= 1;
                        this.money += 4;
                    } else {
                        System.out.println(answer);
                    }
                }
                case "2" -> {
                    String answer = checkIngredients("latte", this.water, this.milk, this.coffeeBeans, this.disposableCups);
                    if (answer.equals("I have enough resources, making you a coffee!")) {
                        System.out.println(answer);
                        this.water -= 350;
                        this.milk -= 75;
                        this.coffeeBeans -= 20;
                        this.disposableCups -= 1;
                        this.money += 7;
                    } else {
                        System.out.println(answer);
                    }
                }
                case "3" -> {
                    String answer = checkIngredients("latte", this.water, this.milk, this.coffeeBeans, this.disposableCups);
                    if (answer.equals("I have enough resources, making you a coffee!")) {
                        System.out.println(answer);
                        this.water -= 200;
                        this.milk -= 100;
                        this.coffeeBeans -= 12;
                        this.disposableCups -= 1;
                        this.money += 6;
                    } else {
                        System.out.println(answer);
                    }

                }
            }
        }
    }

    void fill() throws IOException {
        System.out.println("Write how many ml of water you want to add:");
        this.water += Integer.parseInt(read.readLine());
        System.out.println("Write how many ml of milk you want to add:");
        this.milk += Integer.parseInt(read.readLine());
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.coffeeBeans += Integer.parseInt(read.readLine());
        System.out.println("Write how many disposable cups of coffee you want to add:");
        this.disposableCups += Integer.parseInt(read.readLine());
    }

    void take() {
        System.out.printf("I gave you $%d", money);
        this.money -= this.money;
    }

    void remaining() {
        System.out.println("The coffee machine has:");
        System.out.printf("""
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                %d of money
                """, this.water, this.milk, this.coffeeBeans, this.disposableCups, this.money);
    }

    void action() throws IOException {
        String userChoice = "";
        while (!userChoice.equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            userChoice = read.readLine();
            switch (userChoice) {
                case "buy" -> buy();
                case "fill" -> fill();
                case "take" -> take();
                case "remaining" -> remaining();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CoffeeMachine machine = new CoffeeMachine();
        machine.action();

    }
}
