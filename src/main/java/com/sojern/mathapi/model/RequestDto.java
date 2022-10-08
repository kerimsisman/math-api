package com.sojern.mathapi.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Request body for calculation, contains number list and quantifier")
public class RequestDto {
	@Schema(description = "Number list for calculation", required = true)
	private List<Long> list;
	@Schema(description = "Quantifier value fo calculation (not required for all services)", required = false)
	private Integer quantifier;
}
