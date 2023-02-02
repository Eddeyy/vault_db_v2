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
public class AddUserWindow extends JFrame {
    public AddUserWindow() {
        initComponents();
    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        nameLabel = new JLabel();
        nameField = new JTextField();
        surnameLabel = new JLabel();
        surnameField = new JTextField();
        addButton = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(200, 180));
        var contentPane = getContentPane();
        contentPane.setLayout(new TableLayout(new double[][] {
            {71, 98, TableLayout.PREFERRED},
            {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, 22}}));
        ((TableLayout)contentPane.getLayout()).setHGap(5);
        ((TableLayout)contentPane.getLayout()).setVGap(5);

        //---- label1 ----
        nameLabel.setText("name");
        contentPane.add(nameLabel, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        contentPane.add(nameField, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- label2 ----
        surnameLabel.setText("surname");
        contentPane.add(surnameLabel, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        contentPane.add(surnameField, new TableLayoutConstraints(1, 2, 1, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- button1 ----
        addButton.setText("add");
        contentPane.add(addButton, new TableLayoutConstraints(1, 4, 1, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel surnameLabel;
    private JTextField surnameField;
    public JButton addButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
