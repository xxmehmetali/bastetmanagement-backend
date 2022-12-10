package com.bastet.bastetmanagement.dtos.basedtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
    private UUID id;

    private String  cvFile;

    private String CvKeywords;

}
