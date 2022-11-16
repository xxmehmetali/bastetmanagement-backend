package com.bastet.bastetmanagement.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Corporations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Corporation {
    @Id
    @Column(name="id")
    private UUID uuid = UUID.randomUUID();

    private String name;
    private String description;
    private String taxNumber;
    private String foundationDate;

    @OneToMany(mappedBy = "corporation", fetch = FetchType.LAZY)
    private Set<Project> projects;


}
