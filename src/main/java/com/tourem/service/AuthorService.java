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

		var author = AuthorEntity
			.builder()
			.login(entity.getLogin())
			.password(entity.getPassword())
			.build();

		if (this.repository.exists(Example.of(author))) {
			log.debug("Author already exists [{}]", author);
			throw new IllegalArgumentException(String.format("Author already exists [%s]", entity));
		}
	}
}
