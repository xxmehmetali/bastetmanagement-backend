package com.bastet.bastetmanagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Projects")
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Project {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "corporation")
    @JsonBackReference
    private Corporation corporation;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Context> contexts;

    @Column(name = "createdAt")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @LastModifiedDate
    private Date updatedAt;

    @Override
    public String toString() {
        return "Project{" +
                "uuid=" + id +
                ", name='" + name + '\'' +
                ", corporation=" + corporation +
                '}';
    }
//NOT FINISHED
}
