package com.bastet.bastetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private UUID uuid = UUID.randomUUID();

    @Column(name = "beginDate")
    private Date beginDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "isPaid")
    private Boolean isPaid;

    @Column(name = "reason")
    private String reason;

    @Column(name = "employeeId")
    private long employeeId;

    //NOT FINISHED
}
