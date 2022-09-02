package com.main;

import com.uicomponents.UIComponents;
import com.interfaces.UserInterface;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.GridPane;

public class Home extends Application implements UserInterface{


    public static void main(String[] args) {
        launch(args);
    }

    private static final UIComponents comps = new UIComponents();
    private static final GridPane homePane = new GridPane();
    public void start(Stage primaryStage) {
        final int MAX_HEIGHT = 100;
        final int MAX_WIDTH = 200;
        final int HGAP = 10;
        final int VGAP = 10;
        final boolean SHOWGRIDLINES = false;
        final boolean RESIZEABLE = false;

        Stage stage;
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
        homePane.add(comps.getButton("nth root"), 0, 1);
    }

    @Override
    public void declareComponentsAndSetProperties() {
        comps.newButton("faps");
        comps.newButton("nth root");
    }

    @Override
    public void setControls() {
        comps.getButton("faps").setOnAction((e) -> com.faps.UI.initUI());

        comps.getButton("nth root").setOnAction((e) -> com.nthroot.UI.initUI());
    }
}
