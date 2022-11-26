package com.bastet.bastetmanagement.models;

import com.bastet.bastetmanagement.core.enums.Genders;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @NotNull
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
