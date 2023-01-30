/*
 * Created by JFormDesigner on Sat Jan 21 17:24:24 CET 2023
 */

package com.vaultec.dbapp.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import com.vaultec.dbapp.gui.cards.ComplaintsCard;
import com.vaultec.dbapp.gui.cards.LoginCard;
import com.vaultec.dbapp.gui.cards.MainMenuCard;
import com.vaultec.dbapp.gui.cards.WarehouseCard;
import org.springframework.stereotype.Component;

/**
 * @author szymon
 */
@Component
public class ContentPanel extends JPanel {
    public ContentPanel() {
        initComponents();
    }


    private void button1(ActionEvent e) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "MainMenu");
    }


    private void warehouseOpt(ActionEvent e) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "Warehouse");
    }

    private void complaintsOpt(ActionEvent e) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "Complaints");
    }

    private void logout(ActionEvent e) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "LoginScreen");
    }




    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        LoginScreen = new LoginCard();
        Warehouse = new WarehouseCard();

        MainMenu = new MainMenuCard(this);
        menuBar1 = new JMenuBar();
        username = new JLabel();
        userType = new JLabel();
        userData = new JLabel();
        logout = new JButton();
        Complaints = new ComplaintsCard();

        //======== this ========
        setBorder(LineBorder.createBlackLineBorder());
        setLayout(new CardLayout());

        //======== LoginScreen ========
        {
            LoginScreen.button1.addActionListener(this::button1);
        }
        add(LoginScreen, "LoginScreen");

        //======== Warehouse ========
        add(Warehouse, "Warehouse");

        //======== MainMenu ========
        {
            MainMenu.logout.addActionListener(this::logout);
            MainMenu.complaintsOpt.addActionListener(this::complaintsOpt);
            MainMenu.warehouseOpt.addActionListener(this::warehouseOpt);
        }
        add(MainMenu, "MainMenu");

        //======== Complaints ========
        {

        }
        add(Complaints, "Complaints");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private LoginCard LoginScreen;



    private WarehouseCard Warehouse;

    private MainMenuCard MainMenu;
    private JMenuBar menuBar1;

    private JLabel username;
    private JLabel userType;
    private JLabel userData;
    private JButton logout;
    private ComplaintsCard Complaints;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
