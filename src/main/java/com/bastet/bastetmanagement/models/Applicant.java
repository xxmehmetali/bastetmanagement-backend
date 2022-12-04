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

//@Getter
//@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Applicants")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Applicant {
    private static final long serialVersionUID = 2L;
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

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "applicantMeeting")
    @JsonManagedReference
    private ApplicantMeeting applicantMeeting;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Cv getCV() {
        return CV;
    }

    public void setCV(Cv CV) {
        this.CV = CV;
    }

    public AssesmentStatus getHrAssessmentStatus() {
        return hrAssessmentStatus;
    }

    public void setHrAssessmentStatus(AssesmentStatus hrAssessmentStatus) {
        this.hrAssessmentStatus = hrAssessmentStatus;
    }

    public AssesmentStatus getTechnicalAssessmentStatus() {
        return technicalAssessmentStatus;
    }

    public void setTechnicalAssessmentStatus(AssesmentStatus technicalAssessmentStatus) {
        this.technicalAssessmentStatus = technicalAssessmentStatus;
    }

    public String getHrReview() {
        return hrReview;
    }

    public void setHrReview(String hrReview) {
        this.hrReview = hrReview;
    }

    public String getTechnicalReview() {
        return technicalReview;
    }

    public void setTechnicalReview(String technicalReview) {
        this.technicalReview = technicalReview;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ApplicantMeeting getApplicantMeeting() {
        return applicantMeeting;
    }

    public void setApplicantMeeting(ApplicantMeeting applicantMeeting) {
        this.applicantMeeting = applicantMeeting;
    }
}
