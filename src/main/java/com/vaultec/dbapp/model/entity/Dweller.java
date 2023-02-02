package com.vaultec.dbapp.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DWELLERS", schema = "VAULT")
@ToString
@Setter
@Getter
@EqualsAndHashCode
public class Dweller {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dweller_generator")
    @SequenceGenerator(name = "dweller_generator", sequenceName = "DWELLERS_ID_SEQ", allocationSize = 1)
    @Column(name = "DWELLER_ID")
    private Long id;

    private String firstname;

    private String surname;

    private LocalDate birth_date;

    private String status;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private Long bed_id;

    @OneToMany(targetEntity = Item.class, mappedBy = "dweller", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> items;

    @OneToOne(mappedBy = "dweller")
    private LoginCredentials loginCredentials;

    public Long getDweller_id() {
        return id;
    }

    public void setDweller_id(Long dweller_id) {
        this.id = dweller_id;
    }

    @Lob
    private byte[] picture;



}
