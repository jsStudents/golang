package com.tests;

public class Main {
    public static void main(String[] args) {
        String str = "XXXOO__O_";
        char[] ch = str.toCharArray();
        char[][] gameBoard = {{ch[0], ch[1], ch[2]},
                              {ch[3], ch[4], ch[5]},
                              {ch[6], ch[7], ch[8]}};
        for (char[] c: gameBoard) {
            for (char el : c) {
                System.out.print(el);
            }
            System.out.println();
        }

    }
}
