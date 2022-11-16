package com.bastet.bastetmanagement.models;

import com.bastet.bastetmanagement.core.enums.Genders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Applicants")
public class Applicant {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID uuid = UUID.randomUUID();

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

    //bak
    @Column(name = "gender")
    private Genders gender;

    @Column(name = "CV")
    private String CV;

    //bak
    @Column(name = "hrAssessmentStatus")
    private long hrAssessmentStatus;

    @Column(name = "technicalAssessmentStatus")
    private long technicalAssessmentStatus;

    @Column(name = "hrReview")
    private long hrReview;

    @Column(name = "technicalReview")
    private long technicalReview;

    @Column(name = "meeting ")
    private long meeting ;

    //NOT FINISHED
}
