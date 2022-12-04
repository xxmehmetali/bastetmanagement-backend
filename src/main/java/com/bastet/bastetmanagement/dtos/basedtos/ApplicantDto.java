package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.core.enums.AssesmentStatus;
import com.bastet.bastetmanagement.core.enums.Gender;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
public class ApplicantDto {
    private UUID id;

    private String name;

    private String surname;

    private String address;

    private String phoneNumber;

    private String nationalId;

    private Gender gender;

    private CvDto CV;

    private AssesmentStatus hrAssessmentStatus;

    private AssesmentStatus technicalAssessmentStatus;

    private String hrReview;

    private String technicalReview;

    private ApplicantMeetingDto applicantMeeting ;

    private Date createdAt;

    private Date updatedAt;
}
