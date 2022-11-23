package com.bastet.bastetmanagement.models;

import com.bastet.bastetmanagement.core.enums.Priorities;
import com.bastet.bastetmanagement.core.enums.TaskStatuses;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tasks")
public class Task{
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "tags")
    private String tags;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    //KEY RELATIONS
    @Column(name = "taskStatus")
    @Enumerated(EnumType.STRING)
    private TaskStatuses taskStatus;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priorities priority;

    @JoinColumn(name = "assignedFrom")
    @OneToOne
    private Employee assignedFrom;

    @JoinColumn(name = "assignedTo")
    @OneToOne
    private Employee assignedTo;

    @JoinColumn(name = "reviewer")
    @OneToOne
    private Employee reviewer;

    @JoinColumn(name = "context")
    @ManyToOne
    private Context context;
}
