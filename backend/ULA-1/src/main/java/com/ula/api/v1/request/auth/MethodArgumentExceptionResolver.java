package com.ula.api.v1.request.auth;

import java.util.ArrayList;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class MethodArgumentExceptionResolver
{



	public static ArrayList<String> resolve(Errors errors)
	{

		ArrayList<String> exceptionMessages = new ArrayList<>();
		
		for (FieldError fE : errors.getFieldErrors())
		{
			exceptionMessages.add(fE.getDefaultMessage());
		}
		
		return exceptionMessages;
	}

	public static ArrayList<String> resolve(Errors errors, Exception e)
	{
		ArrayList<String> exceptionMessages = new ArrayList<>();
		exceptionMessages.add(e.getMessage());

		for (FieldError fE : errors.getFieldErrors())
		{
			exceptionMessages.add(fE.getDefaultMessage());
		}

		return exceptionMessages;
	}
}
