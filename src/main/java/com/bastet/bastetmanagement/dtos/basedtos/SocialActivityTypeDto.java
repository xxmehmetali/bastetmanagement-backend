package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.models.SocialActivity;
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
public class SocialActivityTypeDto {
    private UUID id;

    private String name;

    private String description;

//    private List<SocialActivityDto> socialActivities;

}
