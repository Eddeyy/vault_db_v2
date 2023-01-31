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
@Table(name = "V_ROOMS", schema = "VAULT")
@Immutable
@Getter
@Setter
@EqualsAndHashCode
public class RoomView {

    @Id
    @Column(name = "room_id")
    private Long id;

    @Column(name = "sector_name")
    private String sectorName;

    private Long beds;
}
