package com.tourem.service;

import com.tourem.dao.entities.UserRoleEntity;
import com.tourem.dao.repositories.TouremRepository;
import com.tourem.dao.specifications.TouremQueryBuilder;
import com.tourem.dto.UserRoleDto;
import com.tourem.mappers.TouremObjectMapper;
import com.tourem.validation.TouremValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserRoleService extends AbstractTouremService<UserRoleEntity, UserRoleDto> {
	protected UserRoleService(TouremRepository<UserRoleEntity> repository, TouremObjectMapper<UserRoleEntity, UserRoleDto> mapper, TouremQueryBuilder<UserRoleEntity> queryBuilder, TouremValidation<UserRoleEntity> validator) {
		super(repository, mapper, queryBuilder, validator);
	}
}
