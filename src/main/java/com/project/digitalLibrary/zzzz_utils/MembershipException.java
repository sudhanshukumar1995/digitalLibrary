package com.project.digitalLibrary.zzzz_utils;

public class MembershipException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MembershipException(long userId, boolean isExist) {
		super(String.format("User with ID: %s %s an active membership.", userId,
				isExist ? "already has" : "does not have"));

	}
}
