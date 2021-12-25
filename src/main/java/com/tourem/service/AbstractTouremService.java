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
	public D findById(String id) {
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
	public D findOne(Map<String, String> criteria) {
		return null;
	}

	/**
	 * Create a new resource
	 *
	 * @param data resource information
	 * @return returns the new resource created
	 */
	@Override
	public D create(D data) {
		return null;
	}

	/**
	 * Update one part of an element
	 *
	 * @param data update data
	 * @return returns the newly updated resource
	 */
	@Override
	public D patch(D data) {
		return null;
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
