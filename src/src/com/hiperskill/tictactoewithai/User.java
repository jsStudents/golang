package com.hiperskill.tictactoewithai;

import java.util.Scanner;

public class User implements movable {


    public void move(char gameChar) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the coordinates: ");
            String str = scanner.nextLine();
            String[] coordinates = str.split(" ");

            if (coordinates[0].equals("exit")) {
                System.exit(0);
            } else if (coordinates.length != 2) {
                System.out.println("You should enter 2 numbers!");
                continue;
            }
            try {
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (Main.array[x - 1][y - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    Main.array[x - 1][y - 1] = gameChar;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}
