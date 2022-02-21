package com.tourem.mappers;

import com.tourem.dao.entities.AuthorEntity;
import com.tourem.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper extends TouremObjectMapper<AuthorEntity, AuthorDto> {

	@Mapping(target = "password",ignore = true)
	AuthorDto mapToDto(AuthorEntity source);
}
