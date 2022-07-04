package com.hiperskill.cinema;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);

    static char[][] createField(int rows, int columns) {
        char[][] field = new char[rows][columns];
        for (char[] chars : field) {
            Arrays.fill(chars, 'S');
        }
        return field;
    }

    static void drawTheField(char[][] field, int columns) {
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

    static void findOutTheSizeOfTheCinema(int rows, int columns, char[][] field) {
//        int income = profitCalculation(rows, columns, field)[0];
        int priceTicket = profitCalculation(rows, columns, field)[1];
//        System.out.println("Total income:");
//        System.out.printf("$%d", income);
        System.out.printf("Ticket price: $%d\n", priceTicket);
    }

    static int[] profitCalculation(int rows, int columns, char[][] field) {
        int firstHalf = rows / 2;
        int secondHalf = rows - firstHalf;
        int numberOfSeats = rows * columns;
        int[] result = new int[2];
        if (numberOfSeats <= 60) {
            result[0] = numberOfSeats * 10;
        } else {
            result[0] = ((firstHalf * columns) * 10) + ((secondHalf * columns) * 8);
        }
        result[1] = priceTicket(field, numberOfSeats, firstHalf);
        return result;
    }

    static int priceTicket(char[][] field, int numberOfSeats, int firstHalf) {
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int columnNumber = scanner.nextInt();
        field[rowNumber - 1][columnNumber - 1] = 'B';
        StringBuilder str = new StringBuilder(" ");
        if (numberOfSeats <= 60) {
            return 10;
        } else {
            for (int i = 0; i < firstHalf; i++) {
                str.append(Arrays.toString(field[i]));
            }
            if (str.toString().contains("B")) {
                return 10;
            } else {
                return 8;
            }
        }

    }

    public static void main(String[] args) {
        int rows, columns;
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        columns = scanner.nextInt();
        char[][] field = createField(rows, columns);
        drawTheField(field, columns);
        findOutTheSizeOfTheCinema(rows, columns, field);
        drawTheField(field, columns);
    }
}
