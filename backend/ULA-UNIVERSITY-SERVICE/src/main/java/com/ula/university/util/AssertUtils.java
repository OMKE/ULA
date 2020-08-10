package com.ula.university.util;

import org.springframework.util.Assert;

public class AssertUtils
{

	private AssertUtils() {}
	
	
	public static void notNull(Object... objects) throws IllegalArgumentException
	{
		for(Object object: objects) {
			Assert.notNull(object, "Field is required");
			} 

	}
}
	

