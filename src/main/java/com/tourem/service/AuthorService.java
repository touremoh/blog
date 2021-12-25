package com.tourem.service;

import com.tourem.dao.entities.AuthorEntity;
import com.tourem.dao.repositories.AuthorRepository;
import com.tourem.dao.specifications.AuthorQueryBuilder;
import com.tourem.dto.AuthorDto;
import com.tourem.mappers.AuthorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthorService extends AbstractTouremService<AuthorEntity, AuthorDto> {
	protected AuthorService(AuthorRepository repository, AuthorMapper mapper, AuthorQueryBuilder queryBuilder) {
		super(repository, mapper, queryBuilder);
	}

	@Override
	protected void processBeforeCreate(AuthorEntity entity) {
		super.processBeforeCreate(entity);
		if (this.repository.exists(Example.of(AuthorEntity.builder().login(entity.getLogin()).build()))) {
			log.debug("User login exists [{}]", entity);
			throw new IllegalArgumentException(String.format("User login already exists [%s]", entity));
		}

		if (this.repository.exists(Example.of(AuthorEntity.builder().password(entity.getPassword()).build()))) {
			log.debug("User password exists [{}]", entity);
			throw new IllegalArgumentException(String.format("User password already exists [%s]", entity));
		}
	}
}
