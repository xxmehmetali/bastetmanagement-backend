package com.bastet.bastetmanagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Contexts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Context {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "name", length = 512)
    private String name;

    @Column(name = "description", length = 1024)
    private String description;

    //NOT FINISHED "FK IMPL"
    @ManyToOne
    @JoinColumn(name = "project")
    @JsonBackReference
    private Project project;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "context")
    @JsonBackReference
    private List<Task> tasks;

    @Column(name = "createdAt")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @LastModifiedDate
    private Date updatedAt;
}
