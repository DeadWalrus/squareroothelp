package com.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

class Faps {
    /*
     * Find the factors of num and return an array containing those factors
     */
    public static ArrayList<ArrayList<BigInteger>> findFactors(BigInteger num) {
        System.out.println(num);
        ArrayList<ArrayList<BigInteger>> factors = new ArrayList<ArrayList<BigInteger>>();
        
        for (BigInteger i = BigInteger.valueOf(1); num.compareTo(i) > 0; i = i.add(BigInteger.ONE)) {
            if (num.mod(i).equals(BigInteger.ZERO)) {
                if (factors.size() >= 1) {
                    if (i.equals(factors.get(factors.size()-1).get(1)) || factors.get(factors.size()-1).get(0).equals( factors.get(factors.size()-1).get(1))){
                        break;
                    }
                }
                ArrayList<BigInteger> sublist = new ArrayList<>();
                sublist.add(i);
                sublist.add(num.divide(i));
                factors.add(sublist);
            }
        }
        return factors;
    }
    /*
     * Find the perfect squares and return an array containing those squares
     */
    public static ArrayList<BigInteger> findPerfectSquares(ArrayList<ArrayList<BigInteger>> fact) {

        ArrayList<BigInteger> squares = new ArrayList<BigInteger>();
        ArrayList<ArrayList<BigInteger>> factors = fact;
        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(BigInteger.valueOf(factors.size())) < 0; i = i.add(BigInteger.ONE)) {
            for (BigInteger j = BigInteger.valueOf(0); j.compareTo(BigInteger.valueOf(factors.get(0).size())) < 0; j = j.add(BigInteger.ONE)) {
                BigInteger p = factors.get(i.intValue()).get(j.intValue());
                if (p.sqrt().pow(2).equals(p)){
                    if (BigInteger.ZERO.compareTo(BigInteger.valueOf(squares.size())) < 0 && squares.get(squares.size()-1).equals(factors.get(i.intValue()).get(j.intValue()))){
                        continue;
                    }
                    squares.add(factors.get(i.intValue()).get(j.intValue()));
                }
            }
        }
        Collections.sort(squares);
        return squares;
    }
}
