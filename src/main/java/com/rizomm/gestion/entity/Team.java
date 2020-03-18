package com.rizomm.gestion.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TEAMS")
@Data
public class Team {

    @Id
    private Long id;

    @NotBlank
    private String name;
}