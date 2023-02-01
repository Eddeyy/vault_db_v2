/*
 * Created by JFormDesigner on Sat Jan 21 17:24:24 CET 2023
 */

package com.vaultec.dbapp.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;

import com.vaultec.dbapp.DefaultCard;
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
    }


    private void loginButtonAction(ActionEvent e) {
        String[] loginData = ((LoginCard)cards.get("LoginScreen")).getLoginData();
        Dweller dweller = service.verifyCredentials(loginData[0], DigestUtils.sha256Hex(loginData[1]));
        if(dweller.equals(new Dweller())) {
            System.out.println("LOGINSERVICE.VERIFYCRIDENTIALS FALIED");
            return;
        }
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "MainMenu");
        logged = true;
        this.dweller = dweller;
        Dwellers.setDwellerInfo(dweller);
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

    private void hospitalOpt(ActionEvent e) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "Hospital");
    }

    private void logout(ActionEvent e) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "LoginScreen");
        logged = false;
        dweller = null;
    }


    public void initComponents() {
        cards = new HashMap<String, DefaultCard>();

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        cards.put("WarehouseScreen", new WarehouseCard());
        cards.put("MainMenuScreen", new MainMenuCard());
        cards.put("ComplaintsScreen", new ComplaintsCard());
        cards.put("HospitalScreen", new HospitalCard());
        cards.put("DwellersScreen", new DwellersCard());
        cards.put("LoginScreen", new LoginCard());

        for (var card : cards.values()) {
            card.init();
        }
        //======== this ========
        setBorder(LineBorder.createBlackLineBorder());
        setLayout(new CardLayout());

        //======== LoginScreen ========
        {
            ((LoginCard)cards.get("LoginScreen")).loginButton.addActionListener(this::loginButtonAction);
        }
        add(cards.get("LoginScreen"), "LoginScreen");

        //======== Warehouse ========
        {

        }
        add(cards.get("WarehouseScreen"), "Warehouse");

        //======== MainMenu ========
        {
            ((MainMenuCard)cards.get("MainMenuScreen")).logout.addActionListener(this::logout);
            ((MainMenuCard)cards.get("MainMenuScreen")).complaintsOpt.addActionListener(this::complaintsOpt);
            ((MainMenuCard)cards.get("MainMenuScreen")).warehouseOpt.addActionListener(this::warehouseOpt);
            ((MainMenuCard)cards.get("MainMenuScreen")).dwellersOpt.addActionListener(this::dwellersOpt);
            ((MainMenuCard)cards.get("MainMenuScreen")).hospitalOpt.addActionListener(this::hospitalOpt);
        }
        add(cards.get("MainMenuScreen"), "MainMenu");

        //======== Complaints ========
        {

        }
        add(cards.get("ComplaintsScreen"), "Complaints");

        //======== Dwellers ======
        {

        }
        add(cards.get("DwellersScreen"), "Dwellers");

        //======== Hospital =======
        {

        }
        add(cards.get("HospitalScreen"), "Hospital");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    boolean isLogged() {
        return logged;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off

    @Resource(name = "dwellersCard")
    private DwellersCard Dwellers;
    private HospitalCard Hospital;


    Map<String, DefaultCard> cards;

    private boolean logged = false;
    private Dweller dweller;
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
