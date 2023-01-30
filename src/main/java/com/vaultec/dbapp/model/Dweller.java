package com.vaultec.dbapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "DWELLERS", schema = "VAULT")
public class Dweller {
    @Override
    public String toString() {
        return "Dweller{" +
                "dweller_id=" + dweller_id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", birth_date=" + birth_date +
                ", status='" + status + '\'' +
                ", job_id=" + job_id +
                ", bed_id=" + bed_id +
                ", picture=" + Arrays.toString(picture) +
                '}';
    }

    @Id
    private Long dweller_id;

    private String firstname;

    private String surname;

    private LocalDate birth_date;

    private String status;

    private Long job_id;

    private Long bed_id;

    @OneToMany(targetEntity = Item.class, mappedBy = "dweller", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> items;

    @OneToOne(targetEntity = LoginCredentials.class, mappedBy = "dweller")
    private LoginCredentials loginCredentials;

    public Long getDweller_id() {
        return dweller_id;
    }

    public void setDweller_id(Long dweller_id) {
        this.dweller_id = dweller_id;
    }

    @Lob
    private byte[] picture;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public Long getBed_id() {
        return bed_id;
    }

    public void setBed_id(Long bed_id) {
        this.bed_id = bed_id;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
