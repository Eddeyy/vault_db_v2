package com.vaultec.dbapp.config.db;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum DataSourceType {
//    RADMIN_VAULT("radmin.vault"),
//    RADMIN_DWELLER("radmin.dweller"),
    HAMACHI_VAULT("hamachi.vault"),
    HAMACHI_DWELLER("hamachi.dweller");

    private final String name;
}
