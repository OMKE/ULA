package com.ula.authentication.api.v1.request;


import com.ula.authentication.service.exception.RequiredFieldException;
import com.ula.authentication.util.AssertUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;

public class MethodArgumentExceptionResolver
{

	public static void checkFields(Object... objects) throws RequiredFieldException
	{
		try
		{
			AssertUtils.notNull(objects);
		} catch (IllegalArgumentException e)
		{
			throw new RequiredFieldException(e.getMessage());
		}
	}

	public static HashMap<String, String> resolve(Errors errors)
	{

		
		HashMap<String, String> exceptionMessages = new HashMap<String, String>();

		for (FieldError fE : errors.getFieldErrors())
		{
			exceptionMessages.put(fE.getField(), fE.getDefaultMessage());
		}
		
		return exceptionMessages;
	}

	public static HashMap<String, String> resolve(Errors errors, Exception e)
	{
		HashMap<String, String> exceptionMessages = new HashMap<>();
		exceptionMessages.put("exception", e.getMessage());

		for (FieldError fE : errors.getFieldErrors())
		{
			exceptionMessages.put(fE.getField(), fE.getDefaultMessage());
		}

		return exceptionMessages;
	}
}
