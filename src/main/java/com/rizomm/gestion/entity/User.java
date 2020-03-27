package com.rizomm.gestion.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
@Data
public class User {
    @Id
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String pseudo;

    private String photo;
}
