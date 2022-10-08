package com.sojern.mathapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sojern.mathapi.annotation.ApiErrorResponses;
import com.sojern.mathapi.exception.NoResultException;
import com.sojern.mathapi.service.MathApiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Math Api Controller
 * 
 * @author kerim.sisman
 *
 */
@RestController
@RequestMapping
public class MathController {

	@Autowired
	MathApiService mathApiService;

	/**
	 * Return Min number list
	 * 
	 * @param numberList
	 * @param quantifier
	 * @return
	 * @throws IllegalArgumentException
	 * @throws NoResultException
	 */
	@Operation(summary = "Get the min list", description = "Calculate min number set by given list and quantifier.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Return the number(s) less than given quantifier in order asc. Null values are not not considered.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Long.class))) }) })
	@ApiErrorResponses
	@PostMapping("/min")
	public ResponseEntity<List<Long>> getMin(@RequestBody(required = true) List<Long> numberList,
			@RequestParam(required = true) Long quantifier) throws IllegalArgumentException, NoResultException {

		// Get desired part
		List<Long> result = mathApiService.min(numberList, quantifier);

		// Check content size
		if (result.size() == 0) {
			throw new NoResultException("Result not found!");
		}
		// Return success result
		return ResponseEntity.ok(result);
	}

	/**
	 * Return Max numbers
	 * 
	 * @param numberList
	 * @param quantifier
	 * @return
	 * @throws IllegalArgumentException
	 * @throws NoResultException
	 */
	@Operation(summary = "Get the max list", description = "Calculate max number set by given list and quantifier.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Return the number(s) greater than given quantifier in order asc. Null values are not not considered.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Long.class))) }) })
	@ApiErrorResponses
	@PostMapping("/max")
	public ResponseEntity<List<Long>> getMax(@RequestBody(required = true) List<Long> numberList,
			@RequestParam(required = true) Long quantifier) throws IllegalArgumentException, NoResultException {

		// Get desired part
		List<Long> result = mathApiService.max(numberList, quantifier);

		// Check content size
		if (result.size() == 0) {
			throw new NoResultException("Result not found!");
		}
		// Return success result
		return ResponseEntity.ok(result);
	}

	/**
	 * Calculate average
	 * 
	 * @param numberList
	 * @return
	 * @throws IllegalArgumentException
	 * @throws NoResultException
	 */
	@Operation(summary = "Get the average of list", description = "Calculate the average.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Calculate the average. Null values are not not considered.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Double.class)) }) })
	@ApiErrorResponses
	@PostMapping("/average")
	public ResponseEntity<Double> getAverage(@RequestBody(required = true) List<Long> numberList)
			throws IllegalArgumentException, NoResultException {

		// Calculate average
		Double result = mathApiService.avg(numberList);

		// Check content size
		if (result == null) {
			throw new NoResultException("Result not found!");
		}
		// Return success result
		return ResponseEntity.ok(result);
	}

	/**
	 * Calculate median
	 * 
	 * @param numberList
	 * @return
	 * @throws IllegalArgumentException
	 * @throws NoResultException
	 */
	@Operation(summary = "Get median of list", description = "Calculate median.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Calculate median. Null values are not not considered.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Double.class)) }) })
	@ApiErrorResponses
	@PostMapping("/median")
	public ResponseEntity<Double> getMedian(@RequestBody(required = true) List<Long> numberList)
			throws IllegalArgumentException, NoResultException {

		// Calculate average
		Double result = mathApiService.median(numberList);

		// Check content size
		if (result == null) {
			throw new NoResultException("Result not found!");
		}
		// Return success result
		return ResponseEntity.ok(result);
	}

	/**
	 * Calculate median
	 * 
	 * @param numberList
	 * @return
	 * @throws IllegalArgumentException
	 * @throws NoResultException
	 */
	@Operation(summary = "Get percentile for list", description = "Calculate percentile.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Calculate percentile. Null values are not not considered.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Long.class)) }) })
	@ApiErrorResponses
	@PostMapping("/percentile")
	public ResponseEntity<Long> getPercentile(@RequestBody(required = true) List<Long> numberList,
			@RequestParam(required = true) Integer qthPercentile) throws IllegalArgumentException, NoResultException {

		// Calculate average
		Long result = mathApiService.percentile(numberList, qthPercentile);

		// Check content size
		if (result == null) {
			throw new NoResultException("Result not found!");
		}
		// Return success result
		return ResponseEntity.ok(result);
	}

}
