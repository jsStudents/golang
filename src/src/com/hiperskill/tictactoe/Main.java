package com.hiperskill.tictactoe;

import java.util.Scanner;

public class Main {

    String line = "---------";
    char rod = '|';
    Scanner scan = new Scanner(System.in);

    void setCells(String line, char rod) {
        System.out.println("Enter cells: ");
        String userInput = scan.nextLine();
        char[] cells = userInput.toCharArray();
        System.out.println(line);
        System.out.println(rod + " " + cells[0] + " " + cells[1] + " " + cells[2] + " " + rod);
        System.out.println(rod + " " + cells[3] + " " + cells[4] + " " + cells[5] + " " + rod);
        System.out.println(rod + " " + cells[6] + " " + cells[7] + " " + cells[8] + " " + rod);
        System.out.println(line);


    }

    public static void main(String[] args) {
        Main game = new Main();
        game.setCells(game.line, game.rod);
    }
}
