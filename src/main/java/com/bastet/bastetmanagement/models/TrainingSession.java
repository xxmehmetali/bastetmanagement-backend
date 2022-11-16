package com.bastet.bastetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TrainingSessions")
public class TrainingSession {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "beginHour")
    private Date beginHour;

    @Column(name = "endHour")
    private Date endHour;

    //NOT FINISHED

    @Column(name = "educator")
    private long educator;

    @Column(name = "attendants")
    private long attendants;

    @Column(name = "platform")
    private long platform;

}
