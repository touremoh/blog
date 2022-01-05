package com.tourem.service;

import com.tourem.dao.entities.UserOperationEntity;
import com.tourem.dao.repositories.TouremRepository;
import com.tourem.dao.specifications.TouremQueryBuilder;
import com.tourem.dto.UserOperationDto;
import com.tourem.mappers.TouremObjectMapper;
import com.tourem.validation.TouremValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserOperationService extends AbstractTouremService<UserOperationEntity, UserOperationDto> {
	protected UserOperationService(TouremRepository<UserOperationEntity> repository, TouremObjectMapper<UserOperationEntity, UserOperationDto> mapper, TouremQueryBuilder<UserOperationEntity> queryBuilder, TouremValidation<UserOperationEntity> validator) {
		super(repository, mapper, queryBuilder, validator);
	}
}
