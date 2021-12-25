package com.tourem.service;

import com.tourem.dto.TouremDto;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.Map;

/**
 * Interface for CRUD operations
 * @param <D> DTO to be process
 * @author Mohamed Touré
 */
public interface TouremService<D extends TouremDto> extends Serializable {

	/**
	 * Find one element by its ID
	 * @param id ID of the element to be found
	 * @return returns the found element
	 */
	D findById(String id);

	/**
	 * Find one element using different criteria other than resource ID
	 * @param criteria request criteria to be found
	 * @return returns the found element
	 */
	D findOne(Map<String, String> criteria);

	/**
	 * Create a new resource
	 * @param data resource information
	 * @return returns the new resource created
	 */
	D create(D data);

	/**
	 * Update one part of an element
	 * @param data update data
	 * @return returns the newly updated resource
	 */
	D patch(D data);

	/**
	 * Replace the content of the element
	 * @param data update data
	 * @return returns the newly updated resource
	 */
	D put(D data);

	/**
	 * Delete a resource by its ID
	 * @param id ID of the resource to be deleted
	 */
	void delete(String id);

	/**
	 * Find many elements by criteria
	 * @param criteria Criteria of the resources to be found
	 * @return returns one or many pages
	 */
	Page<D> findAll(Map<String, String> criteria);
}
