package com.bastet.bastetmanagement.models;

import com.bastet.bastetmanagement.core.enums.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
    private Gender gender;

    @JoinColumn(name = "occupation")
    @ManyToOne
    private Occupation occupation;

    @Column(name = "salaryAmount")
    private int salaryAmount;

    @JoinColumn(name = "salaryCurrecy")
    @ManyToOne
    private Currency salaryCurrecy;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @JoinColumn(name = "branch")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    private Branch branch;

    @JoinColumn(name = "department")
    @ManyToOne
    private Department department;

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

    @ManyToMany(mappedBy = "attendants")
    @JsonIgnore
    private List<Meeting> meetings;

    @Column(name = "createdAt")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @LastModifiedDate
    private Date updatedAt;


}
