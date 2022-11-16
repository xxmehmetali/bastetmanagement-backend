package com.bastet.bastetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @Column(name="id")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "occupation")
    private String occupation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "corporation")
    private Corporation corporation;

    //NOT FINISHED
}
