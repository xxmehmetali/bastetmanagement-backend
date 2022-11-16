package com.bastet.bastetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Dayoffs")
public class Dayoff {
    @Id
    @Column(name="id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();

    @Column(name = "begindate")
    private Date beginDate;

    @Column(name = "enddate")
    private Date endDate;

    @Column(name = "ispaid")
    private Boolean isPaid;

    @Column(name = "reason")
    private String reason;

    @Column(name = "employeeid")
    private long employeeId;

    //NOT FINISHED
}
