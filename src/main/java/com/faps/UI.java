/*
    Author: Jay Doody
    Date: 9/9/2022
 */
package com.faps;

import java.io.File;

import com.uicomponents.UIComponents;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

/*
 * Class responsible for all gui elements of main interface
 */
public final class UI {

    private static final int MAX_HEIGHT = 500;
    private static final int MAX_WIDTH = 500;
    private static final int H_GAP = 10;
    private static final int V_GAP = 10;
    private static final int TEXT_HEIGHT = 400;
    private static final int TEXT_WIDTH = 200;
    private static final boolean SHOW_GRIDLINES = false;
    private static final boolean RESIZABLE = false;
    private static final File icon = new File("resources/mono-math-sqrt.png");
    private static final Image iconImage = new Image(icon.toURI().toString());
    private static final GridPane mainPane = new GridPane();
    private static final UIComponents comps = new UIComponents();
    private static final Scene scene = new Scene(mainPane);
    private static final Stage primaryStage = new Stage();

    public static void initUI() {
        declareComponentsAndSetProperties();
        setControls();
        setLayout();
        mainPane.setGridLinesVisible(SHOW_GRIDLINES); // debug stuff
        mainPane.setMinSize(MAX_WIDTH, MAX_HEIGHT);
        mainPane.setHgap(H_GAP);
        mainPane.setVgap(V_GAP);
        primaryStage.getIcons().add(iconImage);
        primaryStage.setTitle("Factor and Perfect Square Finder");
        primaryStage.setResizable(RESIZABLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Set the layout of the gui

    public static void setLayout() {

        mainPane.add(comps.getButton("Find"), 1, 0);
        mainPane.add(comps.getTextField("Enter number"), 0, 0);
        mainPane.add(comps.getLabel("Factors"), 0, 2);
        mainPane.add(comps.getLabel("Perfect squares"), 2, 2);
        mainPane.add(comps.getTextArea("Factors"), 0, 3);
        mainPane.add(comps.getTextArea("Perfect Squares"), 2, 3);

    }

    // Declare the components and their properties

    public static void declareComponentsAndSetProperties() {
        comps.newButton("Find");
        comps.newLabel("Enter Number");
        comps.newTextField("Enter number");
        comps.newLabel("Factors");
        comps.newLabel("Perfect squares");
        comps.newTextArea("Factors");
        comps.newTextArea("Perfect Squares");
        comps.getTextArea("Factors").setPrefSize( TEXT_WIDTH,  TEXT_HEIGHT);
        comps.getTextArea("Perfect Squares").setPrefSize( TEXT_WIDTH, TEXT_HEIGHT);
    }

    // Set the actions for elements when interacted with

    public static void setControls() {
        comps.getButton("Find").setOnAction(UIControls.findFactorsAndPerfectSquares);
        comps.getTextField("Enter number").setOnMouseClicked(UIControls.textFieldClear);
        comps.getTextField("Enter number").setOnAction(UIControls.findFactorsAndPerfectSquares);
    }

    public static UIComponents getComponents() {
        return comps;
    }

//    public static Scene getScene() {
//        return scene;
//    }
}
