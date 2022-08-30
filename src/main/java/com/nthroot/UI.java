package com.nthroot;

import com.uicomponents.UIComponents;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public final class UI{

    private final static int MAX_HEIGHT = 100;
    private final static int MAX_WIDTH = 200;
    private final static int HGAP = 10;
    private final static int VGAP = 10;
    private final static boolean SHOWGRIDLINES = false;
    private final static boolean RESIZABLE = false;
    private static GridPane mainPane = new GridPane();
    private static UIComponents comps = new UIComponents();
    private static Scene scene = new Scene(mainPane);
    private static Stage primaryStage = new Stage();

    public static void initUI() {
        declareComponentsAndSetProperties();
        setControls();
        setLayout();
    }

    private static void declareComponentsAndSetProperties() {
        comps.newButton("Find");
        comps.newTextField("Nthroot");
        comps.newTextField("Number");
    }

    private static void setLayout() {
        mainPane.add(comps.getButton("Find"), 2, 0);
        mainPane.add(comps.getTextField("Nthroot"), 0, 0);
        mainPane.add(comps.getTextField("Number"), 1, 0);
    }

    private static void setControls() {
        comps.getButton("Find").setOnAction(UIControls.findNthRoot);
    }

    public static UIComponents getComponents() {
        return comps;
    }
}
