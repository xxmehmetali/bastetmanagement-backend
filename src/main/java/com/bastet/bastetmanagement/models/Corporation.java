package com.bastet.bastetmanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Corporations")
//@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","projects"})
@Getter
@Setter
public class Corporation {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    private String name;
    private String description;
    private String taxNumber;
    private String foundationDate;

    @JsonIgnore
    @OneToMany(mappedBy = "corporation", fetch = FetchType.LAZY)
    private List<Project> projects;

    @OneToMany(mappedBy = "corporation")
    List<Branch> branches;

    @Column(name = "createdAt")
    @JsonIgnore
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @JsonIgnore
    @LastModifiedDate
    private Date updatedAt;

    @Override
    public String toString() {
        return "Corporation{" +
                "uuid=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", foundationDate='" + foundationDate + '\'' +
                '}';
    }
}
