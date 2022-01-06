package com.tourem.validation;

import com.tourem.dao.entities.TouremEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@Slf4j
@Service
public class TouremValidation<E extends TouremEntity> {

	private final Validator validator;

	public TouremValidation(Validator validator) {
		this.validator = validator;
	}

	public String validate(E entity) {
		var results = validator
			.validate(entity)
			.stream()
			.map(ConstraintViolation::getMessage)
			.reduce("", (acc, e) -> acc.concat(e).concat(", "));

		if (!results.isEmpty()) {
			log.debug("An error occurred during validation process");
			return results;
		}
		return Strings.EMPTY;
	}
}
