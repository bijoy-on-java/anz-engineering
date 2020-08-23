package com.anz.app.exception;

/**
 * ANZ Engineering: Rest API custom exception class for demonstration purpose.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
public class ANZEngineeringException extends Exception {

	private static final long serialVersionUID = 1L;

	public ANZEngineeringException(final String errorMessage) {
		super(errorMessage);
	}
}
