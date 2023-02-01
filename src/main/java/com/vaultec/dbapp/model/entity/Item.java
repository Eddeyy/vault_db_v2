package com.vaultec.dbapp.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "ITEMS", schema = "VAULT")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_gen")
    @SequenceGenerator(name = "item_gen", sequenceName = "ITEMS_ID_SEQ", allocationSize = 1)
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
