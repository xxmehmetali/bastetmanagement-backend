package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.UserDto;
import com.bastet.bastetmanagement.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

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

    @Mappings({
            @Mapping(source = "employee", target = "employee", qualifiedByName = "employeeDtoToEmployeeOnlyId")
    })
    @Named("userToUserDtoForUpdate")
    User userToUserDtoForUpdate(UserDto userDto);

}
