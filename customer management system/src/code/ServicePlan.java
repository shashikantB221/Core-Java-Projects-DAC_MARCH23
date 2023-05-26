package code;

public enum ServicePlan {

	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);

	public double planCost;

	private ServicePlan(double planCost) {
		this.planCost = planCost;
	}

	public double getPlanCost() {
		return planCost;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name() + "@" + planCost;
	}

}
