package com.javaproject.ordermanagement.enums;

public enum UserRoles {

	ADMIN(1, "ROLE_ADMIN"), USER(2, "ROLE_USER");

	private int code;
	private String description;

	private UserRoles(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCod() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static UserRoles toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (UserRoles x : UserRoles.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Invalid ID: " + cod);
	}

}
