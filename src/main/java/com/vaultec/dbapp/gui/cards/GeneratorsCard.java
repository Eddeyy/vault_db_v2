package com.vaultec.dbapp.gui.cards;

import com.vaultec.dbapp.gui.utility.AddUserWindow;
import com.vaultec.dbapp.model.entity.Dweller;
import com.vaultec.dbapp.model.entity.Generator;
import com.vaultec.dbapp.model.entity.Job;
import com.vaultec.dbapp.model.enums.UserType;
import com.vaultec.dbapp.model.view.DwellerView;
import com.vaultec.dbapp.model.view.GeneratorView;
import com.vaultec.dbapp.services.GeneratorService;
import com.vaultec.dbapp.validation.UsableBy;
import com.vaultec.dbapp.validation.UserValidatior;
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
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.util.Vector;

@Getter
@Setter
public class GeneratorsCard extends DefaultCard {
    public void init() {

        this.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, 118, 20, 99, 130, 265, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, 347, 54, 26, 53}}));

        //======== scrollPane1 ========
        {

        }

        tablePane = new JScrollPane();
        filterField = new JTextField();
        filterButton = new JButton();
        genStatusButton = new JButton();

        fetchData();

        //---- filter button ----
        filterButton.setText("filter");
        filterButton.addActionListener(this::filter);
        this.add(filterButton, new TableLayoutConstraints(3, 3, 3, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- add user button
        genStatusButton.setText("change state");
        genStatusButton.addActionListener(this::updateGenerator);
        this.add(genStatusButton, new TableLayoutConstraints(4, 3, 4, 3, TableLayoutConstraints.RIGHT, TableLayoutConstraints.TOP));

        try {
            if (UserValidatior.isAllowed(getCurrentDweller().getJob().getJob_title().toUpperCase(),
            this.getClass().getDeclaredMethod("init"))) {
                genStatusButton.setEnabled(false);
            }
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private void fetchData() {
        List<GeneratorView> generatorList = this.getGeneratorService().findAll();
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

    @UsableBy({UserType.ENGINEER})
    private void updateGenerator(ActionEvent e) {
        try {
            if (UserValidatior.isAllowed(getCurrentDweller().getJob().getJob_title().toUpperCase(),
                    this.getClass().getDeclaredMethod("updateGenerator", ActionEvent.class))) {
                System.out.println("User not allowed to perform this operation");
                return;
            }
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }

        DefaultTableModel tm = (DefaultTableModel) table.getModel();
        Vector rowData = tm.getDataVector().elementAt(table.getSelectedRow());
        Generator generator = new Generator();

        generator.setGen_id(Long.valueOf(rowData.get(0).toString()));
        generator.setPercentage(Double.valueOf(rowData.get(1).toString().substring(0, rowData.get(1).toString().length()-1))/100); // god please forgive me xD
        generator.setSector_id(Long.valueOf(rowData.get(2).toString()));
        generator.setGen_status(rowData.get(3).toString());
        getGeneratorService().updateGenerator(generator);
        fetchData();
    }


    @Override
    public void refresh(Dweller dweller) {
        super.refresh(dweller);
    }


    private JScrollPane tablePane;
    private JButton filterButton;
    private JButton genStatusButton;
    private JTable table;
    private JTextField filterField;
    private AddUserWindow addWindow;
}
