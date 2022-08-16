package com.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UIControls {
    public static EventHandler<ActionEvent> findFactorsAndPerfectSquares = (ActionEvent e) ->{
        int [][] factors = null;
        int [] squares = null;
        try {
            factors = Faps.findFactors(Integer.parseInt(UIComponents.textFields.get("Enter number").getText()));
            squares = Faps.findPerfectSquares(Integer.parseInt(UIComponents.textFields.get("Enter number").getText()));
        } catch (NumberFormatException ex) {
            System.out.println("Could not convert from int to String");
            
        }
        
        // Append factors to text area
        UIComponents.textAreas.get("Factors").clear();
        for (int i = 0; i < factors.length; i++) {
            for (int j = 0; j < factors[0].length; j++) {
                UIComponents.textAreas.get("Factors").appendText(Integer.toString(factors[i][j]));
                UIComponents.textAreas.get("Factors").appendText(", ");
            }
            UIComponents.textAreas.get("Factors").appendText("\n");
        }

        // Append perfect squares to text area
        UIComponents.textAreas.get("Perfect Squares").clear();
        for(int i = 0; i < squares.length; i++) {
            UIComponents.textAreas.get("Perfect Squares").appendText(Integer.toString(squares[i]));
            UIComponents.textAreas.get("Perfect Squares").appendText("\n");

        }
    };
}
