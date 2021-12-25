package com.tourem.service;

import com.tourem.dao.entities.AuthorEntity;
import com.tourem.dao.repositories.AuthorRepository;
import com.tourem.dao.specifications.AuthorQueryBuilder;
import com.tourem.dto.AuthorDto;
import com.tourem.mappers.AuthorMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends AbstractTouremService<AuthorEntity, AuthorDto> {
	protected AuthorService(AuthorRepository repository, AuthorMapper mapper, AuthorQueryBuilder queryBuilder) {
		super(repository, mapper, queryBuilder);
	}
}
