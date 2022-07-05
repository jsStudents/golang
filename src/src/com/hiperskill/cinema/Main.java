package com.hiperskill.cinema;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    Scanner scan = new Scanner(System.in);

    int rows;
    int columns;
    int ticketPrice;
    char[][] field;
    int soldTickets;
    int totalSeats;
    int firstHalf;
    int secondHalf;
    int totalIncome;
    int currentIncome;


    public Main(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.totalSeats = rows * columns;
        this.soldTickets = 0;
        this.firstHalf = (rows / 2) * columns;
        this.secondHalf = (rows - (rows / 2)) * columns;
        this.totalIncome = ((totalSeats <= 60) ? totalSeats * 10 : ((firstHalf * 10) + (secondHalf * 8)));
        this.currentIncome = 0;
        this.field = new char[rows][columns];
        for (char[] el :
                field) {
            Arrays.fill(el, 'S');
        }
    }

    public void printField() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < columns; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        int i = 1;
        for (char[] el : field) {
            System.out.print(i + " ");
            for (char ch : el) {
                System.out.print(ch + " ");
            }
            System.out.println();
            i++;
        }
    }

    public void setBuyTicket() {
        while (true) {
            System.out.println("Enter a row number:");
            int rowNumber = scan.nextInt();
            System.out.println("Enter a seat number in that row:");
            int columnNumber = scan.nextInt();
            try {
                if (field[rowNumber - 1][columnNumber - 1] != 'B') {
                    field[rowNumber - 1][columnNumber - 1] = 'B';
                    if ((rows * columns > 60) && (rowNumber > (rows / 2))) {
                        this.ticketPrice = 8;
                        this.currentIncome += 8;
                    } else {
                        this.ticketPrice = 10;
                        this.currentIncome += 10;
                    }
                    this.soldTickets += 1;
                    break;
                } else {
                    System.out.println("That ticket has already been purchased!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong input!");
            }

        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows, columns;
        System.out.println("Enter the number of rows:");
        rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row");
        columns = scan.nextInt();
        Main field = new Main(rows, columns);
        int userChoice = 5;
        while (userChoice != 0) {
            System.out.println("""
                    1. Show the seats
                    2. Buy a ticket
                    3. Statistics
                    0. Exit""");
            userChoice = scan.nextInt();
            switch (userChoice) {
                case 1 -> {
                    field.printField();
                    System.out.println();
                }
                case 2 -> {
                    field.setBuyTicket();
                    System.out.printf("Ticket price: $%d\n", field.ticketPrice);
                    System.out.println();
                }
                case 3 -> {
                    System.out.printf("Number of purchased tickets: %d\n", field.soldTickets);
                    System.out.printf("Percentage: %.2f%c\n", ((double) field.soldTickets / field.totalSeats) * 100, '%');
                    System.out.printf("Current income: $%d\n", field.currentIncome);
                    System.out.printf("Total income: $%d\n", field.totalIncome);
                }
                default -> {
                }
            }

        }
    }
}

