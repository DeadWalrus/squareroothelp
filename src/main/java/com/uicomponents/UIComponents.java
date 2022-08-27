package com.uicomponents;


import java.util.HashMap;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UIComponents {
    protected HashMap<String, Button> buttons = null;
    protected HashMap<String, Label> labels = null;
    protected HashMap<String, TextField> textFields = null;
    protected HashMap<String, TextArea> textAreas = null;
    public UIComponents() {
        this.buttons = new HashMap<>();
        this.labels = new HashMap<>();
        this.textFields = new HashMap<>();
        this.textAreas = new HashMap<>();
    }
    protected void newButton(String name) {
        buttons.put(name, new Button(name));
    }

    protected void newLabel(String name) {
        labels.put(name, new Label(name));
    }

    protected void newTextField(String name) {
        textFields.put(name, new TextField(name));
    }

    protected void newTextArea(String name) {
        textAreas.put(name, new TextArea());
    }

    public Button getButton(String name) {
        return this.buttons.get(name);
    }
    public Label getLabel(String name) {
        return this.labels.get(name);
    }
    public TextField getTextField(String name) {
        return this.textFields.get(name);
    }
    public TextArea getTextArea(String name) {
        return this.textAreas.get(name);
    }
}
