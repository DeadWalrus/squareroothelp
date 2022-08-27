package com.uicomponents;

import java.util.HashMap;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UIComponents {
    protected static HashMap<String, Button> buttons = new HashMap<String, Button>();
    protected static HashMap<String, Label> labels = new HashMap<String, Label>();
    protected static HashMap<String, TextField> textFields = new HashMap<String, TextField>();
    protected static HashMap<String, TextArea> textAreas = new HashMap<String, TextArea>();

    protected static void newButton(String name) {
        buttons.put(name, new Button(name));
    }

    protected static void newLabel(String name) {
        labels.put(name, new Label(name));
    }

    protected static void newTextField(String name) {
        textFields.put(name, new TextField(name));
    }

    protected static void newTextArea(String name) {
        textAreas.put(name, new TextArea());
    }
}
