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

    @Column(name = "createdAt")
    @JsonIgnore
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @JsonIgnore
    @LastModifiedDate
    private Date updatedAt;

}
