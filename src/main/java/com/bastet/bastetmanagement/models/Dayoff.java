package com.bastet.bastetmanagement.models;

import com.bastet.bastetmanagement.core.enums.DayOffReason;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Dayoffs")
@EntityListeners(AuditingEntityListener.class)
public class Dayoff {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "beginDate")
    private Date beginDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "ispaid")
    private Boolean isPaid;

    @Column(name = "reason")
    @Enumerated(EnumType.STRING)
    private DayOffReason reason;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

    @Column(name = "createdAt")
    @JsonIgnore
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @JsonIgnore
    @LastModifiedDate
    private Date updatedAt;
    //NOT FINISHED
}
