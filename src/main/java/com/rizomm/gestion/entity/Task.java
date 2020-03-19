package com.rizomm.gestion.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Task {

    @Id
    private Long id;

    @NotNull
    private String name;

    private Integer valuePoints;

    private Date lastDone;

    private Date dueDate;
}
