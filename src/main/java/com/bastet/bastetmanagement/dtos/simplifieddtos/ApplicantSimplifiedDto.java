package com.bastet.bastetmanagement.dtos.simplifieddtos;

import com.bastet.bastetmanagement.core.enums.AssesmentStatus;
import com.bastet.bastetmanagement.core.enums.Gender;
import com.bastet.bastetmanagement.dtos.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantSimplifiedDto implements Dto {
    private UUID id;

    private String name;

    private String surname;

    private String address;

    private String phoneNumber;

    private Gender gender;

    private AssesmentStatus hrAssessmentStatus;

    private AssesmentStatus technicalAssessmentStatus;

    private String hrReview;

    private String technicalReview;

}
