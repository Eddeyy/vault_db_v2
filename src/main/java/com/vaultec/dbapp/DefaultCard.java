package com.vaultec.dbapp;
import com.vaultec.dbapp.model.entity.Dweller;
import com.vaultec.dbapp.services.view.DwellerViewService;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.JPanel;

@Getter
public abstract class DefaultCard extends JPanel {

    Dweller currentDweller;


    private DwellerViewService dwellerViewService;

    @Autowired
    public final void setDwellerViewService(DwellerViewService dwellerViewService) {
        this.dwellerViewService = dwellerViewService;
    }

    public void init() {

    }
}
