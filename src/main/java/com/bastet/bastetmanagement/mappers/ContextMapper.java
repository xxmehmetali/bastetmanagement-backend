package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ContextDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ContextSimplifiedDto;
import com.bastet.bastetmanagement.models.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ContextMapper {
    ContextDto contextToContextDto(Context context);
    Context contextDtoToContext(ContextDto contextDto);
    ContextSimplifiedDto contextToContextSimplifiedDto(Context context);
    Context contextSimplifiedDtoToContext(ContextSimplifiedDto contextSimplifiedDto);
    List<ContextDto> contextListToContextDtoList(List<Context> list);
    List<Context> contextDtoListToContextList(List<ContextDto> list);
    List<ContextSimplifiedDto> contextListToContextSimplifiedDtoList(List<Context> contexts);
    List<Context> contextSimplifiedDtoListToContextList(List<ContextSimplifiedDto> contexts);
}
