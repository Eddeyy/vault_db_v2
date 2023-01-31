package com.vaultec.dbapp.repository;

import com.vaultec.dbapp.model.view.DwellerView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DwellerViewRepo extends JpaRepository<DwellerView, Long> {
}
