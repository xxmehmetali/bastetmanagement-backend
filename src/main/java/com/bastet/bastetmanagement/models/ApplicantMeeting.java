package com.bastet.bastetmanagement.models;

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
@Table(name = "ApplicantMeetings")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ApplicantMeeting {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="applicant")
    @JsonBackReference
    private Applicant applicant;

    @OneToOne()
    @JoinColumn(name="meetingOwner")
    private Employee meetingOwner;

    @ManyToOne
    @JoinColumn(name = "meetingPlatform")
    private MeetingPlatform meetingPlatform;

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


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Employee getMeetingOwner() {
        return meetingOwner;
    }

    public void setMeetingOwner(Employee meetingOwner) {
        this.meetingOwner = meetingOwner;
    }

    public MeetingPlatform getMeetingPlatform() {
        return meetingPlatform;
    }

    public void setMeetingPlatform(MeetingPlatform meetingPlatform) {
        this.meetingPlatform = meetingPlatform;
    }

    public Date getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(Date beginHour) {
        this.beginHour = beginHour;
    }

    public Date getEndHour() {
        return endHour;
    }

    public void setEndHour(Date endHour) {
        this.endHour = endHour;
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
}
