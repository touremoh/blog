package com.tourem.dao.specifications;

import com.tourem.annotations.TouremSpecification;
import com.tourem.dao.entities.UserOperationEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

@TouremSpecification
public class UserOperationQueryBuilder implements TouremQueryBuilder<UserOperationEntity>  {

	private static final String OPERATION_NAME = "operationName";
	private static final String USER_ROLE = "userRole";
	private static final String USER_ROLE_NAME = "name";

	@Override
	public Specification<UserOperationEntity> buildQuerySpecification(Map<String, String> params) {
		return Specification
				.where(containsExpression(OPERATION_NAME, params.get(OPERATION_NAME)))
				.and(containsExpressionUsingJoin(USER_ROLE, USER_ROLE_NAME, params.get(USER_ROLE_NAME)));
	}
}
