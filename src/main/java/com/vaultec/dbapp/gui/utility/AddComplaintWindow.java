/*
 * Created by JFormDesigner on Tue Jan 31 21:55:03 CET 2023
 */

package com.vaultec.dbapp.gui.utility;

import java.awt.*;
import javax.swing.*;
import info.clearthought.layout.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author szymon
 */
@Getter
@Setter
public class AddComplaintWindow extends JFrame {
    public AddComplaintWindow() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        subjectField = new JTextField();
        subjectField.setText("subject");
        addButton = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(200, 300));
        var contentPane = getContentPane();
        contentPane.setLayout(new TableLayout(new double[][] {
                {200},
                {30, 200, 30}}));
        ((TableLayout)contentPane.getLayout()).setHGap(5);
        ((TableLayout)contentPane.getLayout()).setVGap(5);

        contentPane.add(textArea, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        contentPane.add(subjectField, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- button1 ----
        addButton.setText("add");
        contentPane.add(addButton, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    public JTextArea textArea;
    public JTextField subjectField;
    public JButton addButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
