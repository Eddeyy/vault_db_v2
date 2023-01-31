package com.vaultec.dbapp.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DWELLERS", schema = "VAULT")
@ToString
@Setter
@Getter
public class Dweller {
    @Id
    @Column(name = "DWELLER_ID")
    private Long id;

    private String firstname;

    private String surname;

    private LocalDate birth_date;

    private String status;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dweller dweller = (Dweller) o;
        return Objects.equals(firstname, dweller.firstname) && Objects.equals(surname, dweller.surname) && Objects.equals(birth_date, dweller.birth_date) && Objects.equals(status, dweller.status) && Objects.equals(job, dweller.job) && Objects.equals(bed_id, dweller.bed_id) && Objects.equals(items, dweller.items) && Objects.equals(loginCredentials, dweller.loginCredentials) && Arrays.equals(picture, dweller.picture);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(firstname, surname, birth_date, status, job, bed_id, items, loginCredentials);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }
}
