package com.vaultec.dbapp.gui.cards;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WarehouseCard extends JPanel {

    public WarehouseCard() {
        init();
        this.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, 118, 20, 99, 130, 265, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, 347, 54, 26, 53}}));

        //======== scrollPane1 ========
        {
            tablePane.setViewportView(table);
        }
        this.add(tablePane, new TableLayoutConstraints(1, 1, 5, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        this.add(filterField, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- button2 ----
        filterButton.setText("filter");
        this.add(filterButton, new TableLayoutConstraints(3, 3, 3, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- button3 ----
        reserveCancel.setText("reserve/cancel");
        this.add(reserveCancel, new TableLayoutConstraints(5, 3, 5, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));



    }

    private void init() {
        tablePane = new JScrollPane();
        filterField = new JTextField();
        filterButton = new JButton();
        reserveCancel = new JButton();
    }

    private JScrollPane tablePane;
    private JButton filterButton;
    private JButton reserveCancel;
    private JTable table;
    private JTextField filterField;
}
