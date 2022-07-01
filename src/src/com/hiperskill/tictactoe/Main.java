package com.hiperskill.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String input = sc.nextLine();

        char[][] grid = new char[3][3];
        int ind = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = input.charAt(ind);
                ind++;
            }
        }
        printGrid(grid);
        System.out.println(status(grid));
//        updateCell(grid);
//        printGrid(grid);


    }

    public static void printGrid(char[][] grid) {
        System.out.println("---------");
        System.out.println("| " + grid[0][0] + " " + grid[0][1] + " " + grid[0][2] + " |");
        System.out.println("| " + grid[1][0] + " " + grid[1][1] + " " + grid[1][2] + " |");
        System.out.println("| " + grid[2][0] + " " + grid[2][1] + " " + grid[2][2] + " |");
        System.out.println("---------");
    }

    public static String status(char[][] grid) {
        return checkWinner(grid);
    }

    public static Boolean checkBlanks(char[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '_') return true;
            }
        }
        return false;
    }

    public static String checkWinner(char[][] grid) {
        // frequency of winning rows, cols, diagonals
        int o = 0;
        int x = 0;
        // check frequency of o's and x's
        if (!correctFreq(grid)) return "Impossible";

        // check horizontals and verticals
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == 'X' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) x++;
            if (grid[i][0] == 'O' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) o++;
            if (grid[0][i] == 'X' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) x++;
            if (grid[0][i] == 'O' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) o++;
        }
        // check diagonals
        if (grid[0][0] == 'X' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) x++;
        if (grid[0][0] == 'O' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) o++;
        if (grid[0][2] == 'X' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) x++;
        if (grid[0][2] == 'O' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) o++;
        // verdicts

        if (x > 0 && o > 0) return "Impossible";
        if (x > 0) return "X wins";
        if (o > 0) return "O wins";
        if (x == 0 && o == 0 && !checkBlanks(grid)) return "Draw";
        return "Game not finished";
    }

    public static Boolean correctFreq(char[][] grid) {
        int freqX = 0, freqO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 'X') freqX++;
                else if (grid[i][j] == 'O') freqO++;
            }
        }
        return Math.abs(freqX - freqO) <= 1;
    }

//    public static void updateCell(char[][] grid) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the coordinates: ");
//        while(true) {
//            int x, y;
//            if(sc.hasNextInt()) {
//                x = sc.nextInt();
//                if (x < 1 || x > 3) {
//                    System.out.println("Coordinates should be from 1 to 3!");
//                    continue;
//                }
//            } else {
//                System.out.println("You should enter numbers!");
//                continue;
//            }
//            if(sc.hasNextInt()) {
//                y = sc.nextInt();
//                System.out.println(x);System.out.println(y);
//                if (y < 1 || y > 3) {
//                    System.out.println("Coordinates should be from 1 to 3!");
//                    continue;
//                }
//            } else {
//                System.out.println("You should enter numbers!");
//                continue;
//            }
//            // x and y should be correct at this point. remember that x,y need to be adjusted (minus one)
//
//            x--; y--;
//            if (grid[x][y] == '_') {
//                // success
//
//                grid[x][y] = 'X';
//                break;
//            } else {
//                // occupied;
//                System.out.println("This cell is occupied! Choose another one!");
//            }
//        }
//
//    }

}
