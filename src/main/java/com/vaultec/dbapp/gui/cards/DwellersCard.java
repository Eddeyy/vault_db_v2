package com.vaultec.dbapp.gui.cards;

import com.vaultec.dbapp.gui.utility.AddUserWindow;
import com.vaultec.dbapp.model.entity.Dweller;
import com.vaultec.dbapp.model.entity.Job;
import com.vaultec.dbapp.model.enums.UserType;
import com.vaultec.dbapp.model.view.DwellerView;
import com.vaultec.dbapp.validation.UsableBy;
import com.vaultec.dbapp.validation.UserValidator;
import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

@Getter
@Setter
public class DwellersCard extends DefaultCard {
    public void init() {
        super.init();
        this.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, 118, 20, 99, 130, 265, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, 347, 54, 26, 53}}));

        //======== scrollPane1 ========
        {

        }

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

        try {
            if (!UserValidator.isAllowed(getCurrentDweller().getJob().getJob_title().toUpperCase(),
                this.getClass().getDeclaredMethod("init"))) {
                addUserButton.setEnabled(false);
            }
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private void fetchData() {
        List<DwellerView> dwellerList = this.getDwellerViewService().findAll();
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

        table = new JTable(new DefaultTableModel(data, headerNames)) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return !(isColumnSelected(0) || isColumnSelected(2));
            }
        };
        tablePane.setViewportView(table);
        this.add(tablePane, new TableLayoutConstraints(1, 1, 5, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        this.add(filterField, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }

    private void filter(ActionEvent e) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        sorter.setRowFilter(RowFilter.regexFilter(filterField.getText()));

        table.setRowSorter(sorter);
    }

    @UsableBy({UserType.MANAGER})
    private void addUser(ActionEvent e) {
        try {
            if (!UserValidator.isAllowed(getCurrentDweller().getJob().getJob_title().toUpperCase(),
                this.getClass().getDeclaredMethod("addUser", ActionEvent.class))) {
                System.out.println("User not allowed to perform this operation");
                return;
            }
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        addWindow = new AddUserWindow();
        addWindow.setVisible(true);
        addWindow.addButton.addActionListener(this::addUserCall);
    }

    private void addUserCall(ActionEvent e) {
        Dweller dweller = new Dweller();
        dweller.setFirstname(addWindow.getNameField().getText());
        dweller.setSurname(addWindow.getSurnameField().getText());
        dweller.setStatus("idle");

        Job job = new Job();
        job.setJob_id(0L);
        job.setJob_title("unemployed");

        dweller.setJob(job);

        getDwellerService().createDweller(dweller);

        fetchData();
        addWindow.dispose();
    }

    @Override
    public void refresh(Dweller dweller) {
        super.refresh(dweller);
    }


    private JScrollPane tablePane;
    private JButton filterButton;
    private JButton addUserButton;
    private JTable table;
    private JTextField filterField;
    private AddUserWindow addWindow;
}
