package com.tourem.service;

import com.tourem.dao.entities.TouremEntity;
import com.tourem.dao.repositories.TouremRepository;
import com.tourem.dao.specifications.TouremQueryBuilder;
import com.tourem.dto.TouremDto;
import com.tourem.exceptions.ResourceNotFoundException;
import com.tourem.mappers.TouremObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;

import java.util.Map;
import java.util.Objects;

@Slf4j
public abstract class AbstractTouremService<E extends TouremEntity, D extends TouremDto> implements TouremService<D> {

	protected final TouremRepository<E> repository;
	protected final TouremObjectMapper<E, D> mapper;
	protected final TouremQueryBuilder<E> queryBuilder;

	protected AbstractTouremService(TouremRepository<E> repository, TouremObjectMapper<E, D> mapper, TouremQueryBuilder<E> queryBuilder) {
		this.repository = repository;
		this.mapper = mapper;
		this.queryBuilder = queryBuilder;
	}

	/**
	 * Find one element by its ID
	 * @param id ID of the element to be found
	 * @return returns the found element
	 */
	@Override
	public D find(String id) {
		return this.repository
				   .findById(id)
				   .map(mapper::mapToDto)
				   .orElseThrow(() -> new ResourceNotFoundException(String.format("Resource with ID [%s] not found", id)));
	}

	/**
	 * Find one element using different criteria other than resource ID
	 * @param criteria request criteria to be found
	 * @return returns the found element
	 */
	@Override
	public D find(Map<String, String> criteria) {
		return this.repository
				   .findOne(this.queryBuilder.buildQuerySpecification(criteria))
				   .map(mapper::mapToDto)
				   .orElseThrow(() -> new ResourceNotFoundException(String.format("Resource with criteria [%s] not found", criteria)));
	}

	/**
	 * Create a new resource
	 * @param data resource information
	 * @return returns the new resource created
	 */
	@Override
	public D create(D data) {
		// map to entity
		E e = mapper.mapToEntity(data);

		// validate
		applyPrePersistValidation(e);

		// pre persist
		processBeforeCreate(e);

		// save
		E res = this.repository.save(e);

		// post persist
		processAfterCreate(res);

		// map and return results
		return mapper.mapToDto(res);
	}

	protected void applyPrePersistValidation(E entity) {
		log.info("Pre persist validation of [{}]", entity);

		if (entity.hasId()) {
			log.debug("Field id not allowed for create operation for object: [{}]", entity);
			throw new IllegalArgumentException(String.format("Field id not allowed for create operation for object: [%s]", entity));
		}

		if (Objects.nonNull(entity.getCreatedAt())) {
			log.debug("Field createdAt not allowed for create operation for object: [{}]", entity);
			throw new IllegalArgumentException(String.format("Field createdAt not allowed for create operation for object: [%s]", entity));
		}

		if (Objects.nonNull(entity.getUpdatedAt())) {
			log.debug("Field updatedAt not allowed for create operation for entity [{}]", entity);
			throw new IllegalArgumentException(String.format("Field updatedAt not allowed for create operation for entity [%s]", entity));
		}

		if (Objects.nonNull(entity.getDeletedAt())) {
			log.debug("Field deletedAt not allowed for create operation for entity [{}]", entity);
			throw new IllegalArgumentException(String.format("Field deletedAt not allowed for create operation for entity [%s]", entity));
		}
	}

	protected void processBeforeCreate(E entity) {
		log.info("Pre processing entity before create: [{}]", entity);
	}

	protected void processAfterCreate(E entity) {
		log.info("Pre processing entity after create: [{}]", entity);
	}

	/**
	 * Update one part of an element
	 *
	 * @param data update data
	 * @return returns the newly updated resource
	 */
	@Override
	public D patch(D data) {
		// map to entity
		E e = this.mapper.mapToEntity(data);

		// initial validation
		applyInitialCheckBeforePatch(e);

		// process before update
		processBeforePatch(e);

		// save
		E res = this.repository.save(e);

		// process after update
		processAfterPatch(res);

		// map to dto and returns
		return this.mapper.mapToDto(res);
	}

	public void applyInitialCheckBeforePatch(E entity) {
		log.info("Validation of [{}]", entity);

		if (!entity.hasId()) {
			log.debug("The ID of the object to update is missing - [{}]", entity);
			throw new IllegalArgumentException(String.format("The ID is mandatory for update operation: [%s]", entity));
		}

		if (!this.repository.existsById(entity.getId())) {
			log.debug("Trying to update a row with an invalid ID : [{}]", entity);
			throw new IllegalArgumentException(String.format("The ID of the row to update is not valid [%s]", entity));
		}

		if (Objects.nonNull(entity.getDeletedAt())) {
			log.info("Using deleteAt field on update operation [{}]", entity);
			throw new IllegalArgumentException(String.format("Field deletedAt not allowed for update operation for entity [%s]", entity));
		}
	}

	protected void processBeforePatch(E entity) {
		log.info("Pre processing entity before patch: [{}]", entity);
	}

	protected void processAfterPatch(E entity) {
		log.info("Pre processing entity after patch: [{}]", entity);
	}

	/**
	 * Replace the content of the element
	 *
	 * @param data update data
	 * @return returns the newly updated resource
	 */
	@Override
	public D put(D data) {
		return null;
	}

	/**
	 * Delete a resource by its ID
	 *
	 * @param id ID of the resource to be deleted
	 */
	@Override
	public void delete(String id) {

	}

	/**
	 * Find many elements by criteria
	 *
	 * @param criteria Criteria of the resources to be found
	 * @return returns one or many pages
	 */
	@Override
	public Page<D> findAll(Map<String, String> criteria) {
		return null;
	}
}
