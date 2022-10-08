package com.sojern.mathapi.exception;

import org.springframework.stereotype.Component;

/**
 * No result found exception
 * 
 * @author kerim.sisman
 *
 */
@Component
public class NoResultException extends RuntimeException  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoResultException() {
		super();
	}

	public NoResultException(final String s) {
		super(s);
	}

}
