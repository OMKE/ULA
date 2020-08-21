package com.ula.api.v1.request;



public class Sanitizer
{

//	@TODO
	
	public static void sanitize(String...fields) {
		org.springframework.boot.actuate.endpoint.Sanitizer sanitizer = new org.springframework.boot.actuate.endpoint.Sanitizer(
				fields);
	}
	
}
