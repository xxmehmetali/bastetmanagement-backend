package com.bastet.bastetmanagement.models;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="Priorities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Priority {
    @Id
    @Column(name="id")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "code")
    private String code;

}
