package com.tourem.mappers;

import com.tourem.dao.entities.ImageUrlEntity;
import com.tourem.dto.ImageUrlDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageUrlMapper extends TouremObjectMapper<ImageUrlEntity, ImageUrlDto> {
}
