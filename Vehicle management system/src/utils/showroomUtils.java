package utils;


import java.util.ArrayList;
import java.util.List;
import static utils.vehicleValidationRules.*;

import code.Vehicle;

public class showroomUtils {
	
	public static List<Vehicle> populatedList() {
		
		/*String chasisNo, Color vehicleColor, double netPrice, LocalDate manufacturerDate, String compan*/
		
		
		try {
			
			List<Vehicle> vcl = new ArrayList<Vehicle>();
			vcl.add(validateAllInputs("abc-1001","BLACK",500000,"2023-02-04","TATA",vcl));
			vcl.add(validateAllInputs("abc-1002","WHITE",600000,"2023-03-04","SUZUKI",vcl));
			vcl.add(validateAllInputs("abc-1010","RED",700000,"2023-04-04","MARUTI",vcl));
			vcl.add(validateAllInputs("abc-1015","SILVER",550000,"2023-02-14","HONDA",vcl));
			vcl.add(validateAllInputs("abc-1016","BLACK",400000,"2023-02-03","HUNDAI",vcl));
			vcl.add(validateAllInputs("abc-2001","WHITE",410000,"2023-02-17","FORD",vcl));
			vcl.add(validateAllInputs("abc-2010","BLACK",421123,"2023-02-23","TATA",vcl));
			vcl.add(validateAllInputs("abc-2023","BLUE",512123,"2023-02-28","RENAULT",vcl));
			vcl.add(validateAllInputs("abc-5225","RED",630000,"2023-02-09","TATA",vcl));
			
			return vcl;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	
	}

	
	
	
	
	
}
