package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.dtos.Dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseTypeDto extends Dto {
    private UUID id = UUID.randomUUID();

    private String name;

    private String description;

}
