package com.bastet.bastetmanagement.models;

import com.bastet.bastetmanagement.core.enums.Genders;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;
import org.hibernate.type.CurrencyType;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employees")
public class Employee {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "nationalId")
    private String nationalId;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Genders gender;

    @JoinColumn(name = "occupation")
    @ManyToOne
    private Occupation occupation;

    @Column(name = "salaryAmount")
    private int salaryAmount;

    @Column(name = "salaryCurrecyType")
    private long salaryCurrecyType;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @JoinColumn(name = "branch")
    @ManyToOne
    private Branch branch;

    @Column(name = "department")
    private long department;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SocialActivity> socialActivities = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "spendedBy")
    private List<Expense> expenses;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private List<Dayoff> dayoffs;
    //NOT FINISHED

    @ManyToMany(mappedBy = "attendants",fetch = FetchType.LAZY)
    private List<TrainingSession> trainingSessions;

    @ManyToMany(mappedBy = "attendants")
    private List<Meeting> meetings;


}
