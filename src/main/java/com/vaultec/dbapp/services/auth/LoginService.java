package com.vaultec.dbapp.services.auth;

import com.vaultec.dbapp.model.Dweller;
import com.vaultec.dbapp.repository.DwellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private DwellerRepository dwellerRepository;

    public Dweller verifyCredentials(String login, String password256) {
        return dwellerRepository.findByCredentials(login, password256);
    }

}

