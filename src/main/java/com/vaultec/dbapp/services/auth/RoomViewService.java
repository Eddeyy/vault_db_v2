package com.vaultec.dbapp.services.auth;

import com.vaultec.dbapp.model.entity.Dweller;
import com.vaultec.dbapp.repository.view.RoomViewRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class RoomViewService {

    private RoomViewRepo roomViewRepo;

}
