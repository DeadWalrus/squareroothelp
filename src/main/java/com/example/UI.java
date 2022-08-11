package com.example;
import java.util.Scanner;
import java.util.InputMismatchException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
/*
 * Class responsible for all gui elements
 */
public final class UI extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage){
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static int getIntInput(Scanner input) {
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
