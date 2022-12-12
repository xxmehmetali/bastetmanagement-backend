package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.models.Corporation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private UUID id;

    private String name;

    private List<ContextDto> contexts;

    private Corporation corporation;

    private Date createdAt;

    private Date updatedAt;

}
