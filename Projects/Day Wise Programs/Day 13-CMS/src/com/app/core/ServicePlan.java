package com.app.core;

public enum ServicePlan {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM (10000);
	private double costOfPlan;

	private ServicePlan(double costOfPlan) {
		//super(name,ordinal);
		this.costOfPlan = costOfPlan;
	}
	public double getCostOfPlan() {
		return costOfPlan;
	}
	@Override
	public String toString()
	{
		return name()+" cost "+costOfPlan;
	}
	
	
}
