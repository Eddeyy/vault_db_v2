package com.vaultec.dbapp.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum JobType {
    UNEMPLOYED("unemployed"),
    ENGINEER("engineer"),
    DOCTOR("doctor"),
    MANAGER("manager"),
    OVERSEER("overseer");

    private final String jobTitle;
}
