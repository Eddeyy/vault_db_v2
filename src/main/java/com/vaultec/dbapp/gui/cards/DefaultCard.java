package com.vaultec.dbapp.gui.cards;
import com.vaultec.dbapp.model.entity.Dweller;
import com.vaultec.dbapp.model.entity.Job;
import com.vaultec.dbapp.model.enums.JobType;
import com.vaultec.dbapp.services.ComplaintsService;
import com.vaultec.dbapp.services.DwellerService;
import com.vaultec.dbapp.services.GeneratorService;
import com.vaultec.dbapp.services.ItemService;
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
    private GeneratorService generatorService;
    private ComplaintsService complaintsService;
    private DwellerService dwellerService;
    private ItemService itemService;



    public void init() {
        currentDweller = new Dweller();
        currentDweller.setDweller_id(-1L);
        currentDweller.setJob(new Job(JobType.UNEMPLOYED));
    }

    public void refresh(Dweller dweller) {
        currentDweller = dweller;
    }
}
