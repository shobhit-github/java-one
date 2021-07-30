package com.learning.springboot.utilities.enums;
import java.util.stream.Stream;

public enum Gender {

	MALE,
	FEMALE,
	TRANSGENDER,
	OTHER;

	public static String[] getList() {
		return Stream.of(Gender.values()).map(f -> "'" + f + "'").toArray(String[]::new);
	}

}
