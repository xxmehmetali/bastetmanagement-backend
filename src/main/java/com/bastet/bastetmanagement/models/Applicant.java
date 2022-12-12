package com.bastet.bastetmanagement.models;

import com.bastet.bastetmanagement.core.enums.AssesmentStatus;
import com.bastet.bastetmanagement.core.enums.Gender;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Applicants")
public class Applicant {
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

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "nationalid")
    private String nationalId;

    //bak
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JoinColumn(name = "CV")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    private Cv CV;

    //bak
    @Column(name = "hrAssessmentStatus")
    @Enumerated(EnumType.STRING)
    private AssesmentStatus hrAssessmentStatus;

    @Column(name = "technicalAssessmentStatus")
    @Enumerated(EnumType.STRING)
    private AssesmentStatus technicalAssessmentStatus;

    @Column(name = "hrReview")
    private String hrReview;

    @Column(name = "technicalReview")
    private String technicalReview;

    @Column(name = "createdAt")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @LastModifiedDate
    private Date updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicantMeeting")
    @JsonBackReference
    private ApplicantMeeting applicantMeeting;

}
