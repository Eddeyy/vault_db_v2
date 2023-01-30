package com.vaultec.dbapp.repository;

import com.vaultec.dbapp.config.db.DataSourceType;
import com.vaultec.dbapp.config.routing.WithDatabase;
import com.vaultec.dbapp.model.Item;
import lombok.With;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {
}
