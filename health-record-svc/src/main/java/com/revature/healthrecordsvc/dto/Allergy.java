package com.revature.healthrecordsvc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Allergy {
    private Integer id;

    private String name;

    public Allergy(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}