package com.bastet.bastetmanagement.models;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Occupations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Occupation {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "detail")
    private String detail;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "occupation")
    private List<Employee> employees;

}
