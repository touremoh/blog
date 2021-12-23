package com.tourem.mappers;

import com.tourem.dao.entities.UserRoleEntity;
import com.tourem.dto.UserRoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleMapper extends TouremObjectMapper<UserRoleEntity, UserRoleDto> {
}
