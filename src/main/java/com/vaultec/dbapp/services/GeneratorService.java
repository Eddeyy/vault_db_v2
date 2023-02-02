package com.vaultec.dbapp.services;

import com.vaultec.dbapp.gui.cards.DefaultCard;
import com.vaultec.dbapp.model.entity.Generator;
import com.vaultec.dbapp.model.enums.UserType;
import com.vaultec.dbapp.model.mapper.VaultMapper;
import com.vaultec.dbapp.model.view.GeneratorView;
import com.vaultec.dbapp.repository.GeneratorRepository;
import com.vaultec.dbapp.repository.view.GeneratorViewRepo;
import com.vaultec.dbapp.validation.UsableBy;
import com.vaultec.dbapp.validation.UserValidator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter(onMethod = @__(@Autowired))
public class GeneratorService {

    private GeneratorRepository generatorRepository;
    private GeneratorViewRepo generatorViewRepo;

    @UsableBy({UserType.ENGINEER, UserType.MANAGER, UserType.OVERSEER})
    public List<GeneratorView> findAll() {
        try {
            if (!UserValidator.isAllowed(
                    DefaultCard.getCurrentDweller().getJob().getJob_title().toUpperCase(),
                    this.getClass().getDeclaredMethod("findAll")
            )) {
                System.out.println("VIEW GENERATOR STATUSES.");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return generatorViewRepo.findAll();
    }

    @UsableBy({UserType.ENGINEER, UserType.MANAGER, UserType.OVERSEER})
    public boolean updateGenerator(Generator generator) {
        try {
            if (!UserValidator.isAllowed(
                    DefaultCard.getCurrentDweller().getJob().getJob_title().toUpperCase(),
                    this.getClass().getDeclaredMethod("updateGenerator", Generator.class)
            )) {
                System.out.println("USER IS UNABLE UPDATE ANY GENERATORS.");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Optional<Generator> existing = generatorRepository.findById(generator.getGen_id());

        if(existing.isEmpty()){
            System.out.println("GENERATOR WITH GIVEN ID DOESN'T EXIST - ABBORTING.");
            return false;
        }

        Generator result = VaultMapper.mapNullSafe(generator, existing.get());
        generatorRepository.save(result);

        System.out.println("UPDATED GENERATOR STATUS SUCCESSFULLY");
        return true;
    }
}
