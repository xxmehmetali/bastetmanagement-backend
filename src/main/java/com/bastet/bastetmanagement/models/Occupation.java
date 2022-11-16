package com.bastet.bastetmanagement.models;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="Occupations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Occupation {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "detail")
    private String detail;

}
