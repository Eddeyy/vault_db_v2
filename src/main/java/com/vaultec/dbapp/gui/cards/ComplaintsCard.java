package com.vaultec.dbapp.gui.cards;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import java.awt.*;

public class ComplaintsCard extends JPanel {

    private void init() {
        complaints = new JLabel();
        scrollPane2 = new JScrollPane();
        list1 = new JList();
        refresh = new JButton();
        add = new JButton();
    }

    public ComplaintsCard() {
        init();
        this.setLayout(new TableLayout(new double[][]{
                {489, TableLayout.PREFERRED, 56, 69, 20},
                {364, 25, 27, 37}}));
        ((TableLayout) this.getLayout()).setHGap(5);
        ((TableLayout) this.getLayout()).setVGap(15);

        //---- complaints ----
        complaints.setText("skargi");
        complaints.setBackground(Color.white);
        complaints.setForeground(Color.black);
        this.add(complaints, new TableLayoutConstraints(0, 0, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(list1);
        }
        this.add(scrollPane2, new TableLayoutConstraints(2, 0, 3, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- refresh ----
        refresh.setText("refresh");
        this.add(refresh, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- add ----
        add.setText("add");
        this.add(add, new TableLayoutConstraints(3, 2, 3, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }

    private JLabel complaints;
    private JScrollPane scrollPane2;
    private JList list1;
    private JButton refresh;
    private JButton add;
}
