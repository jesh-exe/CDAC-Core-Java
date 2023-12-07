package com.app.core;

public enum Color
{
	BLACK(50000),WHITE(10000),RED(25000),BLUE(35000),PINK(100);
	private int additionalCost;
	
	private Color(int colorCost){
		this.additionalCost = colorCost;
	}

	public int getAdditionalCost()
	{
		return additionalCost;
	}

	public void setAdditionalCost(int additionalCost)
	{
		this.additionalCost = additionalCost;
	}
	
	@Override
	public String toString()
	{
		return "Color = "+name()+"@ Additional Cost: "+additionalCost;
	}
	
	
}
