package com.example;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
/*
 * Class responsible for all gui elements
 */
public final class UI extends Application{
    private final int MAX_HEIGHT = 500;
    private final int MAX_WIDTH = 500;
    private final int HGAP = 10;
    private final int VGAP = 10;
    private final int TEXTHEIGHT = 400;
    private final int TEXTWIDTH = 200;
    private final boolean SHOWGRIDLINES = false;
    private GridPane mainPane = new GridPane();
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage){
        declareComponentsAndSetProperties();
        setButtonControls();
        setLayout();
        mainPane.setGridLinesVisible(SHOWGRIDLINES); //debug stuff
        mainPane.setMinSize(MAX_WIDTH, MAX_HEIGHT);
        mainPane.setHgap(HGAP);
        mainPane.setVgap(VGAP);
        Scene scene = new Scene(mainPane);
        //primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setLayout() {  // Set the layout 
        
        mainPane.add(UIComponents.buttons.get("Find"), 1, 0);
        mainPane.add(UIComponents.textFields.get("Enter number"), 0, 0);
        mainPane.add(UIComponents.labels.get("Factors"), 0, 2);
        mainPane.add(UIComponents.labels.get("Perfect squares"), 2, 2);
        mainPane.add(UIComponents.textAreas.get("Factors"), 0, 3);
        mainPane.add(UIComponents.textAreas.get("Perfect Squares"), 2, 3);

    }

    private void declareComponentsAndSetProperties() {
        UIComponents.newButton("Find");
        UIComponents.newLabel("Enter Number");
        UIComponents.newTextField("Enter number");
        UIComponents.newLabel("Factors");
        UIComponents.newLabel("Perfect squares");
        UIComponents.newTextArea("Factors");
        UIComponents.newTextArea("Perfect Squares");
        UIComponents.textAreas.get("Factors").setPrefSize((double)TEXTWIDTH, (double)TEXTHEIGHT);
        UIComponents.textAreas.get("Perfect Squares").setPrefSize((double)TEXTWIDTH, (double)TEXTHEIGHT);
    }
    private void setButtonControls() {  // Set the actions for the buttons
        UIComponents.buttons.get("Find").setOnAction(UIControls.findFactorsAndPerfectSquares);
        UIComponents.textFields.get("Enter number").setOnMouseClicked(UIControls.textFieldClear);
        UIComponents.textFields.get("Enter number").setOnAction(UIControls.findFactorsAndPerfectSquares);
    }
}
