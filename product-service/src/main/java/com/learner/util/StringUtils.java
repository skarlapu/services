package com.learner.util;

public class StringUtils {
	public static String name;

	public static String populateName() {
		name = "Hello";
		return name;
	}

	public static void populateName(String name) {
		StringUtils.name = name;
	}
}
