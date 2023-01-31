package com.vaultec.dbapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "VER_STATUSES", schema = "VAULT")
@Immutable
public class VerificationStatus {
    @Id
    @Column(name = "VER_STATUS")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String ver_status) {
        this.status = ver_status;
    }

    @Override
    public String toString() {
        return "VerificationStatus{" +
                "ver_status='" + status + '\'' +
                '}';
    }
}
