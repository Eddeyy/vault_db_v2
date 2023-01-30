package com.vaultec.dbapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "LOGIN_CREDENTIALS", schema = "VAULT")
public class LoginCredentials {

    @Id
    private String login;

    private String password;

    @OneToOne(targetEntity = Dweller.class)
    @JoinColumn(name = "dweller_id")
    private Dweller dweller;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Dweller getDweller() {
        return dweller;
    }

    public void setDweller(Dweller dweller) {
        this.dweller = dweller;
    }
}
