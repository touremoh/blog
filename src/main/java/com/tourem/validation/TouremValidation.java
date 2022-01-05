package com.tourem.validation;

import com.tourem.dao.entities.TouremEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Slf4j
@Service
public class TouremValidation<E extends TouremEntity> {

	private final Validator validator;

	public TouremValidation(Validator validator) {
		this.validator = validator;
	}

	public List<String> validate(E entity) {
		var results = validator
			.validate(entity)
			.stream()
			.map(e -> e.getPropertyPath().toString())
			.toList();

		if (!results.isEmpty()) {
			log.debug("An error occurred during validation process");
			return results;
		}
		return List.of();
	}
}
