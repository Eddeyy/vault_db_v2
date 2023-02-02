package com.vaultec.dbapp.repository;

import com.vaultec.dbapp.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByDwellerId(Long id);
}
