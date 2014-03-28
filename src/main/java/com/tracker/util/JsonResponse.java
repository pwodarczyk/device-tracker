
package com.tracker.util;


public class JsonResponse {


	private boolean success;

	private String message;

	public JsonResponse() {

		setSuccess( true );

	}

	public JsonResponse(boolean success) {

		setSuccess( success );

	}

	public JsonResponse(boolean success, String message) {

		setSuccess( success );

		setMessage( message );

	}

	public void setMessage(String message) {

		this.message = message;

	}

	public void setSuccess(boolean success) {

		this.success = success;

	}

	public String getMessage() {

		return message;

	}


	public boolean isSuccess() {

		return success;

	}

}
