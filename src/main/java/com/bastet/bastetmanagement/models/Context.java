package com.bastet.bastetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Context {
    @Id
    @Column(name="id")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    //NOT FINISHED "FK IMPL"
    @Column(name = "project")
    private String project;

}
