package com.recruitment.api.constant;

import com.recruitment.api.exception.ConstructorException;

/**
 * The Class ApiURL.
 *
 * @author TuanNA96
 */
public final class ApiURL {

	/** The Constant ROLE. */
	public static final String ROLE = "role";

	/** The Constant USER. */
	public static final String USER = "user";

	/** The Constant LOGIN. */
	public static final String AUTH = "auth";

	/** The Constant REPORT. */
	public static final String REPORT = "report";
	
	public static final String Index = "index";
	
	/** The Constant REPORT. */
	public static final String BANNER = "banner";
	/**
	 * Instantiates a new api URL.
	 */
	private ApiURL() {
		throw new ConstructorException();
	}

}
