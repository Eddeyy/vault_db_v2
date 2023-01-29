/*
 * Created by JFormDesigner on Sat Jan 21 17:24:24 CET 2023
 */

package org.example.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import info.clearthought.layout.*;

/**
 * @author szymon
 */
public class ContentPanel extends JPanel {
    public ContentPanel() {
        initComponents();
    }


    private void button1(ActionEvent e) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "MainMenu");
    }

    private void menu1MenuSelected(MenuEvent e) {
        // TODO add your code here
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
        LoginScreen = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        Warehouse = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        textField2 = new JTextField();
        button2 = new JButton();
        button3 = new JButton();
        MainMenu = new JPanel();
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        warehouseOpt = new JMenuItem();
        complaintsOpt = new JMenuItem();
        username = new JLabel();
        userType = new JLabel();
        userData = new JLabel();
        logout = new JButton();
        Complaints = new JPanel();
        complaints = new JLabel();
        scrollPane2 = new JScrollPane();
        list1 = new JList();
        refresh = new JButton();
        add = new JButton();

        //======== this ========
        setBorder(LineBorder.createBlackLineBorder());
        setLayout(new CardLayout());

        //======== LoginScreen ========
        {
            LoginScreen.setLayout(new TableLayout(new double[][] {
                {TableLayout.PREFERRED, 200, 200, 203, 21},
                {TableLayout.PREFERRED, 101, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, 253}}));

            //---- label1 ----
            label1.setText("Login:");
            LoginScreen.add(label1, new TableLayoutConstraints(2, 2, 2, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            LoginScreen.add(textField1, new TableLayoutConstraints(2, 3, 2, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label2 ----
            label2.setText("Password:");
            LoginScreen.add(label2, new TableLayoutConstraints(2, 4, 2, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            LoginScreen.add(passwordField1, new TableLayoutConstraints(2, 5, 2, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- button1 ----
            button1.setText("login");
            button1.addActionListener(e -> button1(e));
            LoginScreen.add(button1, new TableLayoutConstraints(2, 6, 2, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        add(LoginScreen, "LoginScreen");

        //======== Warehouse ========
        {
            Warehouse.setLayout(new TableLayout(new double[][] {
                {TableLayout.PREFERRED, 118, 20, 99, 130, 265, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, 347, 54, 26, 53}}));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }
            Warehouse.add(scrollPane1, new TableLayoutConstraints(1, 1, 5, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            Warehouse.add(textField2, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- button2 ----
            button2.setText("filter");
            Warehouse.add(button2, new TableLayoutConstraints(3, 3, 3, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- button3 ----
            button3.setText("reserve/cancel");
            Warehouse.add(button3, new TableLayoutConstraints(5, 3, 5, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        add(Warehouse, "Warehouse");

        //======== MainMenu ========
        {
            MainMenu.setLayout(new TableLayout(new double[][] {
                {116, 394, 99, 33},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, 28, 390}}));
            ((TableLayout)MainMenu.getLayout()).setHGap(5);
            ((TableLayout)MainMenu.getLayout()).setVGap(5);

            //======== menuBar1 ========
            {

                //======== menu1 ========
                {
                    menu1.setText("menu");
                    menu1.setMinimumSize(new Dimension(120, 23));
                    menu1.setMaximumSize(new Dimension(120, 32767));
                    menu1.addMenuListener(new MenuListener() {
                        @Override
                        public void menuCanceled(MenuEvent e) {}
                        @Override
                        public void menuDeselected(MenuEvent e) {}
                        @Override
                        public void menuSelected(MenuEvent e) {
                            menu1MenuSelected(e);
                        }
                    });

                    //---- warehouseOpt ----
                    warehouseOpt.setText("warehouse");
                    warehouseOpt.addActionListener(e -> warehouseOpt(e));
                    menu1.add(warehouseOpt);

                    //---- complaintsOpt ----
                    complaintsOpt.setText("complaints");
                    complaintsOpt.addActionListener(e -> complaintsOpt(e));
                    menu1.add(complaintsOpt);
                }
                menuBar1.add(menu1);
            }
            MainMenu.add(menuBar1, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- username ----
            username.setText("user");
            MainMenu.add(username, new TableLayoutConstraints(2, 0, 3, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- userType ----
            userType.setText("userType");
            MainMenu.add(userType, new TableLayoutConstraints(2, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- userData ----
            userData.setText("otherData");
            MainMenu.add(userData, new TableLayoutConstraints(2, 2, 3, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- logout ----
            logout.setText("logout");
            logout.addActionListener(e -> logout(e));
            MainMenu.add(logout, new TableLayoutConstraints(2, 3, 2, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        add(MainMenu, "MainMenu");

        //======== Complaints ========
        {
            Complaints.setLayout(new TableLayout(new double[][] {
                {489, TableLayout.PREFERRED, 56, 69, 20},
                {364, 25, 27, 37}}));
            ((TableLayout)Complaints.getLayout()).setHGap(5);
            ((TableLayout)Complaints.getLayout()).setVGap(15);

            //---- complaints ----
            complaints.setText("skargi");
            complaints.setBackground(Color.white);
            complaints.setForeground(Color.black);
            Complaints.add(complaints, new TableLayoutConstraints(0, 0, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(list1);
            }
            Complaints.add(scrollPane2, new TableLayoutConstraints(2, 0, 3, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- refresh ----
            refresh.setText("refresh");
            Complaints.add(refresh, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- add ----
            add.setText("add");
            Complaints.add(add, new TableLayoutConstraints(3, 2, 3, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        add(Complaints, "Complaints");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel LoginScreen;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JButton button1;
    private JPanel Warehouse;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTextField textField2;
    private JButton button2;
    private JButton button3;
    private JPanel MainMenu;
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem warehouseOpt;
    private JMenuItem complaintsOpt;
    private JLabel username;
    private JLabel userType;
    private JLabel userData;
    private JButton logout;
    private JPanel Complaints;
    private JLabel complaints;
    private JScrollPane scrollPane2;
    private JList list1;
    private JButton refresh;
    private JButton add;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
