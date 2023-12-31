package com.bastet.bastetmanagement.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ApplicantMeetings")
@EntityListeners(AuditingEntityListener.class)
public class ApplicantMeeting {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @ManyToOne()
    @JoinColumn(name = "meetingOwner")
    private Employee meetingOwner;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "meetingPlatform")
    private MeetingPlatform meetingPlatform;

    @OneToOne()
    @JoinColumn(name = "applicant")
    private Applicant applicant;

    @Column(name = "beginHour")
    private Date beginHour;

    @Column(name = "endHour")
    private Date endHour;

    @Column(name = "createdAt")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @LastModifiedDate
    private Date updatedAt;

    @PreRemove
    private void onDeleteSetNull() {
//        applicant.setApplicantMeeting(null);

    }
}
