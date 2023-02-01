package com.vaultec.dbapp.services.view;

import com.vaultec.dbapp.model.view.DwellerView;
import com.vaultec.dbapp.repository.view.DwellerViewRepo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@Getter
@Setter
public class DwellerViewService {

    private DwellerViewRepo dwellerViewRepo;

    @Autowired
    public void setDwellerViewRepo(DwellerViewRepo dwellerViewRepo) {
        this.dwellerViewRepo = dwellerViewRepo;
    }

    public List<DwellerView> findAll() {
        return this.dwellerViewRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

}
