package com.revature.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "allergy_master")
public class Allergy {
    @Id
    private Integer id;
    private String name;
    private String description;
    private String symptoms;

}
