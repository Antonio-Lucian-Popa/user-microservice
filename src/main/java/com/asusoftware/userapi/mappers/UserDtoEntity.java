package com.asusoftware.userapi.mappers;

import com.asusoftware.userapi.model.CreateUserDto;
import com.asusoftware.userapi.model.User;
import com.asusoftware.userapi.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserDtoEntity {

    UserDto userToDto(User user);

    User userToEntity(CreateUserDto createUserDto);

    User userToEntity(UserDto userDto);
}
