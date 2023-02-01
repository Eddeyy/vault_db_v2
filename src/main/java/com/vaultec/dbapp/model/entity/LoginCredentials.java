package com.vaultec.dbapp.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "LOGIN_CREDENTIALS", schema = "VAULT")
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "dweller")
public class LoginCredentials {

    @Id
    private String login;

    private String password;

    @OneToOne(targetEntity = Dweller.class)
    @JoinColumn(name = "dweller_id")
    private Dweller dweller;
}
