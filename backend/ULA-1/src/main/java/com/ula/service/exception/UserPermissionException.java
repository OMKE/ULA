package com.ula.service.exception;

public class UserPermissionException extends Exception {

	public UserPermissionException(String message) {
		super(message);
	}

	public UserPermissionException(Throwable throwable) {
		super(throwable);
	}
}
