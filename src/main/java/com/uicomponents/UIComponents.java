/*
    Author: Jay Doody
    Date: 9/9/2022
 */
package com.uicomponents;


import java.util.HashMap;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UIComponents {

    private final HashMap<String, Button> buttons;
    private final HashMap<String, Label> labels;
    private final HashMap<String, TextField> textFields;
    private final HashMap<String, TextArea> textAreas;

    public UIComponents() {
        this.buttons = new HashMap<>();
        this.labels = new HashMap<>();
        this.textFields = new HashMap<>();
        this.textAreas = new HashMap<>();
    }
    public void newButton(String name) {
        buttons.put(name, new Button(name));
    }

    public void newLabel(String name) {
        labels.put(name, new Label(name));
    }

    public void newTextField(String name) {
        textFields.put(name, new TextField(name));
    }

    public void newTextArea(String name) {
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
