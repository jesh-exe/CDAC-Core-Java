package core;

public enum ServicePlan {

	SILVER(1000),
	GOLD(2000),
	DIAMOND(5000),
	PLATINUM(10000);
	
	private double cost;
	
	  private ServicePlan(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	  
	 @Override
	 public String toString()
	 {
		 return name()+" "+cost;
	 }
}
