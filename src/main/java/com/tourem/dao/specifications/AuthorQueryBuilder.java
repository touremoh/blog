package com.tourem.dao.specifications;

import com.tourem.annotations.TouremSpecification;
import com.tourem.dao.entities.AuthorEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

@TouremSpecification
public class AuthorQueryBuilder implements TouremQueryBuilder<AuthorEntity>  {

	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";

	@Override
	public Specification<AuthorEntity> buildQuerySpecification(Map<String, String> params) {
		return Specification
			.where(containsExpression(FIRST_NAME, params.get(FIRST_NAME)))
			.and(containsExpression(LAST_NAME, params.get(LAST_NAME)))
			.and(expressionEquals(LOGIN, params.get(LOGIN)))
			.and(expressionEquals(PASSWORD, params.get(PASSWORD)));
	}
}
