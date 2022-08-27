package com.faps;

import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

/*
 * Class responsible for all gui elements of main interface
 */
public final class UI extends Application {

    private final int MAX_HEIGHT = 500;
    private final int MAX_WIDTH = 500;
    private final int HGAP = 10;
    private final int VGAP = 10;
    private final int TEXTHEIGHT = 400;
    private final int TEXTWIDTH = 200;
    private final boolean SHOWGRIDLINES = false;
    private final boolean RESIZABLE = false;
    private final File icon = new File("resources/mono-math-sqrt.png");
    private final Image iconImage = new Image(icon.toURI().toString());
    private GridPane mainPane = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        declareComponentsAndSetProperties();
        setButtonControls();
        setLayout();
        mainPane.setGridLinesVisible(SHOWGRIDLINES); // debug stuff
        mainPane.setMinSize(MAX_WIDTH, MAX_HEIGHT);
        mainPane.setHgap(HGAP);
        mainPane.setVgap(VGAP);
        Scene scene = new Scene(mainPane);
        primaryStage.getIcons().add(iconImage);
        primaryStage.setTitle("Factor and Perfect Square Finder");
        primaryStage.setResizable(RESIZABLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Set the layout of the gui
    private void setLayout() {

        mainPane.add(UIComponents.buttons.get("Find"), 1, 0);
        mainPane.add(UIComponents.textFields.get("Enter number"), 0, 0);
        mainPane.add(UIComponents.labels.get("Factors"), 0, 2);
        mainPane.add(UIComponents.labels.get("Perfect squares"), 2, 2);
        mainPane.add(UIComponents.textAreas.get("Factors"), 0, 3);
        mainPane.add(UIComponents.textAreas.get("Perfect Squares"), 2, 3);

    }

    // Declare the components and their properties
    private void declareComponentsAndSetProperties() {
        UIComponents.newButton("Find");
        UIComponents.newLabel("Enter Number");
        UIComponents.newTextField("Enter number");
        UIComponents.newLabel("Factors");
        UIComponents.newLabel("Perfect squares");
        UIComponents.newTextArea("Factors");
        UIComponents.newTextArea("Perfect Squares");
        UIComponents.textAreas.get("Factors").setPrefSize((double) TEXTWIDTH, (double) TEXTHEIGHT);
        UIComponents.textAreas.get("Perfect Squares").setPrefSize((double) TEXTWIDTH, (double) TEXTHEIGHT);
    }

    // Set the actions for elements when interacted with
    private void setButtonControls() {
        UIComponents.buttons.get("Find").setOnAction(UIControls.findFactorsAndPerfectSquares);
        UIComponents.textFields.get("Enter number").setOnMouseClicked(UIControls.textFieldClear);
        UIComponents.textFields.get("Enter number").setOnAction(UIControls.findFactorsAndPerfectSquares);
    }
}
