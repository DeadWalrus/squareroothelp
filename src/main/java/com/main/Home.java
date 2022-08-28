package com.main;
import com.uicomponents.UIComponents;
import com.interfaces.UserInterface;
import com.faps.UI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.GridPane;

public class Home extends Application implements UserInterface{
    private final int MAX_HEIGHT = 100;
    private final int MAX_WIDTH = 200;
    private final int HGAP = 10;
    private final int VGAP = 10;
    private final boolean SHOWGRIDLINES = false;
    private final boolean RESIZEABLE = false;
    private GridPane homePane = new GridPane();
    private UIComponents comps = new UIComponents();
    private static Stage stage = null;
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        declareComponentsAndSetProperties();
        setControls();
        setLayout();
        homePane.setGridLinesVisible(SHOWGRIDLINES); // debug stuff
        homePane.setMinSize(MAX_WIDTH, MAX_HEIGHT);
        homePane.setHgap(HGAP);
        homePane.setVgap(VGAP);
        Scene homeScene = new Scene(homePane);
        stage = primaryStage;
        stage.setResizable(RESIZEABLE);
        stage.setScene(homeScene);
        stage.show();
    }

    @Override
    public void setLayout() {
        homePane.add(comps.getButton("faps"), 0, 0);
        
    }

    @Override
    public void declareComponentsAndSetProperties() {
        comps.newButton("faps");
        
    }

    @Override
    public void setControls() {
        comps.getButton("faps").setOnAction((e) -> {
            UI.initUI();
        });
        
    }
}
