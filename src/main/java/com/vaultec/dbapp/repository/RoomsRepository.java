package com.vaultec.dbapp.repository;

import com.vaultec.dbapp.config.db.DataSourceType;
import com.vaultec.dbapp.config.routing.WithDatabase;
import com.vaultec.dbapp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Room, Long> {
}
