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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dweller_id", referencedColumnName = "dweller_id")
    private Dweller dweller;
}
