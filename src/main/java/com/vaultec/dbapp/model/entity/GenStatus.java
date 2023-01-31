package com.vaultec.dbapp.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "GEN_STATUSES", schema = "VAULT")
@Immutable
public class GenStatus {

    @Id
    String gen_status;

    public String getGen_status() {
        return gen_status;
    }

    public void setGen_status(String gen_status) {
        this.gen_status = gen_status;
    }

    @Override
    public String toString() {
        return "GenStatuses{" +
                "gen_status='" + gen_status + '\'' +
                '}';
    }
}
