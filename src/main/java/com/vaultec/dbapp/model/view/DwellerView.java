package com.vaultec.dbapp.model.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "V_DWELLERS", schema = "VAULT")
@Immutable
@Getter
@Setter
@EqualsAndHashCode
public class DwellerView {

    @Id
    @Column(name = "DWELLER_ID")
    private Long id;

    private String firstname;

    private String surname;

    private String job_title;

    private String status;

}
