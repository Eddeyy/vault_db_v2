package com.vaultec.dbapp.services;

import com.vaultec.dbapp.model.entity.Generator;
import com.vaultec.dbapp.model.enums.UserType;
import com.vaultec.dbapp.model.mapper.VaultMapper;
import com.vaultec.dbapp.model.view.GeneratorView;
import com.vaultec.dbapp.repository.GeneratorRepository;
import com.vaultec.dbapp.repository.view.GeneratorViewRepo;
import com.vaultec.dbapp.validation.UsableBy;
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
        return generatorViewRepo.findAll();
    }

    @UsableBy({UserType.ENGINEER, UserType.MANAGER, UserType.OVERSEER})
    public boolean updateGenerator(Generator generator) {
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
