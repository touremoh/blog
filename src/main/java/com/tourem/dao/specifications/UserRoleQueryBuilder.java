package com.tourem.dao.specifications;

import com.tourem.annotations.TouremSpecification;
import com.tourem.dao.entities.UserRoleEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

@TouremSpecification
public class UserRoleQueryBuilder implements TouremQueryBuilder<UserRoleEntity> {

	private static final String USER_ROLE = "name";

	@Override
	public Specification<UserRoleEntity> buildQuerySpecification(Map<String, String> params) {
		return Specification.where(containsExpression(USER_ROLE, params.get(USER_ROLE)));
	}
}
