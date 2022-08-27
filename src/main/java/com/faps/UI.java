package com.faps;

import java.io.File;

import com.uicomponents.UIComponents;
import com.interfaces.UserInterface;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

/*
 * Class responsible for all gui elements of main interface
 */
public final class UI extends Application implements UserInterface {

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
    private static UIComponents comps = new UIComponents();

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        declareComponentsAndSetProperties();
        setControls();
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
    public void setLayout() {

        mainPane.add(comps.getButton("Find"), 1, 0);
        mainPane.add(comps.getTextField("Enter number"), 0, 0);
        mainPane.add(comps.getLabel("Factors"), 0, 2);
        mainPane.add(comps.getLabel("Perfect squares"), 2, 2);
        mainPane.add(comps.getTextArea("Factors"), 0, 3);
        mainPane.add(comps.getTextArea("Perfect Squares"), 2, 3);

    }

    // Declare the components and their properties
    public void declareComponentsAndSetProperties() {
        comps.newButton("Find");
        comps.newLabel("Enter Number");
        comps.newTextField("Enter number");
        comps.newLabel("Factors");
        comps.newLabel("Perfect squares");
        comps.newTextArea("Factors");
        comps.newTextArea("Perfect Squares");
        comps.getTextArea("Factors").setPrefSize((double) TEXTWIDTH, (double) TEXTHEIGHT);
        comps.getTextArea("Perfect Squares").setPrefSize((double) TEXTWIDTH, (double) TEXTHEIGHT);
    }

    // Set the actions for elements when interacted with
    public void setControls() {
        comps.getButton("Find").setOnAction(UIControls.findFactorsAndPerfectSquares);
        comps.getTextField("Enter number").setOnMouseClicked(UIControls.textFieldClear);
        comps.getTextField("Enter number").setOnAction(UIControls.findFactorsAndPerfectSquares);
    }

    public static UIComponents getComponents() {
        return comps;
    }
}
