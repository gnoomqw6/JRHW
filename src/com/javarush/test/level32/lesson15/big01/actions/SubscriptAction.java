package com.javarush.test.level32.lesson15.big01.actions;

import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

public class SubscriptAction extends StyledEditorKit.StyledTextAction {

    public SubscriptAction() {
        super(StyleConstants.Subscript.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
