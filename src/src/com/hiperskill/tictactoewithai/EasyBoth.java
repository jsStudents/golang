package com.hiperskill.tictactoewithai;

import java.util.Random;

public class EasyBoth implements movable {


    public void move(char gameChar) {
        Random random = new Random();
        while (true) {
            System.out.print("Making move level \"easy\"\n");
            String[] coordinates = new String[2];
            coordinates[0] = String.valueOf(random.nextInt(3) + 1);
            coordinates[1] = String.valueOf(random.nextInt(3) + 1);

            if (coordinates[0].equals("exit")) {
                System.exit(0);
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
