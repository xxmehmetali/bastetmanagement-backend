package com.bastet.bastetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Meetings")
public class Meeting {
    @Id
    @Column(name="id")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "meetingOwner")
    private long meetingOwner;

    @Column(name = "attendants")
    private long attendants;

    @Column(name = "meetingPlatform")
    private long meetingPlatform;

    @Column(name = "meetingUrl")
    private long meetingUrl;

    @Column(name = "beginHour")
    private Date beginHour;

    @Column(name = "endHour")
    private Date endHour;

    //NOT FINISHED
}
