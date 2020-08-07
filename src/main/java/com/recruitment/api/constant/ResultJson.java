package com.recruitment.api.constant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.recruitment.api.errors.SysErr;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultJson {

	private String message;
	private SysErr error;
	private Object data;

	public ResultJson() {
	}

	private ResultJson(String message, SysErr error, Object data) {
		this.message = message;
		this.error = error;
		this.data = data;
	}

	public ResultJson(String message) {
		this(message, null, null);
	}

	public ResultJson(Object data) {
		this(Constants.SUCCESS, null, data);
	}

	public ResultJson(String message, SysErr error) {
		this(message, error, null);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SysErr getError() {
		return error;
	}

	public void setError(SysErr error) {
		this.error = error;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
