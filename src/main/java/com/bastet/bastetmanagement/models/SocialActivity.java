package com.bastet.bastetmanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "SocialActivities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialActivity {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @Column(name = "place")
    private String place;

    @OneToOne
    @JoinColumn(name = "expense")
    private Expense expense ;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "socialActivities", fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "socialActivityType")
    private SocialActivityType socialActivitiyType;
    //NOT FINISHED
}
