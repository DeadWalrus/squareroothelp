package com.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

class Faps {
    /*
     *  Print the factors of num to standard output
     */
    /*public static void printFactors(int num) {
        int[][] factors = findFactors(num);
        for (int i = 0; i < factors.length; i++) {
            for (int j = 0; j < factors[i].length; j++) {
                System.out.println("\tfactors[" + i + "][" + j + "] : " + factors[i][j]);
            }
            System.out.println();
        }
    }*/
    /*
     * Find the factors of num and return an array containing those factors
     */
    public static ArrayList<ArrayList<BigInteger>> findFactors(BigInteger num) {
        ArrayList<ArrayList<BigInteger>> factors = new ArrayList<ArrayList<BigInteger>>();
        ArrayList<BigInteger> sublist = new ArrayList<>();
        for (BigInteger i = BigInteger.valueOf(1); num.compareTo(i) > 0; i = i.add(BigInteger.ONE)) {
            if (num.mod(i).equals(BigInteger.ZERO)) {
                if (factors.size() >= 1) {
                    if (i.equals(factors.get(factors.size()-1).get(1)) || factors.get(factors.size()-1).get(0).equals( factors.get(factors.size()-1).get(0))){//factors[factors.length - 1][1]
                            //|| factors[factors.length - 1][0] == factors[factors.length - 1][1]) {
                        break;
                    }
                }
                sublist.clear();
                sublist.add(i);
                sublist.add(num.divide(i));
                factors.add(sublist);//= appendFact(factors, i, num.divide(i));
            }
        }
        return factors;
    }
    /*
     * Print the perfect squares found in the factors of num
     
    public static void printPerfectSquares(int num) {
        int[] squares = new int[0];
        squares = findPerfectSquares(num);
        Arrays.sort(squares);
        System.out.printf("\t%-10s %-10s %-10s\n", "Square", "Mul", "Root");
        for (int i = 0; i < squares.length; i++) {
            System.out.printf("\t%-10d %-10d %-10.0f\n", squares[i], num / squares[i], Math.sqrt(squares[i]));
        }
    }
    */
    /*
     * Find the perfect squares and return an array containing those squares
     */
    public static ArrayList<BigInteger> findPerfectSquares(ArrayList<ArrayList<BigInteger>> fact) {
        ArrayList<BigInteger> squares = new ArrayList<>();
        ArrayList<ArrayList<BigInteger>> factors = fact;
        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(BigInteger.valueOf(factors.size())) < 0; i = i.add(BigInteger.ONE)) {
            for (BigInteger j = BigInteger.valueOf(0); j.compareTo(BigInteger.valueOf(factors.get(0).size())) < 0; j = j.add(BigInteger.ONE)) {
                if (factors.get(Integer.valueOf(i.toString())).get(Integer.valueOf(j.toString())).sqrt().mod(BigInteger.ONE).equals(BigInteger.ZERO))/*Math.sqrt((double) factors[i][j]) % 1 == 0*/ {
                    if (BigInteger.ZERO.compareTo(BigInteger.valueOf(squares.size())) < 0 && squares.get(squares.size()-1).equals(factors.get(Integer.valueOf(i.toString())).get(Integer.valueOf(j.toString()))))/*squares[squares.length - 1] == factors[i][j]) */{
                        continue;
                    }
                    squares.add(factors.get(Integer.valueOf(i.toString())).get(Integer.valueOf(j.toString())));
                    //squares = appendSquare(squares, factors[i][j]);
                }
            }
        }
        Collections.sort(squares);
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
