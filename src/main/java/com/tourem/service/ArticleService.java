package com.tourem.service;

import com.tourem.dao.entities.ArticleEntity;
import com.tourem.dao.repositories.ArticleRepository;
import com.tourem.dao.specifications.ArticleQueryBuilder;
import com.tourem.dto.ArticleDto;
import com.tourem.mappers.ArticleMapper;
import com.tourem.validation.TouremValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleService extends AbstractTouremService<ArticleEntity, ArticleDto> {
	protected ArticleService(ArticleRepository repository, ArticleMapper mapper, ArticleQueryBuilder queryBuilder, TouremValidation<ArticleEntity> validator) {
		super(repository, mapper, queryBuilder, validator);
	}


}
