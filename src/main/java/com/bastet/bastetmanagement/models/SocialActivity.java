package com.bastet.bastetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SocialActivities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
