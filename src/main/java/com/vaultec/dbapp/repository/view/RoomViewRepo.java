package com.vaultec.dbapp.repository.view;

import com.vaultec.dbapp.model.view.RoomView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomViewRepo extends JpaRepository<RoomView, Long> {
}
