package com.bastet.bastetmanagement.models;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "SocialActivityTypes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialActivityType {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "socialActivityType")
    @JsonIgnore
    private List<SocialActivity> socialActivities;

    @Column(name = "createdAt")
    @JsonIgnore
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @JsonIgnore
    @LastModifiedDate
    private Date updatedAt;
}
