package com.bastet.bastetmanagement.models;

import lombok.*;
import org.hibernate.annotations.Type;

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

    @Column(name = "meetingOwner")
    private long meetingOwner;

    @JoinColumn(name = "meetingPlatform")
    @ManyToOne
    private MeetingPlatform meetingPlatform;

    @Column(name = "meetingUrl")
    private long meetingUrl;

    @Column(name = "beginHour")
    private Date beginHour;

    @Column(name = "endHour")
    private Date endHour;

    @ManyToMany
    private List<Employee> attendants;

    //NOT FINISHED
}
