package com.vaultec.dbapp.gui.cards;

import com.vaultec.dbapp.model.entity.Generator;
import com.vaultec.dbapp.model.entity.Item;
import com.vaultec.dbapp.model.enums.UserType;
import com.vaultec.dbapp.model.view.DwellerView;
import com.vaultec.dbapp.validation.UsableBy;
import com.vaultec.dbapp.validation.UserValidator;
import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class WarehouseCard extends DefaultCard {

    public WarehouseCard() {


    }

    public void init() {
        super.init();
        tablePane = new JScrollPane();
        filterField = new JTextField();
        filterButton = new JButton();
        reserve = new JButton();

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
        filterButton.addActionListener(this::filter);
        this.add(filterButton, new TableLayoutConstraints(3, 3, 3, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- button3 ----
        reserve.setText("reserve");
        reserve.addActionListener(this::reserve);
        this.add(reserve, new TableLayoutConstraints(5, 3, 5, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        fetch();
    }

    private void filter(ActionEvent e) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        sorter.setRowFilter(RowFilter.regexFilter(filterField.getText()));

        table.setRowSorter(sorter);
    }

    private void fetch() {
        List<Item> itemList = this.getItemService().findAll();
        Field[] header = Item.class.getDeclaredFields();
        String[] headerNames = Arrays.stream(header).map(Field::getName).toArray(String[]::new);

        Object[][] data = new Object[itemList.size()][headerNames.length];

        for (int j = 0; j < itemList.size(); j++) {
            int i = 0;
            for (Field field : Item.class.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    data[j][i++] = new PropertyDescriptor(field.getName(), Item.class).getReadMethod().invoke(itemList.get(j)).toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        table = new JTable(new DefaultTableModel(data, headerNames)) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablePane.setViewportView(table);
        this.add(tablePane, new TableLayoutConstraints(1, 1, 5, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        this.add(filterField, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }


    private void reserve(ActionEvent e) {
        DefaultTableModel tm = (DefaultTableModel) table.getModel();
        Vector rowData = tm.getDataVector().elementAt(table.getSelectedRow());
        getItemService().toggleReservation(Long.valueOf(rowData.get(0).toString()));

        fetch();
    }

    private JScrollPane tablePane;
    private JButton filterButton;
    private JButton reserve;
    private JTable table;
    private JTextField filterField;
}
