package com.tourem.mappers;

import com.tourem.dao.entities.AuthorEntity;
import com.tourem.dto.AuthorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper extends TouremObjectMapper<AuthorEntity, AuthorDto>{
}
