package com.tourem.mappers;

import com.tourem.dao.entities.UserOperationEntity;
import com.tourem.dto.UserOperationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserRoleMapper.class)
public interface UserOperationMapper extends TouremObjectMapper<UserOperationEntity, UserOperationDto> {
}
