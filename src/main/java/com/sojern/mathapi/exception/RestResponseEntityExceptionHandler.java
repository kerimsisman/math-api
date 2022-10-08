package com.sojern.mathapi.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handle Bag request exceptions (400)
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected @ResponseBody ErrorResponse handleBadRequest(RuntimeException ex, WebRequest request) {
		log.error("handleBadRequest", ex);
		return new ErrorResponse(getMessage(ex, "Missing reqired parameters or wrong parameters!"), getUri(request));
	}

	/**
	 * Handle No Content exceptions (204)
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */

	@ExceptionHandler(value = NoResultException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	protected @ResponseBody ErrorResponse handleElementNotFound(NoResultException ex, WebRequest request) {
		log.error("handleElementNotFound", ex);
		return new ErrorResponse(getMessage(ex, "Result not found!"), getUri(request));
	}

	/**
	 * Handle other exceptions (500)
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected @ResponseBody ErrorResponse handleOthers(Exception ex, WebRequest request) {
		log.error("handleOthers", ex);
		return new ErrorResponse(getMessage(ex, "Something went wrong:("), getUri(request));
	}

	/**
	 * Get request
	 * 
	 * @param request
	 * @return
	 */
	private String getUri(WebRequest request) {
		return ((ServletWebRequest) request).getRequest().getRequestURI().toString();
	}

	/**
	 * Get error message from exception
	 * 
	 * @param ex
	 * @param defaultMessage
	 * @return
	 */
	private String getMessage(Exception ex, String defaultMessage) {
		if (ex != null && StringUtils.isNoneBlank(ex.getMessage())) {
			return ex.getMessage();
		} else {
			return defaultMessage;
		}
	}

}
