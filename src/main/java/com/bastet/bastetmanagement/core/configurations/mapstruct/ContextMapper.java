package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.ContextDto;
import com.bastet.bastetmanagement.models.Context;
import org.mapstruct.Mapper;

@Mapper
public interface ContextMapper {
    ContextDto contextToContextDto(Context context);
    Context contextDtoToContext(ContextDto contextDto);
}
