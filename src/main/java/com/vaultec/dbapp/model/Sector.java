package com.vaultec.dbapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SECTORS", schema = "VAULT")
public class Sector {

    @Id
    private Long sector_id;

    private String sector_name;

    @OneToMany(targetEntity = Room.class, mappedBy = "sector", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Room> rooms;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Long getSector_id() {
        return sector_id;
    }

    public void setSector_id(Long sector_id) {
        this.sector_id = sector_id;
    }

    public String getSector_name() {
        return sector_name;
    }

    public void setSector_name(String sector_name) {
        this.sector_name = sector_name;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "sector_id=" + sector_id +
                ", sector_name='" + sector_name + '\'' +
                '}';
    }
}
