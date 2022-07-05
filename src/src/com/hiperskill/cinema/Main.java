package com.hiperskill.cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);

    int rows;
    int columns;
    int ticketPrice;
    char[][] field;


    public Main(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
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
        System.out.println("Enter a row number:");
        int rowNumber = scan.nextInt();
        System.out.println("Enter a seat number in that row:");
        int columnNumber = scan.nextInt();
        field[rowNumber - 1][columnNumber - 1] = 'B';
        if ((rows * columns > 60) && (rowNumber > (rows / 2))) {
            this.ticketPrice = 8;
        } else {
            this.ticketPrice = 10;
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
        field.printField();
        field.setBuyTicket();
        System.out.printf("Ticket price: $%d\n", field.ticketPrice);
        field.printField();
    }
}

