package com.recruitment.api.errors;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class SysErrParam.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysErrParam implements Serializable {

	/** The field. */
	private String field;
	
	/** The min length. */
	private Integer minLength;
	
	/** The max length. */
	private Integer maxLength;

	/**
	 * Instantiates a new sys err param.
	 */
	public SysErrParam() {
	}

	/**
	 * Instantiates a new sys err param.
	 *
	 * @param field the field
	 */
	public SysErrParam(String field) {
		this.field = field;
	}

	/**
	 * Gets the field.
	 *
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * Sets the field.
	 *
	 * @param field the new field
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * Gets the min length.
	 *
	 * @return the min length
	 */
	public Integer getMinLength() {
		return minLength;
	}

	/**
	 * Sets the min length.
	 *
	 * @param minLength the new min length
	 */
	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}

	/**
	 * Gets the max length.
	 *
	 * @return the max length
	 */
	public Integer getMaxLength() {
		return maxLength;
	}

	/**
	 * Sets the max length.
	 *
	 * @param maxLength the new max length
	 */
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

}
