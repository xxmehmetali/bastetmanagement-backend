package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ContextDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ContextSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ContextSimplifiedDto;
import com.bastet.bastetmanagement.models.Context;
import com.bastet.bastetmanagement.models.Corporation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface ContextMapper {
    ContextDto contextToContextDto(Context context);

    @Mapping(ignore = true, target = "id")
//    @Mapping(source = "project", target = "project", qualifiedByName = "projectDtoToProjectIdStatic")
    Context contextDtoToContext(ContextDto contextDto);

    @Named("contextDtoToContextIdStatic")
    Context contextDtoToContextIdStatic(ContextDto contextDto);

    ContextSimplifiedDto contextToContextSimplifiedDto(Context context);
    Context contextSimplifiedDtoToContext(ContextSimplifiedDto contextSimplifiedDto);
    List<ContextDto> contextListToContextDtoList(List<Context> list);
    List<Context> contextDtoListToContextList(List<ContextDto> list);
    List<ContextSimplifiedDto> contextListToContextSimplifiedDtoList(List<Context> contexts);
    List<Context> contextSimplifiedDtoListToContextList(List<ContextSimplifiedDto> contexts);
    List<ContextSelectElementDto> contextListToContextSelectElementDtoList(List<Context> contexts);

    @Named("contextDtoToContextOnlyId")
    default Context contextDtoToContextOnlyId(ContextDto contextDto){
        Context context = new Context();
        context.setId( contextDto.getId() );
        return context;
    }
}
