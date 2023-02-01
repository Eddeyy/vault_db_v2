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
    private Long comp_id;

    @ManyToOne(targetEntity = Dweller.class)
    @JoinColumn(name = "dweller_id")
    private Dweller dweller;

    private String comp_subj;

    private String comp_desc;

    @ManyToOne(targetEntity = VerificationStatus.class)
    @JoinColumn(name = "VER_STATUS")
    private VerificationStatus verStatus;
}
