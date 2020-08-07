package com.recruitment.api.exception;

/**
 *
 * @author TuanNA96
 */
public class ConstructorException extends RuntimeException {

	public ConstructorException() {
		super("Suppress default constructor for noninstantiability");
	}
}
