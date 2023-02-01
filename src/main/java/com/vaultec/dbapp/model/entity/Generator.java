package com.vaultec.dbapp.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "GENERATORS", schema = "VAULT")
public class Generator {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_gen")
    @SequenceGenerator(name = "gen_gen", sequenceName = "GENERATORS_ID_SEQ", allocationSize = 1)
    private Long gen_id;

    @Column(nullable = false)
    private Double percentage;

    Long sector_id;

    @ManyToOne(targetEntity = VerificationStatus.class)
    private String ver_status;

    private String gen_status;

    private String gen_type;

    public Long getGen_id() {
        return gen_id;
    }

    public void setGen_id(Long gen_id) {
        this.gen_id = gen_id;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Long getSector_id() {
        return sector_id;
    }

    public void setSector_id(Long sector_id) {
        this.sector_id = sector_id;
    }

    public String getVer_status() {
        return ver_status;
    }

    public void setVer_status(String ver_status) {
        this.ver_status = ver_status;
    }

    public String getGen_status() {
        return gen_status;
    }

    public void setGen_status(String gen_status) {
        this.gen_status = gen_status;
    }

    public String getGen_type() {
        return gen_type;
    }

    public void setGen_type(String gen_type) {
        this.gen_type = gen_type;
    }

    @Override
    public String toString() {
        return "Generator{" +
                "gen_id=" + gen_id +
                ", percentage=" + percentage +
                ", sector_id=" + sector_id +
                ", ver_status='" + ver_status + '\'' +
                ", gen_status='" + gen_status + '\'' +
                ", gen_type='" + gen_type + '\'' +
                '}';
    }
}
