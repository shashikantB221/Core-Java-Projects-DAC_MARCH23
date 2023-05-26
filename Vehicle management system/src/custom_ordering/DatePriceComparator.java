package custom_ordering;

import java.util.Comparator;

import code.Vehicle;

public class DatePriceComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		int retValue = o1.getManufacturerDate().compareTo(o2.getManufacturerDate());
		if(retValue==0)
		{
			if(o1.getNetPrice()<o1.getNetPrice()) {
				return -1;
			}
			else if(o1.getNetPrice()==o2.getNetPrice()) {
				return 0;
			}
			else
				return 1;
		}
		else
		return retValue;
	}

}
