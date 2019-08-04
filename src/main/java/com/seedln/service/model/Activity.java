package com.seedln.service.model;

import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Activity {
    @Generated
    @Id
    private Long id;

    private String name;

    private String type;


    public Activity(String name, String type) {
        this.name = name;
        this.type = type;
    }

}
