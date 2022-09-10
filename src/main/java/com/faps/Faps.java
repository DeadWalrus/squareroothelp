/*
    Author: Jay Doody
    Date: 9/9/2022
 */

package com.faps;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

class Faps {
    /*
     * Find the factors of num and return an array containing those factors
     */
    private static final int ZERO = 0;
    private static final BigInteger BIGINT_ZERO = BigInteger.valueOf(ZERO);
    private static final int ONE = 1;
    private static final BigInteger BIGINT_ONE = BigInteger.valueOf(ONE);
    protected static ArrayList<ArrayList<BigInteger>> findFactors(BigInteger num) {
        System.out.println(num);
        ArrayList<ArrayList<BigInteger>> factors = new ArrayList<>();

        for (BigInteger i = BIGINT_ONE; num.sqrt().compareTo(i) >= ZERO; i = i.add(BIGINT_ONE)) {
            if (num.mod(i).equals(BIGINT_ZERO)) {
                if (factors.size() >= ONE) {
                    if (i.equals(factors.get(factors.size() - ONE).get(ONE))
                            || factors.get(factors.size() - ONE).get(ZERO).equals(factors.get(factors.size() - ONE).get(ONE))) {
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
    protected static ArrayList<BigInteger> findPerfectSquares(ArrayList<ArrayList<BigInteger>> fact) {

        ArrayList<BigInteger> squares = new ArrayList<>();
        for (BigInteger i = BigInteger.valueOf(ZERO); i.compareTo(BigInteger.valueOf(fact.size())) < ZERO; i = i
                .add(BIGINT_ONE)) {
            for (BigInteger j = BigInteger.valueOf(ZERO); j.compareTo(BigInteger.valueOf(fact.get(ZERO).size())) < ZERO; j = j
                    .add(BIGINT_ONE)) {
                BigInteger p = fact.get(i.intValue()).get(j.intValue());
                if (p.sqrt().pow(2).equals(p)) {
                    if (BIGINT_ZERO.compareTo(BigInteger.valueOf(squares.size())) < ZERO
                            && squares.get(squares.size() - ONE).equals(fact.get(i.intValue()).get(j.intValue()))) {
                        continue;
                    }
                    squares.add(fact.get(i.intValue()).get(j.intValue()));
                }
            }
        }
        Collections.sort(squares);
        return squares;
    }
}
