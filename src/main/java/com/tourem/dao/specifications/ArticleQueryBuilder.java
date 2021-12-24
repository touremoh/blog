package com.tourem.dao.specifications;

import com.tourem.annotations.TouremSpecification;
import com.tourem.dao.entities.ArticleEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.Map;

@TouremSpecification
public class ArticleQueryBuilder implements TouremQueryBuilder<ArticleEntity> {

	private static final String TITLE = "title";
	private static final String PAYLOAD = "payload";
	private static final String AUTHOR = "author";
	private static final String AUTHOR_NAME = "authorName";
	private static final String CREATED_AT = "createdAt";
	private static final String UPDATED_AT = "updatedAt";
	private static final String CREATED_FROM = "createdFrom";
	private static final String CREATED_TO = "createdTo";
	private static final String UPDATED_FROM = "updatedFrom";
	private static final String UPDATED_TO = "updatedTo";

	@Override
	public Specification<ArticleEntity> buildQuerySpecification(Map<String, String> params) {
		var createdFrom =  LocalDateTime.parse(params.get(CREATED_FROM));
		var createdTo =  LocalDateTime.parse(params.get(CREATED_TO));
		var updatedFrom = LocalDateTime.parse(params.get(UPDATED_FROM));
		var updatedTo = LocalDateTime.parse(params.get(UPDATED_TO));

		return Specification
				.where(containsExpression(TITLE, params.get(TITLE)))
				.and(containsExpressionUsingJoin(AUTHOR, AUTHOR_NAME, params.get(AUTHOR_NAME)))
				.and(containsExpression(PAYLOAD, params.get(PAYLOAD)))
				.and(betweenDates(CREATED_AT, createdFrom, createdTo))
				.and(betweenDates(UPDATED_AT, updatedFrom, updatedTo));

	}
}
