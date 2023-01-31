package com.vaultec.dbapp.gui.cards;

import com.vaultec.dbapp.gui.utility.AddUserWindow;
import com.vaultec.dbapp.model.entity.Dweller;
import com.vaultec.dbapp.model.view.DwellerView;
import com.vaultec.dbapp.services.view.DwellerViewService;
import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;
import jakarta.annotation.Resource;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

@Getter
@Setter
@Component
public class DwellersCard extends JPanel {

    public DwellersCard() {
        this.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, 118, 20, 99, 130, 265, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, 347, 54, 26, 53}}));

        //======== scrollPane1 ========
        {

        }

    }

    public void init() {
        tablePane = new JScrollPane();
        filterField = new JTextField();
        filterButton = new JButton();
        addUserButton = new JButton();

        fetchData();

        //---- filter button ----
        filterButton.setText("filter");
        filterButton.addActionListener(this::filter);
        this.add(filterButton, new TableLayoutConstraints(3, 3, 3, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- add user button
        addUserButton.setText("add user");
        addUserButton.addActionListener(this::addUser);
        this.add(addUserButton, new TableLayoutConstraints(4, 3, 4, 3, TableLayoutConstraints.RIGHT, TableLayoutConstraints.TOP));
    }

    private void fetchData() {
        List<DwellerView> dwellerList = dwellerViewService.findAll();
        Field[] header = DwellerView.class.getDeclaredFields();
        String[] headerNames = Arrays.stream(header).map(Field::getName).toArray(String[]::new);

        Object[][] data = new Object[dwellerList.size()][headerNames.length];

        for (int j = 0; j < dwellerList.size(); j++) {
            int i = 0;
            for (Field field : DwellerView.class.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    data[j][i++] = new PropertyDescriptor(field.getName(), DwellerView.class).getReadMethod().invoke(dwellerList.get(j)).toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        table = new JTable(new DefaultTableModel(data, headerNames));
        tablePane.setViewportView(table);
        this.add(tablePane, new TableLayoutConstraints(1, 1, 5, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        this.add(filterField, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }

    private void filter(ActionEvent e) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        sorter.setRowFilter(RowFilter.regexFilter(filterField.getText()));

        table.setRowSorter(sorter);
    }


    private void addUser(ActionEvent e) {
        // TODO validate user
        addWindow = new AddUserWindow();
        addWindow.setVisible(true);
        addWindow.addButton.addActionListener(this::addUserCall);
    }

    private void addUserCall(ActionEvent e) {
        Dweller dweller = new Dweller();
        dweller.setFirstname(addWindow.getNameField().getText());
        dweller.setSurname(addWindow.getSurnameField().getText());
        dweller.setStatus("idle");
        // TODO push data;
        fetchData();
        addWindow.dispose();
    }

    private JScrollPane tablePane;
    private JButton filterButton;
    private JButton addUserButton;
    private JTable table;
    private JTextField filterField;
    private AddUserWindow addWindow;
    @Autowired
    private DwellerViewService dwellerViewService;
}
