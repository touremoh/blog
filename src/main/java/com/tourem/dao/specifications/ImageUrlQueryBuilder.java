package com.tourem.dao.specifications;

import com.tourem.annotations.TouremSpecification;
import com.tourem.dao.entities.ImageUrlEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

@TouremSpecification
public class ImageUrlQueryBuilder implements TouremQueryBuilder<ImageUrlEntity> {
	private static final String URL = "url";
	@Override
	public Specification<ImageUrlEntity> buildQuerySpecification(Map<String, String> params) {
		return Specification.where(containsExpression(URL, params.get(URL)));
	}
}
