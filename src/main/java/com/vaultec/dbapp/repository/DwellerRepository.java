package com.vaultec.dbapp.repository;

import com.vaultec.dbapp.model.entity.Dweller;
import com.vaultec.dbapp.repository.custom.CustomDwellerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DwellerRepository extends JpaRepository<Dweller, Long>, CustomDwellerRepository {
}
