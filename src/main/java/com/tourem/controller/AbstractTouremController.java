package com.tourem.controller;

import com.tourem.dto.TouremApiResponse;
import com.tourem.dto.TouremDto;
import com.tourem.service.TouremService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
public abstract class AbstractTouremController<D extends TouremDto> implements TouremController<D> {

	protected final TouremService<D> service;

	protected AbstractTouremController(TouremService<D> service) {
		this.service = service;
	}

	/**
	 * Find one element by its ID
	 * @param id ID of the element to be found
	 * @return returns the found element
	 */
	@Override
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TouremApiResponse<D>> findById(@PathVariable String id) {
		return ResponseEntity.ok(new TouremApiResponse<D>(this.service.find(id), HttpStatus.OK.value()));
	}

	/**
	 * Find one element using different criteria other than resource ID
	 * @param criteria request criteria to be found
	 * @return returns the found element
	 */
	@Override
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TouremApiResponse<D>> findOne(@RequestParam Map<String, String> criteria) {
		return ResponseEntity.ok(new TouremApiResponse<>(this.service.find(criteria), HttpStatus.OK.value()));
	}

	/**
	 * Create a new resource
	 * @param data resource information
	 * @return returns the new resource created
	 */
	@Override
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TouremApiResponse<D>> create(@RequestBody D data) {
		return ResponseEntity.ok(new TouremApiResponse<>(this.service.create(data), HttpStatus.CREATED.value()));
	}

	/**
	 * Update one part of an element
	 * @param data update data
	 * @return returns the newly updated resource
	 */
	@Override
	public ResponseEntity<TouremApiResponse<D>> patch(D data) {
		return null;
	}

	/**
	 * Replace the content of the element
	 *
	 * @param data update data
	 * @return returns the newly updated resource
	 */
	@Override
	public ResponseEntity<TouremApiResponse<D>> put(D data) {
		return null;
	}

	/**
	 * Delete a resource by its ID
	 *
	 * @param id ID of the resource to be deleted
	 */
	@Override
	public ResponseEntity<TouremApiResponse<Void>> delete(String id) {
		return null;
	}

	/**
	 * Find many elements by criteria
	 *
	 * @param criteria Criteria of the resources to be found
	 * @return returns one or many pages
	 */
	@Override
	public ResponseEntity<TouremApiResponse<Page<D>>> findAll(Map<String, String> criteria) {
		return null;
	}
}
