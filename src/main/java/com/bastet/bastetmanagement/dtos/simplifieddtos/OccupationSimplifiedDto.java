package com.bastet.bastetmanagement.dtos.simplifieddtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OccupationSimplifiedDto {
    private UUID id;

    private String occupation;

    private String detail;


}
