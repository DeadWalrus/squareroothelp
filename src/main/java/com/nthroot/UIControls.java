package com.nthroot;

import com.uicomponents.UIComponents;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UIControls {
    static UIComponents comps = UI.getComponents();

    protected static EventHandler<ActionEvent> findNthRoot = (ActionEvent e) -> {
        long index = 0;
        index = Long.parseLong(comps.getTextField("Nthroot").getText());
        
    };
}
