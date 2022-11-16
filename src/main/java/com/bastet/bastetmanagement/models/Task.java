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
        private int taskStatus;
        @Column(name = "priority")
        private int priority;
        @Column(name = "assignedFrom")
        private int assignedFrom;
        @Column(name = "assignedTo")
        private int assignedTo;
        @Column(name = "reviewer")
        private int reviewer;
        @Column(name = "context")
        private int context;
    }
