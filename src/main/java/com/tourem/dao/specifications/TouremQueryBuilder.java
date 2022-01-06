package com.tourem.dao.specifications;

import com.tourem.dao.entities.TouremEntity;
import org.assertj.core.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public interface TouremQueryBuilder<E extends TouremEntity> extends Serializable {

	default String formatExpression(String expression) {
		return MessageFormat.format("%{}%", expression);
	}

	default Specification<E> containsExpression(String fieldName, String expression) {
		if (Strings.isNullOrEmpty(expression)) {
			return null;
		}
		return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(fieldName), formatExpression(expression)));
	}

	default Specification<E> containsExpressionUsingJoin(String fieldName, String innerFieldName, String expression) {
		if (Strings.isNullOrEmpty(expression)) {
			return null;
		}
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.join(fieldName).get(innerFieldName), formatExpression(expression));
	}

	default Specification<E> betweenDates(String fieldName, LocalDateTime from, LocalDateTime to) {
		if (Objects.nonNull(from) && Objects.nonNull(to)) {
			return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(fieldName), from, to);
		}
		if (Objects.nonNull(from)) {
			return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(fieldName), from);
		}
		if (Objects.nonNull(to)) {
			return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(fieldName), to);
		}
		return null;
	}

	default Specification<E> expressionEquals(String fieldName, String expression) {
		if (Objects.isNull(expression)) {
			return null;
		}
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(fieldName), expression);
	}

	Specification<E> buildQuerySpecification(Map<String, String> params);
}
