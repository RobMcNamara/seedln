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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String type;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "tags_activities",
            joinColumns = @JoinColumn(name = "activities_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id")
    )
    Set<Tag> tags;


    public Activity(String title, String type) {
        this.title = title;
        this.type = type;
    }

}
