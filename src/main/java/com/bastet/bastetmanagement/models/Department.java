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

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Departments")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Department {
    @Id
    @Column(name = "id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    //YANLIŞ KONFİGURE EDİLMİŞ. KONTROL ET
    @JoinColumn(name = "departmentResponsible", referencedColumnName = "id")
    @OneToOne()
    @JsonManagedReference
    private Employee departmentResponsible;

    @OneToMany
    List<Employee> employees;

    @Column(name = "createdAt")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @LastModifiedDate
    private Date updatedAt;

    @PreRemove
    public void onDeleteSetNull() {
        departmentResponsible.setDepartment(null);
        employees.stream()
                .forEach(employee -> employee.setDepartment(null));
    }

}
