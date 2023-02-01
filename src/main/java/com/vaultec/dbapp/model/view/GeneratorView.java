package com.vaultec.dbapp.model.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "V_GENERATORS", schema = "VAULT")
@Immutable
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GeneratorView {

    @Id
    @Column(name = "GEN_ID")
    private Long id;

    private String percentage;

    private Long sector_id;

    private String gen_status;
}
