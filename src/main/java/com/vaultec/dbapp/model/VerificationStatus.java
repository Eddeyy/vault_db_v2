package com.vaultec.dbapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "VER_STATUSES", schema = "VAULT")
@Immutable
public class VerificationStatus {
    @Id
    private String ver_status;

    public String getVer_status() {
        return ver_status;
    }

    public void setVer_status(String ver_status) {
        this.ver_status = ver_status;
    }

    @Override
    public String toString() {
        return "VerificationStatus{" +
                "ver_status='" + ver_status + '\'' +
                '}';
    }
}
