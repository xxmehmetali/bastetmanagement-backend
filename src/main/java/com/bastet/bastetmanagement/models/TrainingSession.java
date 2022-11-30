package com.bastet.bastetmanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "TrainingSessions")
public class TrainingSession {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "beginHour")
    private Date beginHour;

    @Column(name = "endHour")
    private Date endHour;

    //NOT FINISHED
//kaç educator olacak?
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee educator;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Employee> attendants;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platform")
    private MeetingPlatform platform;

    @Column(name = "createdAt")
    @JsonIgnore
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @JsonIgnore
    @LastModifiedDate
    private Date updatedAt;

}
