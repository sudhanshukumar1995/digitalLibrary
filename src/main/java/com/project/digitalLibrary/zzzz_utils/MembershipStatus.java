package com.project.digitalLibrary.zzzz_utils;

public enum MembershipStatus {
	
	ACTIVE(1), EXPIRED(0);
	
	private int i;

	MembershipStatus(int i) {
		this.setI(i);
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	

}
