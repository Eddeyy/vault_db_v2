package com.vaultec.dbapp.repository;

import com.vaultec.dbapp.model.Dweller;
import com.vaultec.dbapp.repository.custom.CustomDwellerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DwellerRepository extends JpaRepository<Dweller, Long>, CustomDwellerRepository {
}
