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

    /*
     * TODO
     * Create HashMap for controls
     */
    protected static EventHandler<ActionEvent> findFactorsAndPerfectSquares = (ActionEvent e) -> {
        ArrayList<ArrayList<BigInteger>> factors = null;
        ArrayList<BigInteger> squares = null;
        BigInteger input = BigInteger.valueOf(0);

        // Check if textField is empty
        if (UIComponents.textFields.get("Enter number").getText().equals("")) {
            Alert alert = new Alert(AlertType.ERROR, "Please enter a number");
            alert.showAndWait();
            System.out.println("TextField empty, please enter a number");
            return;
        }

        // Try to convert textField string to int
        try {
            input = new BigInteger(UIComponents.textFields.get("Enter number").getText());
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(AlertType.ERROR, "Could not convert from string to int");
            alert.showAndWait();
            System.out.println("Could not convert from string to int");
            return;
        }

        factors = Faps.findFactors(input);
        squares = Faps.findPerfectSquares(factors);

        // Clear default text in text areas
        UIComponents.textAreas.get("Factors").clear();
        UIComponents.textAreas.get("Perfect Squares").clear();

        // Append factors to text area
        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(BigInteger.valueOf(factors.size())) < 0; i = i
                .add(BigInteger.ONE)) {
            for (BigInteger j = BigInteger.valueOf(0); j.compareTo(BigInteger.valueOf(factors.get(0).size())) < 0; j = j
                    .add(BigInteger.ONE)) {
                UIComponents.textAreas.get("Factors")
                        .appendText(factors.get(i.intValue()).get(j.intValue()).toString());
                if (j.compareTo(BigInteger.ZERO) == 0)
                    UIComponents.textAreas.get("Factors").appendText(", ");
            }
            UIComponents.textAreas.get("Factors").appendText("\n");
        }

        // Append perfect squares to text area
        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(BigInteger.valueOf(squares.size())) < 0; i = i
                .add(BigInteger.ONE)) {
            BigInteger square = squares.get(Integer.valueOf(i.toString()));
            UIComponents.textAreas.get("Perfect Squares").appendText(square.toString());
            UIComponents.textAreas.get("Perfect Squares").appendText("  \u21D2  " + square.sqrt().toString());
            UIComponents.textAreas.get("Perfect Squares").appendText("\n");

        }
    };

    // Clear text field if it contains only alpha characters
    protected static EventHandler<MouseEvent> textFieldClear = (MouseEvent e) -> {
        System.out.println(UIComponents.textFields.get("Enter number").getText());
        if (Pattern.matches("[^0-9]+", UIComponents.textFields.get("Enter number").getText()))
            UIComponents.textFields.get("Enter number").clear();
    };
}