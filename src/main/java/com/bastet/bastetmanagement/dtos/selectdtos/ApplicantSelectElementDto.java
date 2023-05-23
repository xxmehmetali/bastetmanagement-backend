package com.bastet.bastetmanagement.dtos.selectdtos;

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
public class ApplicantSelectElementDto extends Dto {
    private UUID id;

    private String applicantFullName;
}
