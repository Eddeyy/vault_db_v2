package com.vaultec.dbapp.services;

import com.vaultec.dbapp.gui.cards.DefaultCard;
import com.vaultec.dbapp.model.entity.Dweller;
import com.vaultec.dbapp.model.enums.UserType;
import com.vaultec.dbapp.repository.DwellerRepository;
import com.vaultec.dbapp.validation.UsableBy;
import com.vaultec.dbapp.validation.UserValidator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter(onMethod = @__(@Autowired))
public class DwellerService {

    DwellerRepository dwellerRepository;

    @UsableBy({UserType.MANAGER, UserType.OVERSEER})
    public boolean createDweller(Dweller dwellerToSave) {
        try {
            if (!UserValidator.isAllowed(
                    DefaultCard.getCurrentDweller().getJob().getJob_title().toUpperCase(),
                    this.getClass().getDeclaredMethod("createDweller", Dweller.class)
            )) {
                System.out.println("USER IS UNABLE TO ADD DWELLERS.");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        if(dwellerRepository.exists(Example.of(dwellerToSave))) {
            System.out.println("UNABLE TO CREATE DWELLER - DWELLER ALREADY EXISTS");
            return false;
        }

        dwellerRepository.save(dwellerToSave);
        return true;
    }
    @UsableBy({UserType.MANAGER, UserType.MEDIC, UserType.OVERSEER})
    public boolean updateDweller(Dweller dwellerToUpdate) {
        Dweller existing = dwellerRepository.findById(dwellerToUpdate.getDweller_id()).stream().findAny().orElse(new Dweller());

        if(existing.getDweller_id().equals(dwellerToUpdate.getDweller_id())) {
            dwellerRepository.save(dwellerToUpdate);
            return true;
        }

        return false;
    }

    @UsableBy({UserType.MEDIC, UserType.OVERSEER, UserType.MANAGER})
    public boolean healDweller(Dweller dwellerToHeal) {
        try {
            if (!UserValidator.isAllowed(
                    DefaultCard.getCurrentDweller().getJob().getJob_title().toUpperCase(),
                    this.getClass().getDeclaredMethod("healDweller", Dweller.class)
            )) {
                System.out.println("USER IS UNABLE TO HEAL ANY DWELLERS.");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Dweller existing = dwellerRepository.findById(dwellerToHeal.getDweller_id()).orElse(new Dweller());

        if(!existing.getDweller_id().equals(dwellerToHeal.getDweller_id())) {
            System.out.println("DWELLER WITH GIVEN ID DOESN'T EXIST");
            return false;
        }

        if(!(existing.getStatus().equals("sick") || existing.getStatus().equals("wounded")) ) {
            System.out.println("DWELLER IS ALREADY HEALED");
            return false;
        }

        existing.setStatus("idle");
        dwellerRepository.save(existing);

        return true;
    }
}
