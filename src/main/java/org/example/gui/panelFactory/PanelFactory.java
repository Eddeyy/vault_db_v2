package org.example.gui.panelFactory;

import javax.swing.*;
import java.awt.*;

enum PanelMode {
    LOGIN,
    MAIN,
    COMPLAINT,
    DATAVIEW;
};
public class PanelFactory extends JPanel {

    public static JPanel createPanel() {

        return getLoginPanel();
    }

    static JPanel getLoginPanel() {

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.PAGE_AXIS));

        JTextField loginField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("login");
        JLabel loginText = new JLabel("Login:");
        JLabel passwordText = new JLabel("Password:");
        loginPanel.add(loginField);
        loginPanel.add(loginField);
        loginPanel.add(passwordText);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.setBackground(Color.green);

        return loginPanel;
    }
}

