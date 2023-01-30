package com.vaultec.dbapp.model;


import jakarta.persistence.*;

@Entity
@Table(name = "ITEMS", schema = "VAULT")
public class Item {

    @Id
    private Long item_id;

    private String item_name;

    private String item_type;

    @ManyToOne(targetEntity = VerificationStatus.class)
    @JoinColumn(name = "ver_status")
    private VerificationStatus ver_status;

    @ManyToOne(targetEntity = Dweller.class)
    @JoinColumn(name = "dweller_id")
    private Dweller dweller;


}
