package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.CorporationDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CorporationSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                ProjectMapper.class
        }
)
public interface CorporationMapper {
    CorporationDto corporationToCorporationDto(Corporation corporation);

    //burda mapping ignore olursa dışarıdan gelen update edilmesi gereken corporationların id si modele setlenmeyecek
    //diğer yandan ignore olmazsa ve yeni bir corporation oluşacak olursa id null gelecektir ve modele null setlenecektir.
    //buna bir çözüm bulmak lazım, 2 durum corporationdto üstünde çözülürse ekstra iş yükünden kurtuluruz.
    @Mapping(ignore = true, target = "id")
    Corporation corporationDtoToCorporation(CorporationDto corporationDto);

    @Named("corporationDtoToCorporationIdStatic")
    Corporation corporationDtoToCorporationIdStatic(CorporationDto corporationDto);

    CorporationSimplifiedDto corporationToCorporationSimplifiedDto(Corporation corporation);
    Corporation corporationSimplifiedDtoToCorporation(CorporationSimplifiedDto corporationSimplifiedDto);
    //list versions
    List<Corporation> corporationDtoListToCorporationList(List<CorporationDto> corporationDtos);
    List<CorporationDto> corporationListToCorporationDtoList(List<Corporation> corporations);

    CorporationSelectElementDto corporationToCorporationSelectElementDto(Corporation corporation);

    List<CorporationSelectElementDto> corporationListToCorporationSelectElementDtoList(List<Corporation> corporations);

}
