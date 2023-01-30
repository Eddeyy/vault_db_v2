package com.vaultec.dbapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "COMPLAINTS", schema = "VAULT")
public class Complaint {

    @Id
    private Long comp_id;

    @ManyToOne(targetEntity = Dweller.class)
    @JoinColumn(name = "dweller_id")
    private Dweller dweller;

    private String comp_subj;

    private String comp_desc;

    @ManyToOne(targetEntity = VerificationStatus.class)
    @JoinColumn(name = "VER_STATUS")
    private VerificationStatus verStatus;

    public Long getComp_id() {
        return comp_id;
    }

    public void setComp_id(Long comp_id) {
        this.comp_id = comp_id;
    }

    public Dweller getDweller() {
        return dweller;
    }

    public void setDweller(Dweller dweller) {
        this.dweller = dweller;
    }

    public String getComp_subj() {
        return comp_subj;
    }

    public void setComp_subj(String comp_subj) {
        this.comp_subj = comp_subj;
    }

    public String getComp_desc() {
        return comp_desc;
    }

    public void setComp_desc(String comp_desc) {
        this.comp_desc = comp_desc;
    }

    public VerificationStatus getVer_status() {
        return verStatus;
    }

    public void setVer_status(VerificationStatus ver_status) {
        this.verStatus = ver_status;
    }
}
