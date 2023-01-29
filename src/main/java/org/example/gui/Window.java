/*
 * Created by JFormDesigner on Sat Jan 21 17:30:56 CET 2023
 */

package org.example.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import info.clearthought.layout.*;
import org.example.*;
import org.example.gui.log.*;

/**
 * @author szymon
 */
public class Window extends JFrame {
    public Window() throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                e.getWindow().dispose();
                logThread.stop();
            }
        });

        initComponents();
    }

    private void back(ActionEvent e) {
        CardLayout cl = (CardLayout)(contentPanel1.getLayout());
        cl.show(contentPanel1, "MainMenu");
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        logWindow1 = new LogWindow();
        contentPanel1 = new ContentPanel();
        back = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(1000, 600));
        var contentPane = getContentPane();
        contentPane.setLayout(new TableLayout(new double[][] {
            {50, 200, 643, 59, TableLayout.PREFERRED},
            {50, 465, 25, TableLayout.PREFERRED}}));
        ((TableLayout)contentPane.getLayout()).setHGap(5);

        //======== panel1 ========
        {
            panel1.setLayout(new TableLayout(new double[][] {
                {202, 640},
                {464}}));
            ((TableLayout)panel1.getLayout()).setHGap(5);
            ((TableLayout)panel1.getLayout()).setVGap(5);

            //---- logWindow1 ----
            logWindow1.setText("text");
            panel1.add(logWindow1, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            panel1.add(contentPanel1, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        contentPane.add(panel1, new TableLayoutConstraints(1, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- back ----
        back.setText("back");
        back.setPreferredSize(new Dimension(40, 20));
        back.addActionListener(e -> back(e));
        contentPane.add(back, new TableLayoutConstraints(3, 2, 3, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        logThread = new Thread(logWindow1);
        logThread.start();
    }

    final BufferedImage image = ImageIO.read(new File("foreground.png"));
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private LogWindow logWindow1;
    private ContentPanel contentPanel1;
    private JButton back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private Thread logThread;
}
