package custom_ordering;

import java.util.Comparator;

import code.Vehicle;

public class PriceComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		if(o1.getNetPrice() < o2.getNetPrice())
		{
			return -1;
		}
		if(o1.getNetPrice() == o2.getNetPrice())
		{
			return 0;
		}
		else
		return -1;
	}

}
