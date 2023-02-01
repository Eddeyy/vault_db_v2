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

import com.vaultec.dbapp.gui.cards.DefaultCard;
import com.vaultec.dbapp.SpringBootApp;
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

        DefaultCard.setCurrentDweller(dweller);

        for(var card : cards.values()) {
            card.refresh(dweller);
        }
        cards.get("DwellersScreen").refresh(dweller);
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

    private void generatorsOpt(ActionEvent e) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "Generators");
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
        cards.put("WarehouseScreen", SpringBootApp.apc.getBean(WarehouseCard.class));
        cards.put("MainMenuScreen", SpringBootApp.apc.getBean(MainMenuCard.class));
        cards.put("ComplaintsScreen", SpringBootApp.apc.getBean(ComplaintsCard.class));
        cards.put("HospitalScreen", SpringBootApp.apc.getBean(HospitalCard.class));
        cards.put("DwellersScreen", SpringBootApp.apc.getBean(DwellersCard.class));
        cards.put("LoginScreen", SpringBootApp.apc.getBean(LoginCard.class));
        cards.put("GeneratorsScreen", SpringBootApp.apc.getBean(GeneratorsCard.class));

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
            ((MainMenuCard)cards.get("MainMenuScreen")).generatorsOpt.addActionListener(this::generatorsOpt);
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

        //======== Generators ========
        {

        }
        add(cards.get("GeneratorsScreen"), "Generators");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    boolean isLogged() {
        return logged;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off


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
