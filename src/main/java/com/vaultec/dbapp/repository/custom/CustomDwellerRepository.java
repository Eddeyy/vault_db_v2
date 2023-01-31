package com.vaultec.dbapp.repository.custom;

import com.vaultec.dbapp.model.entity.Dweller;

public interface CustomDwellerRepository {

    Dweller findByCredentials(String login, String password256);
}
