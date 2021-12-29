package com.tourem.controller;

import com.tourem.dto.TouremApiResponse;
import com.tourem.dto.TouremDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface TouremController<D extends TouremDto> {
	/**
	 * Find one element by its ID
	 * @param id ID of the element to be found
	 * @return returns the found element
	 */
	ResponseEntity<TouremApiResponse<D>> find(String id);

	/**
	 * Find one element using different criteria other than resource ID
	 * @param criteria request criteria to be found
	 * @return returns the found element
	 */
	ResponseEntity<TouremApiResponse<D>> find(Map<String, String> criteria);

	/**
	 * Create a new resource
	 * @param data resource information
	 * @return returns the new resource created
	 */
	ResponseEntity<TouremApiResponse<D>> create(D data);

	/**
	 * Update one part of an element
	 * @param data update data
	 * @return returns the newly updated resource
	 */
	ResponseEntity<TouremApiResponse<D>> patch(D data);

	/**
	 * Replace the content of the element
	 * @param data update data
	 * @return returns the newly updated resource
	 */
	ResponseEntity<TouremApiResponse<D>> put(D data);

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
	ResponseEntity<TouremApiResponse<Page<D>>> findAll(Map<String, String> criteria);
}
