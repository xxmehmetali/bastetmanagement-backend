package com.bastet.bastetmanagement.dtos.simplifieddtos;

import com.bastet.bastetmanagement.dtos.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialActivitySimplifiedDto extends Dto {
    private UUID id;

    private String name;

    private String description;

    private Date date;

    private String place;

}
