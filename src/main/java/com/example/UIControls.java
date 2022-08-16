package com.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class UIControls {
    /*
     * Find factors and perfect squares, then output to textAreas
     */
    public static EventHandler<ActionEvent> findFactorsAndPerfectSquares = (ActionEvent e) ->{
        int [][] factors = null;
        int [] squares = null;
        int input = 0;

        // Check if textField is empty
        if(UIComponents.textFields.get("Enter number").getText().equals("")) {
            Alert alert = new Alert(AlertType.ERROR, "Please enter a number");
            alert.showAndWait();
            System.out.println("TextField empty, please enter a number");
            return;
        }

        // Try to convert textField string to int
        try {
            input = Integer.parseInt(UIComponents.textFields.get("Enter number").getText());
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(AlertType.ERROR, "Could not convert from string to int");
            alert.showAndWait();
            System.out.println("Could not convert from int to String");
            return;
        }
        
        
        factors = Faps.findFactors(input);
        squares = Faps.findPerfectSquares(input);
        

        // Clear default text in text areas
        UIComponents.textAreas.get("Factors").clear();
        UIComponents.textAreas.get("Perfect Squares").clear();

        // Append factors to text area
        for (int i = 0; i < factors.length; i++) {
            for (int j = 0; j < factors[0].length; j++) {
                UIComponents.textAreas.get("Factors").appendText(Integer.toString(factors[i][j]));
                if(j == 0) UIComponents.textAreas.get("Factors").appendText(", ");
            }
            UIComponents.textAreas.get("Factors").appendText("\n");
        }

        // Append perfect squares to text area
        for(int i = 0; i < squares.length; i++) {
            int square = squares[i];
            UIComponents.textAreas.get("Perfect Squares").appendText(Integer.toString(square));
            UIComponents.textAreas.get("Perfect Squares").appendText("\t=> " + (int)Math.sqrt(square));
            UIComponents.textAreas.get("Perfect Squares").appendText("\n");

        }
    };

    public static EventHandler<MouseEvent> textFieldClear = (MouseEvent e) -> {
        UIComponents.textFields.get("Enter number").clear();
    };
}
