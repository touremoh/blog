package com.tourem.service;

import com.tourem.dao.entities.ImageUrlEntity;
import com.tourem.dao.repositories.TouremRepository;
import com.tourem.dao.specifications.TouremQueryBuilder;
import com.tourem.dto.ImageUrlDto;
import com.tourem.mappers.TouremObjectMapper;
import com.tourem.validation.TouremValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ImageUrlService extends AbstractTouremService<ImageUrlEntity, ImageUrlDto> {
	protected ImageUrlService(TouremRepository<ImageUrlEntity> repository, TouremObjectMapper<ImageUrlEntity, ImageUrlDto> mapper, TouremQueryBuilder<ImageUrlEntity> queryBuilder, TouremValidation<ImageUrlEntity> validator) {
		super(repository, mapper, queryBuilder, validator);
	}
}
