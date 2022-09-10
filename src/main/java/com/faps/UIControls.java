/*
    Author: Jay Doody
    Date: 9/9/2022
 */
package com.faps;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.uicomponents.UIComponents;

import java.math.BigInteger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

class UIControls {
    static UIComponents comps = UI.getComponents();
    static final int ZERO = 0;
    static final String PATTERN = "[^0-9]+";

    /*TODO: Make lambda call a function that finds the factors and perfect squares
            instead of doing it all in lambda function
    */
    protected static EventHandler<ActionEvent> findFactorsAndPerfectSquares = (ActionEvent e) -> {
        ArrayList<ArrayList<BigInteger>> factors;
        ArrayList<BigInteger> squares;
        BigInteger input;

        // Check if textField is empty
        if (comps.getTextField("Enter number").getText().equals("")) {
            Alert alert = new Alert(AlertType.ERROR, "Please enter a number");
            alert.showAndWait();
            System.out.println("TextField empty, please enter a number");
            return;
        }

        // Try to convert textField string to int
        try {
            input = new BigInteger(comps.getTextField("Enter number").getText());
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(AlertType.ERROR, "Could not convert from string to int");
            alert.showAndWait();
            System.out.println("Could not convert from string to int");
            return;
        }

        factors = Faps.findFactors(input);
        squares = Faps.findPerfectSquares(factors);

        // Clear default text in text areas
        comps.getTextArea("Factors").clear();
        comps.getTextArea("Perfect Squares").clear();

        // Append factors to text area
        for (BigInteger i = BigInteger.valueOf(ZERO); i.compareTo(BigInteger.valueOf(factors.size())) < ZERO; i = i
            .add(BigInteger.ONE)) {
            for (BigInteger j = BigInteger.valueOf(ZERO); j.compareTo(BigInteger.valueOf(factors.get(ZERO).size())) < ZERO; j = j
                .add(BigInteger.ONE)) {
                comps.getTextArea("Factors")
                    .appendText(factors.get(i.intValue()).get(j.intValue()).toString());
                if (j.compareTo(BigInteger.ZERO) == ZERO)
                    comps.getTextArea("Factors").appendText(", ");
            }
            comps.getTextArea("Factors").appendText("\n");
        }

        // Append perfect squares to text area
        for (BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.valueOf(squares.size())) < ZERO; i = i
            .add(BigInteger.ONE)) {
            BigInteger square = squares.get(i.intValue());
            comps.getTextArea("Perfect Squares").appendText(square.toString());
            comps.getTextArea("Perfect Squares").appendText("  \u21D2  " + square.sqrt().toString());
            comps.getTextArea("Perfect Squares").appendText("\n");

        }
    };

    // Clear text field if it contains only alpha characters
    protected static EventHandler<MouseEvent> textFieldClear = (MouseEvent e) -> {
        System.out.println(comps.getTextField("Enter number").getText());
        if (Pattern.matches(PATTERN, comps.getTextField("Enter number").getText()))
            comps.getTextField("Enter number").clear();
    };
}
