package com.sojern.mathapi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * General annotation for service error to make openAPI keep DRY
 * 
 * @author kerim.sisman
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ApiResponses(value = {
		@ApiResponse(responseCode = "400", description = "Missing data for calculation or wrong data.", content = @Content()),
		@ApiResponse(responseCode = "204", description = "Calculation has no data to return. It is an empty list", content = @Content()) })
public @interface ApiErrorResponses {

}
