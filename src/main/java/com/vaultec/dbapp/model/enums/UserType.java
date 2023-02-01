package com.vaultec.dbapp.model.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserType {
    UNEMPLOYED("dweller"),
    MANAGER("manager"),
    ENGINEER("engineer"),
    MEDIC("medic"),
    OVERSEER("overseer");

    private final String name;
}
