package com.bastet.bastetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "SocialActivities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialActivity {
    @Id
    @Column(name="id")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @Column(name = "place")
    private String place;

    @Column(name = "expense ")
    private long expense ;

    @Column(name = "attendants ")
    private long attendants ;

    //NOT FINISHED
}
