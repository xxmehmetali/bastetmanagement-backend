package com.bastet.bastetmanagement.models;

import com.bastet.bastetmanagement.core.enums.MeetingType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Meetings")
public class Meeting {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @JoinColumn(name = "meetingOwner")
    @OneToOne
    private Employee meetingOwner;

    @Column(name = "topic")
    private String topic;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "meetingPlatform")
    @ManyToOne
    @JsonManagedReference
    private MeetingPlatform meetingPlatform;

    @Column(name = "meetingType")
    @Enumerated(EnumType.STRING)
    private MeetingType meetingType;

    @Column(name = "meetingUrl")
    private String meetingUrl;

    @Column(name = "beginHour")
    private Date beginHour;

    @Column(name = "endHour")
    private Date endHour;

    @ManyToMany
    private List<Employee> attendants;

    @Column(name = "createdAt")
    @JsonIgnore
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @JsonIgnore
    @LastModifiedDate
    private Date updatedAt;
    //NOT FINISHED
}
