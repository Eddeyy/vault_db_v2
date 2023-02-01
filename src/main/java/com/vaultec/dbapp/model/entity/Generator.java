package com.vaultec.dbapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GENERATORS", schema = "VAULT")
@Setter
@Getter
public class Generator {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_gen")
    @SequenceGenerator(name = "gen_gen", sequenceName = "GENERATORS_ID_SEQ", allocationSize = 1)
    private Long gen_id;

    @Column(nullable = false)
    private Double percentage;

    Long sector_id;

    @Column(name = "VER_STATUS")
    private String verStatus;

    private String gen_status;

    private String gen_type;

}
