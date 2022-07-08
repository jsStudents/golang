package com.hiperskill.tictactoewithai;


import java.util.Scanner;

public class Main {
    final static char[][] array = new char[3][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        EasyBoth easyBoth = new EasyBoth();
        while (true) {
            System.out.println("Input command:");
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("exit")) {
                break;
            }
            if (command[0].equals("start")) {
                if (command.length == 3) {
                    if (command[1].equals("user") && command[2].equals("user")) {
                        gameInitial(user, user);
                        break;
                    } else if (command[1].equals("user") && command[2].equals("easy")) {
                        gameInitial(user, easyBoth);
                        break;
                    } else if (command[1].equals("easy") && command[2].equals("user")) {
                        gameInitial(easyBoth, user);
                        break;
                    } else if (command[1].equals("easy") && command[2].equals("easy")) {
                        gameInitial(easyBoth, easyBoth);
                        break;
                    } else {
                        System.out.println("Bad parameters!");
                    }
                } else {
                    System.out.println("Bad parameters!");
                }
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }

    private static void gameInitial(movable playerOne, movable playerTwo) {
        initArray();
        printGrid();
        while (true) {
            playerOne.move('X');
            printGrid();
            if (checkGrid() == 1)
                break;
            playerTwo.move('O');
            printGrid();
            if (checkGrid() == 1)
                break;
        }
    }

    static void initArray() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = ' ';
            }
        }
    }

    static void printGrid() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static int checkGrid() {
        if (checkHorizonAndVertical() == 1) {
            return 1;
        } else if (array[0][0] != ' ' && array[0][0] == array[1][1] && array[1][1] == array[2][2]) {
            System.out.println(array[0][0] + " wins");
            return 1;
        } else if (array[0][2] != ' ' && array[0][2] == array[1][1] && array[1][1] == array[2][0]) {
            System.out.println(array[0][2] + " wins");
            return 1;
        } else {
            return countCharacters();
        }
    }

    static int checkHorizonAndVertical() {
        for (int i = 0; i < 3; i++) {
            if (array[i][0] != ' ' && array[i][0] == array[i][1] && array[i][1] == array[i][2]) {
                System.out.println(array[i][0] + " wins");
                return 1;
            }
            if (array[0][i] != ' ' && array[0][i] == array[1][i] && array[1][i] == array[2][i]) {
                System.out.println(array[0][i] + " wins");
                return 1;
            }
        }
        return 0;
    }

    static int countCharacters() {
        int x = 0;
        int o = 0;
        int space = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == 'X') {
                    x++;
                } else if (array[i][j] == 'O') {
                    o++;
                } else {
                    space++;
                }
            }
        }
        return checkCharacters(x, o, space);
    }

    static int checkCharacters(int x, int o, int space) {
        if (Math.abs(x - o) > 1) {
            System.out.println("Impossible");
            return 1;
        } else if (space == 0) {
            System.out.println("Draw");
            return 1;
        }
        return 0;
    }
}