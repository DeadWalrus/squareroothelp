package com.example;


import java.util.Scanner;

public final class App {
    private App() {
    }

    /**
     * Finds factors and perfect squares for inputted number
     *
     * @param args The arguments of the program.
     */
    
    public static void main(String[] args) {
        boolean running = true;
        Scanner input = new Scanner(System.in); // Declare scanner in main. When scanner closes, it closes system.in
        loop(input, running);
        input.close();
    }


    public static void loop(Scanner input, boolean running){
        while (running) {

            //ADD QUICK MODE WHERE IT DOESN'T ASK EVERYTIME
            System.out.println("Would you like to:\nFind factors[1]?\nFind perfect squares[2]?\nBof[3]?\nExit[0]?");

            int answer = UI.GetIntInput(input);

            if (answer == 0) {
                System.out.println("Goodbye!");
                input.close();
                running = false;
                return;
            } else if (answer < 0 || answer > 3) {
                System.out.println("***Invalid choice, please try again***");
                continue;
            }

            System.out.print("Enter number ");
            int num = UI.GetIntInput(input);
            switch (answer) {
                case 1:
                    Faps.PrintFactors(num);
                    break;
                case 2:
                    Faps.PrintPerfectSquares(num);
                    break;
                case 3:
                    Faps.PrintFactors(num);
                    Faps.PrintPerfectSquares(num);
                    break;
                default:
                    System.out.println("Something went wrong. Try again.");
                    continue;
            }
        }
    }
}

