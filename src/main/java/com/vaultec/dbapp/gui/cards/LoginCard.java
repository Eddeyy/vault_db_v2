package com.vaultec.dbapp.gui.cards;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import java.awt.*;

public class LoginCard extends DefaultCard {

    public void init() {
        super.init();
        loginLabel = new JLabel();
        passwordLabel = new JLabel();
        loginTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton();

        this.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, 200, 200, 203, 21},
                {TableLayout.PREFERRED, 101, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, 253}}));

        //---- label1 ----
        loginLabel.setText("Login:");
        loginLabel.setForeground(Color.GREEN);
        this.add(loginLabel, new TableLayoutConstraints(2, 2, 2, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        this.add(loginTextField, new TableLayoutConstraints(2, 3, 2, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- label2 ----
        passwordLabel.setText("Password:");
        passwordLabel.setForeground(Color.GREEN);
        this.add(passwordLabel, new TableLayoutConstraints(2, 4, 2, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        this.add(passwordField, new TableLayoutConstraints(2, 5, 2, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- button1 ----
        loginButton.setText("login");
        this.add(loginButton, new TableLayoutConstraints(2, 6, 2, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }


    public String[] getLoginData() {
        return new String[]{loginTextField.getText(), new String(passwordField.getPassword())};
    }

    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JTextField loginTextField;
    private JPasswordField passwordField;
    public JButton loginButton;
}
