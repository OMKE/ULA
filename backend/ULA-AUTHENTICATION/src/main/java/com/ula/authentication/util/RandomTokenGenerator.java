package com.ula.authentication.util;

import java.util.Random;

/*
 * RandomTokenGenerator
 * @desc Generates a random string based on given length
 */

public class RandomTokenGenerator {

	public static String generate(int length) {

		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ$!.1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < length) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();

		return saltStr;
	}

}
