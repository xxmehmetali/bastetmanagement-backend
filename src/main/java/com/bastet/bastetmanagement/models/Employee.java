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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
public class Employee {
    @Id
    @Column(name = "id")
    @Type(type = "org.hibernate.type.UUIDCharType")
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

    @JoinColumn(name = "salaryCurrency")
    @ManyToOne
    private Currency salaryCurrency;

    @OneToMany
    private List<ApplicantMeeting> applicantMeetings;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @JoinColumn(name = "branch")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    private Branch branch;

    @JoinColumn(name = "department")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Department department;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SocialActivity> socialActivities = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "spendedBy")
    private List<Expense> expenses;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Dayoff> dayoffs;

    @ManyToMany(mappedBy = "attendants")
    @JsonIgnore
    private List<Meeting> meetings;

    @OneToOne
    private User user;

    @OneToMany
    private List<Task> tasks;

    @Column(name = "createdAt", updatable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @LastModifiedDate
    private Date updatedAt;

    @PreRemove
    public void onDeleteSetNull() {
        tasks.stream()
                .forEach(task -> {
                    task.setAssignedTo(null);
                    task.setAssignedFrom(null);
                    task.setReviewer(null);
                });
        dayoffs.stream()
                .forEach(dayoff -> dayoff.setEmployee(null));
        meetings.stream()
                .forEach(meeting -> meeting.setMeetingOwner(null));
        applicantMeetings.stream()
                .forEach(applicantMeeting -> applicantMeeting.setMeetingOwner(null));
        expenses.stream()
                .forEach(expense -> expense.setSpendedBy(null));

        user.setEmployee(null);
    }


}
