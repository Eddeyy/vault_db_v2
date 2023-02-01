package com.vaultec.dbapp.services;

import com.vaultec.dbapp.config.routing.WithDatabase;
import com.vaultec.dbapp.model.entity.Dweller;
import com.vaultec.dbapp.model.enums.UserType;
import com.vaultec.dbapp.repository.DwellerRepository;
import com.vaultec.dbapp.validation.UsableBy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@Setter(onMethod = @__(@Autowired))
public class DwellerService {

    DwellerRepository dwellerRepository;

    @UsableBy({UserType.MANAGER, UserType.OVERSEER})
    public boolean createDweller(Dweller dwellerToSave) {

        if(dwellerRepository.exists(Example.of(dwellerToSave))) {
            System.out.println("UNABLE TO CREATE DWELLER - DWELLER WITH GIVEN ");
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

    @UsableBy(UserType.MEDIC)
    public boolean healDweller(Dweller dwellerToHeal) {
        Dweller existing = dwellerRepository.findById(dwellerToHeal.getDweller_id()).orElse(new Dweller());

        if(!existing.getDweller_id().equals(dwellerToHeal.getDweller_id())) {
            System.out.println("DWELLER WITH GIVEN ID DOESN'T EXIST");
            return false;
        }
        if(!existing.getStatus().equals("sick")) {
            System.out.println("DWELLER IS ALREADY HEALED");
        }

        existing.setStatus("idle");
        dwellerRepository.save(existing);

        return true;
    }
}
