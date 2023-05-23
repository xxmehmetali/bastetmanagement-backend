package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.UserDto;
import com.bastet.bastetmanagement.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(
        componentModel = "spring",
        uses = {
            EmployeeMapper.class
        }
)
public interface UserMapper {

    @Mappings({
            @Mapping(source = "employee", target = "employee", qualifiedByName = "employeeToEmployeeDto")
    })
    UserDto userToUserDto(User user);

}
