package com.tourem.mappers;

import com.tourem.dao.entities.ArticleEntity;
import com.tourem.dto.ArticleDto;
import org.mapstruct.Mapper;


@Mapper(
        componentModel = "spring",
        uses = {
                AuthorMapper.class
        }
)
public interface ArticleMapper extends TouremObjectMapper<ArticleEntity, ArticleDto> {
}
