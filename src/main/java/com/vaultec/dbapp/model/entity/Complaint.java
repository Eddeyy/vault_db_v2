package com.vaultec.dbapp.model.entity;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "COMPLAINTS", schema = "VAULT")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comp_gen")
    @SequenceGenerator(name = "comp_gen", sequenceName = "COMPLAINTS_ID_SEQ", allocationSize = 1)
    private Long comp_id;

    @ManyToOne(targetEntity = Dweller.class)
    @JoinColumn(name = "dweller_id")
    private Dweller dweller;

    private String comp_subj;

    private String comp_desc;

    @Column(name = "VER_STATUS")
    private String verStatus;
}
