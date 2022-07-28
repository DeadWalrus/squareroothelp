package com.example;
import java.util.Scanner;
import java.util.InputMismatchException;

/*
 * Class responsible for getting user input
 */
public class UI {
    public static int GetIntInput(Scanner input) {
        boolean gotInput = false;
        int in = 0;

        while (!gotInput) {

            try {
                System.out.print(": ");
                in = input.nextInt();
            } catch (InputMismatchException e) {
            
                System.out.println("Input mismatch, try again.");
                input.nextLine();
                continue;
            }
            gotInput = true;

        }
        return in;
    }
}
