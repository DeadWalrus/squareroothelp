package com.nthroot;

import java.util.regex.Pattern;

import com.uicomponents.UIComponents;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class UIControls {
    static UIComponents comps = UI.getComponents();

    // Find nth root of
    protected static EventHandler<ActionEvent> findNthRoot = (ActionEvent e) -> {
        long index;
        index = Long.parseLong(comps.getTextField("Nthroot").getText());
        comps.getTextField("Number").setText("" + index);
    };

    protected static EventHandler<MouseEvent> clear(String textField) {
        return new EventHandler<>(){
            @Override public void handle(MouseEvent e) {
                if(Pattern.matches("[^0-9]+", comps.getTextField(textField).getText()))
                    comps.getTextField(textField).setText("");
            }
        };
    }
}
