package com.bastet.bastetmanagement.dtos.simplifieddtos;

import com.bastet.bastetmanagement.dtos.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CvSimplifiedDto extends Dto {
    private UUID id;

    private String  cvFile;

    private String CvKeywords;

}
