package com.vaultec.dbapp.gui.cards;

import com.vaultec.dbapp.model.entity.Complaint;
import com.vaultec.dbapp.model.entity.Generator;
import com.vaultec.dbapp.model.entity.Item;
import com.vaultec.dbapp.model.enums.UserType;
import com.vaultec.dbapp.model.view.DwellerView;
import com.vaultec.dbapp.model.view.GeneratorView;
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

public class VerificationCard extends DefaultCard {

    public VerificationCard() {

    }

    public void init() {
        super.init();
        tablePane = new JScrollPane();
        filterField = new JTextField();
        filterButton = new JButton();

        itemsButton = new JButton();
        generatorsButton = new JButton();
        complaintsButton = new JButton();

        this.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, 118, 40, 99, 200, 180, 180, 180},
                {TableLayout.PREFERRED, 347, 36, 36, 36}}));

        //======== scrollPane1 ========
        {
            tablePane.setViewportView(table);
        }
        this.add(tablePane, new TableLayoutConstraints(1, 1, 7, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        this.add(filterField, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- button2 ----
        filterButton.setText("filter");
        filterButton.addActionListener(this::filter);
        this.add(filterButton, new TableLayoutConstraints(3, 3, 3, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- button3 ----
        itemsButton.setText("items");
        itemsButton.addActionListener(this::fetchItems);
        this.add(itemsButton, "5,  2");

        //---- button3 ----
        generatorsButton.setText("generators");
        generatorsButton.addActionListener(this::fetchGenerators);
        this.add(generatorsButton, "5,  3");

        //---- button3 ----
        complaintsButton.setText("complaints");
        complaintsButton.addActionListener(this::fetchComplaints);
        this.add(complaintsButton, "5,  4");

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


    private void fetchItems(ActionEvent event) {
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

    private void fetchGenerators(ActionEvent event) {
        generatorList = this.getGeneratorService().findAll();
        Field[] header = GeneratorView.class.getDeclaredFields();
        String[] headerNames = Arrays.stream(header).map(Field::getName).toArray(String[]::new);

        Object[][] data = new Object[generatorList.size()][headerNames.length];

        for (int j = 0; j < generatorList.size(); j++) {
            int i = 0;
            for (Field field : GeneratorView.class.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    data[j][i++] = new PropertyDescriptor(field.getName(), GeneratorView.class).getReadMethod().invoke(generatorList.get(j)).toString();
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

    private void fetchComplaints(ActionEvent event) {
        complaintList = this.getComplaintsService().findAll();

        try {
            Field[] headers = Complaint.class.getDeclaredFields();
            String[] headerNames = Arrays.stream(headers).map(Field::getName).toArray(String[]::new);

            Object[][] data = new Object[complaintList.size()][headers.length];

            for (int j = 0; j < complaintList.size(); j++) {
                int i = 0;
                for (Field field : Complaint.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    try {
                        data[j][i++] = new PropertyDescriptor(field.getName(), Complaint.class).getReadMethod().invoke(complaintList.get(j)).toString();
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
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }


    private JScrollPane tablePane;
    private JButton filterButton;
    private JButton itemsButton;
    private JButton generatorsButton;
    private JButton complaintsButton;
    private JTable table;
    private JTextField filterField;

    List<Complaint> complaintList;
    List<Item> itemList;
    List<GeneratorView> generatorList;

}
