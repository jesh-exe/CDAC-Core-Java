package com.app.core;

public enum AccountTypes {
	SAVINGS(10000), CURRENT(5000), FD(25000);

	private int limit;

	private AccountTypes(int limit) {
		this.limit = limit;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
