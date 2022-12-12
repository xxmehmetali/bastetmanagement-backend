package com.bastet.bastetmanagement.dtos.simplifieddtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorporationSimplifiedDto {
    private UUID id;

    private String name;

    private String description;

    private String taxNumber;

    private String foundationDate;

}
