/*
 * Created by JFormDesigner on Sat Jan 21 17:30:56 CET 2023
 */

package com.vaultec.dbapp.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.vaultec.dbapp.gui.background.BackgroundPanel;
import com.vaultec.dbapp.gui.log.*;
import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author szymon
 */
@Component
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
    }

    private void back(ActionEvent e) {
        CardLayout cl = (CardLayout)(contentPanel1.getLayout());

        if(contentPanel1.isLogged()) {
            cl.show(contentPanel1, "MainMenu");
            return;
        }
        System.out.println("Log in first!!!");
    }



    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
//        logWindow1 = new LogWindow();
//        contentPanel1 = new ContentPanel();
        back = new JButton();

        contentPanel1.initComponents();

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

        //----- background -----
        background= new BackgroundPanel(image);
    }

    final BufferedImage image = ImageIO.read(new File("ramka.png"));
    //final Image buttonIcon = ImageIO.read(getClass().getResource("back.png"));
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private BackgroundPanel background;
    @Resource(name = "logWindow")
    private LogWindow logWindow1;
    @Resource(name = "contentPanel")
    private ContentPanel contentPanel1;
    private JButton back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private Thread logThread;

    public LogWindow getLogWindow1() {
        return logWindow1;
    }

    public void setLogWindow1(LogWindow logWindow1) {
        this.logWindow1 = logWindow1;
    }

    public ContentPanel getContentPanel1() {
        return contentPanel1;
    }

    public void setContentPanel1(ContentPanel contentPanel1) {
        this.contentPanel1 = contentPanel1;
    }

}
