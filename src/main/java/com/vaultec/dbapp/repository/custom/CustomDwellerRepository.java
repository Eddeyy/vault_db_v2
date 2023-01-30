package com.vaultec.dbapp.repository.custom;

import com.vaultec.dbapp.model.Dweller;

public interface CustomDwellerRepository {

    Dweller findByCredentials(String login, String password256);
}
