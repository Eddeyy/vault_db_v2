package com.vaultec.dbapp.gui.cards;

import com.vaultec.dbapp.gui.utility.AddComplaintWindow;
import com.vaultec.dbapp.gui.utility.AddUserWindow;
import com.vaultec.dbapp.model.entity.Complaint;
import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.List;


public class ComplaintsCard extends DefaultCard {

    public void init() {
        complaints = new JLabel();
        tablePane = new JScrollPane();
        refresh = new JButton();
        add = new JButton();
        labelPane = new JScrollPane();

        this.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, 0.60, 0.2, 0.2},
                {TableLayout.PREFERRED, 0.2, 0.2, 0.2, 0.4}}));
        ((TableLayout) this.getLayout()).setHGap(5);
        ((TableLayout) this.getLayout()).setVGap(15);

        //---- complaints ----
        complaints.setOpaque(true);
        complaints.setBackground(Color.white);
        complaints.setForeground(Color.black);
        complaints.repaint();
        complaints.setAlignmentX(SwingConstants.RIGHT);
        complaints.setAlignmentY(SwingConstants.TOP);
        complaints.setMaximumSize(new Dimension(400, 300));


        fetch();
        //======== scrollPane2 ========
        {
            tablePane.setViewportView(table);
        }
        this.add(tablePane, new TableLayoutConstraints(2, 0, 3, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        {
            labelPane.setViewportView(complaints);
            labelPane.setMaximumSize(new Dimension(400, 200));
        }
        this.add(labelPane, new TableLayoutConstraints(0, 0, 1, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- add ----
        add.setText("add");
        this.add(add, new TableLayoutConstraints(2, 3, 2, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));


        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                String subject = table.getValueAt(table.getSelectedRow(), 0).toString();
                if(subject.equals(">>NOWA SKARGA<<")) {
                    createDialogueWindow();
                    return;
                }
                String text = "<html><p>";
                for(var complaint : complaintList) {
                    if(complaint.getCompSubj().equals(subject)) {
                        text += complaint.getComp_desc();
                        text += "<br>=========================<br>";
                    }
                }
                text += "</p></html>";

                complaints.setText(text);
            }

        });

    }

    void createDialogueWindow() {
        dialogueWindow = new AddComplaintWindow();
        dialogueWindow.setVisible(true);
        dialogueWindow.addButton.addActionListener(this::addComplaint);
    }

    private void addComplaint(ActionEvent actionEvent) {
        Complaint complaint = new Complaint();
        complaint.setDweller(getCurrentDweller());
        complaint.setCompSubj(dialogueWindow.subjectField.getText());
        complaint.setComp_desc(dialogueWindow.textArea.getText());

        getComplaintsService().addComplaint(complaint);
        fetch();
    }

    private void fetch() {
        complaintList = this.getComplaintsService().findAll();
        distinctComplaintList = this.getComplaintsService().findAll().stream().map(Complaint::getCompSubj).distinct().toList();

        try {
            Field header = Complaint.class.getDeclaredField("compSubj");
            String[] complaintSubject = new String[]{"subject"};

            Object[][] viewedData = new Object[distinctComplaintList.size()][1];

            for (int j = 0; j < distinctComplaintList.size(); j++) {
                try {
                    viewedData[j][0] = distinctComplaintList.get(j);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            table = new JTable(new DefaultTableModel(viewedData, complaintSubject)) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        } catch(Exception e) {}
    }

    private JLabel complaints;
    private JScrollPane tablePane;
    private JScrollPane labelPane;
    private JTable table;
    private JButton refresh;
    private JButton add;
    private AddComplaintWindow dialogueWindow;
    List<Complaint> complaintList;
    List<String> distinctComplaintList;
}
