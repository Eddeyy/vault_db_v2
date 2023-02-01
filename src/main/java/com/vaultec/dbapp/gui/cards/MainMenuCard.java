package com.vaultec.dbapp.gui.cards;

import com.vaultec.dbapp.model.entity.Dweller;
import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import java.awt.*;

public class MainMenuCard extends DefaultCard {
    public void init() {
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        warehouseOpt = new JMenuItem();
        userData = new JLabel();
        complaintsOpt = new JMenuItem();
        dwellersOpt = new JMenuItem();
        hospitalOpt = new JMenuItem();
        generatorsOpt = new JMenu();
        username = new JLabel();
        userType = new JLabel();
        logout = new JButton();

        this.setLayout(new TableLayout(new double[][]{
                {116, 394, 99, 33},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, 28, 390}}));
        ((TableLayout) this.getLayout()).setHGap(5);
        ((TableLayout) this.getLayout()).setVGap(5);
        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("menu");
                menu1.setMinimumSize(new Dimension(120, 23));
                menu1.setMaximumSize(new Dimension(120, 32767));

                //---- warehouseOpt ----
                warehouseOpt.setText("warehouse");
                menu1.add(warehouseOpt);

                //---- complaintsOpt ----
                complaintsOpt.setText("complaints");
                menu1.add(complaintsOpt);

                //---- dwellersOpt ----
                dwellersOpt.setText("dwellers");
                menu1.add(dwellersOpt);

                //---- hospitalOpt
                hospitalOpt.setText("hospital");
                menu1.add(hospitalOpt);
            }
            menuBar1.add(menu1);
        }
        this.add(menuBar1, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- username ----
        username.setText("user");
        this.add(username, new TableLayoutConstraints(2, 0, 3, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- userType ----
        userType.setText("userType");
        this.add(userType, new TableLayoutConstraints(2, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- userData ----
        userData.setText("otherData");
        this.add(userData, new TableLayoutConstraints(2, 2, 3, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- logout ----
        logout.setText("logout");

        this.add(logout, new TableLayoutConstraints(2, 3, 2, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }


    public void setUserData(Dweller dweller) {
        username.setText(dweller.getFirstname());
        userType.setText(dweller.getStatus());
        userData.setText("id: " + dweller.getDweller_id());
    }

    @Override
    public void refresh(Dweller dweller) {
        super.refresh(dweller);
        setDataFields();
    }

    private void setDataFields() {
        username.setText("name: "+getCurrentDweller().getFirstname());
        userType.setText("job: "+getCurrentDweller().getJob().getJob_title());
        userData.setText("id: "+getCurrentDweller().getId());

    }
    private JMenuBar menuBar1;
    private JMenu menu1;
    public JMenuItem warehouseOpt;
    public JMenuItem complaintsOpt;

    public JMenuItem generatorsOpt;
    public JMenuItem dwellersOpt;
    public JMenuItem hospitalOpt;
    private JLabel username;
    private JLabel userType;
    private JLabel userData;
    public JButton logout;
}