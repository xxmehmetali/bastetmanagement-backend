package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.dtos.Dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.mapstruct.Mapping;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorporationDto extends Dto {
    private UUID id;

    private String name;

    private String description;

    private String taxNumber;

    private Date foundationDate;

    private Date createdAt;

    private Date updatedAt;



    /*
    * corporationdto dan projects i kaldır
    * private List<ProjectDto> projects;
    * frontta corporationdetail kısmında projectleri göstermemiz lazım o yüzdfen backendde sadece
    * corporaiton id ile o id ye ait project leri döndüren bir api yaz
    *
    * sonra frontta corp detail da bı yazdığın apiye istek atıp o projectleri göster
    *
    * ama bublar hep dto formunda olacak
    * */
}
