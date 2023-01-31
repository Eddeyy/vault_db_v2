/*
 * Created by JFormDesigner on Sat Jan 21 17:24:24 CET 2023
 */

package com.vaultec.dbapp.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import com.vaultec.dbapp.gui.cards.*;
import com.vaultec.dbapp.model.entity.Dweller;
import com.vaultec.dbapp.services.auth.LoginService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.apache.commons.codec.digest.DigestUtils;
/**
 * @author szymon
 */
@Component
public class ContentPanel extends JPanel {
    public ContentPanel() {
        initComponents();
    }


    private void loginButtonAction(ActionEvent e) {
        String[] loginData = LoginScreen.getLoginData();
        Dweller dweller = service.verifyCredentials(loginData[0], DigestUtils.sha256Hex(loginData[1]));
        if(dweller.equals(new Dweller())) {
            System.out.println("LOGINSERVICE.VERIFYCRIDENTIALS FALIED");
            return;
        }
        MainMenu.setUserData(dweller);
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "MainMenu");
    }


    private void warehouseOpt(ActionEvent e) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "Warehouse");
    }

    private void complaintsOpt(ActionEvent e) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "Complaints");
    }

    private void dwellersOpt(ActionEvent e) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "Dwellers");
    }

    private void logout(ActionEvent e) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "LoginScreen");
    }


    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        LoginScreen = new LoginCard();
        Warehouse = new WarehouseCard();
        MainMenu = new MainMenuCard(this);
        Complaints = new ComplaintsCard();
        Dwellers = new DwellersCard();

        //======== this ========
        setBorder(LineBorder.createBlackLineBorder());
        setLayout(new CardLayout());

        //======== LoginScreen ========
        {
            LoginScreen.loginButton.addActionListener(this::loginButtonAction);
        }
        add(LoginScreen, "LoginScreen");

        //======== Warehouse ========
        {

        }
        add(Warehouse, "Warehouse");

        //======== MainMenu ========
        {
            MainMenu.logout.addActionListener(this::logout);
            MainMenu.complaintsOpt.addActionListener(this::complaintsOpt);
            MainMenu.warehouseOpt.addActionListener(this::warehouseOpt);
            MainMenu.dwellersOpt.addActionListener(this::dwellersOpt);
        }
        add(MainMenu, "MainMenu");

        //======== Complaints ========
        {

        }
        add(Complaints, "Complaints");

        //======== Dwellers ======
        {

        }
        add(Dwellers, "Dwellers");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private LoginCard LoginScreen;
    private WarehouseCard Warehouse;
    private MainMenuCard MainMenu;
    private ComplaintsCard Complaints;
    private DwellersCard Dwellers;

    @Resource(name = "loginService")
    private LoginService service;

    public void setService(LoginService service) {
        this.service = service;
    }

    public LoginService getService() {
        return service;
    }

    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
