package com.recruitment.api.errors;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class SysErr.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysErr implements Serializable {

	/** The code. */
	private String code;
	
	/** The params. */
	private SysErrParam params;

	/**
	 * Instantiates a new sys err.
	 */
	public SysErr() {
	}

	/**
	 * Instantiates a new sys err.
	 *
	 * @param code the code
	 * @param params the params
	 */
	public SysErr(String code, SysErrParam params) {
		this.code = code;
		this.params = params;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the params.
	 *
	 * @return the params
	 */
	public SysErrParam getParams() {
		return params;
	}

	/**
	 * Sets the params.
	 *
	 * @param params the new params
	 */
	public void setParams(SysErrParam params) {
		this.params = params;
	}

}
