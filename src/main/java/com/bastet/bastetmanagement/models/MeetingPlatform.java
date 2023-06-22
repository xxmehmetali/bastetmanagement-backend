package com.bastet.bastetmanagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="MeetingPlatforms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MeetingPlatform {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "baseUrl")
    private String baseUrl;

    @OneToMany(mappedBy = "meetingPlatform", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Meeting> meetings;

    @OneToMany(mappedBy = "meetingPlatform", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ApplicantMeeting> applicantMeetings;

    @Column(name = "createdAt")
    @JsonIgnore
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @JsonIgnore
    @LastModifiedDate
    private Date updatedAt;

    @PreRemove
    public void onDeleteSetNull(){
        meetings.stream()
                .forEach(meeting -> meeting.setMeetingPlatform(null));
    }
}
