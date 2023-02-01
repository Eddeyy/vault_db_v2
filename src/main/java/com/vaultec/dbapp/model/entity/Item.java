package com.vaultec.dbapp.model.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "ITEMS", schema = "VAULT")
@DynamicUpdate
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_gen")
    @SequenceGenerator(name = "item_gen", sequenceName = "ITEMS_ID_SEQ", allocationSize = 1)
    private Long item_id;

    private String item_name;

    private String item_type;

    @Column(name = "VER_STATUS")
    private String verStatus;

    @ManyToOne(targetEntity = Dweller.class)
    @JoinColumn(name = "dweller_id")
    private Dweller dweller;


}
