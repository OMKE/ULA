package com.ula.util;

import org.springframework.util.Assert;

public class AssertUtils {

	private AssertUtils() {}
	
	
	public static void notNull(Object... objects) {
		for(Object object: objects) {
			Assert.notNull(object, "Argument can not be null");
			;
		}
	}
	
}
