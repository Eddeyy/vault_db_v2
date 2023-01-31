package com.vaultec.dbapp.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ROOMS", schema = "VAULT")
public class Room {
    @Id
    private Long room_id;

    @ManyToOne(targetEntity = Sector.class)
    @JoinColumn(name="sector_id")
    private Sector sector;

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", sector=" + sector +
                '}';
    }
}
