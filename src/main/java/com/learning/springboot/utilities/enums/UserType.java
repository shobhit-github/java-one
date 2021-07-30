package com.learning.springboot.utilities.enums;

import java.util.stream.Stream;

public enum UserType {

	DEVOTEE,
	UNION,
	TEMPLE_MANAGEMENT;

	public static String[] getList() {
		return Stream.of(UserType.values()).map(f -> "'" + f + "'").toArray(String[]::new);
	}

}
