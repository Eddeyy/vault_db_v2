package com.vaultec.dbapp.services.view;

import com.vaultec.dbapp.model.view.DwellerView;
import com.vaultec.dbapp.repository.DwellerViewRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class DwellerViewService {

    private DwellerViewRepo dwellerViewRepo;

    private List<DwellerView> findAll() {
        return this.dwellerViewRepo.findAll(Sort.by(Sort.Direction.ASC, "ID"));
    }
}
