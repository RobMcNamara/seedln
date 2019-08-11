package com.seedln.service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String type;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "tags_acitivies",
            joinColumns = @JoinColumn(name = "activities_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id")
    )
    Set<Tag> tags;


    public Activity(String name, String type) {
        this.name = name;
        this.type = type;
    }

}
