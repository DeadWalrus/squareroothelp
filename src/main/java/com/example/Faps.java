package com.example;

import java.util.Arrays;

class Faps {
    /*
     *  Print the factors of num to standard output
     */
    public static void printFactors(int num) {
        int[][] factors = findFactors(num);
        for (int i = 0; i < factors.length; i++) {
            for (int j = 0; j < factors[i].length; j++) {
                System.out.println("\tfactors[" + i + "][" + j + "] : " + factors[i][j]);
            }
            System.out.println();
        }
    }
    /*
     * Find the factors of num and return an array containing those factors
     */
    public static int[][] findFactors(int num) {
        int[][] factors = new int[0][0];
        for (int i = 1; i < num / 2; i++) {
            if (num % i == 0) {
                if (factors.length >= 1) {
                    if (i == factors[factors.length - 1][1]
                            || factors[factors.length - 1][0] == factors[factors.length - 1][1]) {
                        break;
                    }
                }
                factors = appendFact(factors, i, num / i);
            }
        }
        return factors;
    }
    /*
     * Print the perfect squares found in the factors of num
     */
    public static void printPerfectSquares(int num) {
        int[] squares = new int[0];
        squares = findPerfectSquares(num);
        Arrays.sort(squares);
        System.out.printf("\t%-10s %-10s %-10s\n", "Square", "Mul", "Root");
        for (int i = 0; i < squares.length; i++) {
            System.out.printf("\t%-10d %-10d %-10.0f\n", squares[i], num / squares[i], Math.sqrt(squares[i]));
        }
    }
    /*
     * Find the perfect squares and return an array containing those squares
     */
    public static int[] findPerfectSquares(int num) {
        int[] squares = new int[0];
        int[][] factors = findFactors(num);
        for (int i = 0; i < factors.length; i++) {
            for (int j = 0; j < factors[0].length; j++) {
                if (Math.sqrt((double) factors[i][j]) % 1 == 0) {
                    if (squares.length > 0 && squares[squares.length - 1] == factors[i][j]) {
                        continue;
                    }
                    squares = appendSquare(squares, factors[i][j]);
                }
            }
        }
        return squares;
    }


    /*
     * Returns a new array containing the newly found factor
     */
    private static int[][] appendFact(int[][] factors, int i, int j) {
        int[][] newArray = new int[factors.length + 1][2];
        for (int k = 0; k < factors.length; k++) {
            newArray[k] = factors[k];
        }
        newArray[newArray.length - 1][0] = i;
        newArray[newArray.length - 1][1] = j;
        return newArray;
    }
    /*
     * Returns a new array containing the newly found perfect square
     */
    private static int[] appendSquare(int[] squares, int num) {
        int[] newSquares = new int[squares.length + 1];
        for (int i = 0; i < squares.length; i++) {
            newSquares[i] = squares[i];
        }
        newSquares[newSquares.length - 1] = num;
        return newSquares;
    }
}
