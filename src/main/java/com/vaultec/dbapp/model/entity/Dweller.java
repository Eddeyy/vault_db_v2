package com.vaultec.dbapp.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DWELLERS", schema = "VAULT")
public class Dweller {
    @Override
    public String toString() {
        return "Dweller{" +
                "dweller_id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", birth_date=" + birth_date +
                ", status='" + status + '\'' +
                ", job_id=" + job_id +
                ", bed_id=" + bed_id +
                ", picture=" + Arrays.toString(picture) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dweller dweller = (Dweller) o;
        return Objects.equals(id, dweller.id)
                && Objects.equals(firstname, dweller.firstname)
                && Objects.equals(surname, dweller.surname)
                && Objects.equals(birth_date, dweller.birth_date)
                && Objects.equals(status, dweller.status)
                && Objects.equals(job_id, dweller.job_id)
                && Objects.equals(bed_id, dweller.bed_id)
                && Objects.equals(items, dweller.items)
                && Objects.equals(loginCredentials, dweller.loginCredentials)
                && Arrays.equals(picture, dweller.picture);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, firstname, surname, birth_date, status, job_id, bed_id, items, loginCredentials);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }

    @Id
    @Column(name = "DWELLER_ID")
    private Long id;

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
        return id;
    }

    public void setDweller_id(Long dweller_id) {
        this.id = dweller_id;
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
