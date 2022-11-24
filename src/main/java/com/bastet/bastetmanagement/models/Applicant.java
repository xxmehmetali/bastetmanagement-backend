package com.bastet.bastetmanagement.models;

import com.bastet.bastetmanagement.core.enums.Genders;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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
    private Genders gender;

    @JoinColumn(name = "CV")
    @OneToOne(fetch = FetchType.LAZY)
    private Cv CV;

    //bak
    @Column(name = "hrAssessmentStatus")
    private long hrAssessmentStatus;

    @Column(name = "technicalAssessmentStatus")
    private long technicalAssessmentStatus;

    @Column(name = "hrReview")
    private long hrReview;

    @Column(name = "technicalReview")
    private long technicalReview;

    @OneToOne()
   // @JoinColumn(name = "applicantMeeting")
    @JsonIgnore
    private ApplicantMeeting applicantMeeting ;
}
