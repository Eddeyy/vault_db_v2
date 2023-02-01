package com.vaultec.dbapp.gui.cards;
import com.vaultec.dbapp.model.entity.Dweller;
import com.vaultec.dbapp.services.DwellerService;
import com.vaultec.dbapp.services.view.DwellerViewService;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.JPanel;

@Getter
@Setter(onMethod = @__(@Autowired))
public abstract class DefaultCard extends JPanel {
    @Setter
    @Getter
    private static Dweller currentDweller;


    private DwellerViewService dwellerViewService;
    private DwellerService dwellerService;



    public void init() {

    }

    public void refresh(Dweller dweller) {
        currentDweller = dweller;
    }
}
