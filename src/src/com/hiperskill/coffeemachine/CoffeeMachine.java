package com.hiperskill.coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Write how many cups of coffee you will need: \n");
        int needCoffee = scan.nextInt();
        System.out.printf("For %d cups of coffee you will need:\n", needCoffee);
        System.out.printf("%d ml of water\n", needCoffee * 200);
        System.out.printf("%d ml of milk\n", needCoffee * 50);
        System.out.printf("%d g of coffee beans", needCoffee * 15);
    }
}
