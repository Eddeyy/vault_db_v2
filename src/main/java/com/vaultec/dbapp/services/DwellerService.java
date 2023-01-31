package com.vaultec.dbapp.services;

import com.vaultec.dbapp.model.entity.Dweller;
import com.vaultec.dbapp.repository.DwellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DwellerService {

    @Autowired
    DwellerRepository dwellerRepository;

    public boolean createDweller(Dweller dwellerToSave) {

        Dweller existing = dwellerRepository.findById(dwellerToSave.getDweller_id()).stream().findAny().orElse(new Dweller());

        if(existing.equals(dwellerToSave)) {
            System.out.println("UNABLE TO CREATE DWELLER - DWELLER WITH GIVEN ");
            return false;
        }
        dwellerRepository.save(dwellerToSave);

        return true;
    }
}
