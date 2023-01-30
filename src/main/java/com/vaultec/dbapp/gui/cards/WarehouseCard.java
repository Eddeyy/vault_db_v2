package com.vaultec.dbapp.gui.cards;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;

public class WarehouseCard extends JPanel {

    public WarehouseCard() {
        init();
        this.setLayout(new TableLayout(new double[][]{
                {
                        TableLayout.PREFERRED, 118, 20, 99, 130, 265, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, 347, 54, 26, 53}}));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        this.add(scrollPane1, new TableLayoutConstraints(1, 1, 5, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        this.add(textField2, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- button2 ----
        button2.setText("filter");
        this.add(button2, new TableLayoutConstraints(3, 3, 3, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- button3 ----
        button3.setText("reserve/cancel");
        this.add(button3, new TableLayoutConstraints(5, 3, 5, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }

    private void init() {
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        textField2 = new JTextField();
        button2 = new JButton();
        button3 = new JButton();
    }

    private JScrollPane scrollPane1;
    private JButton button2;
    private JButton button3;
    private JTable table1;
    private JTextField textField2;
}
