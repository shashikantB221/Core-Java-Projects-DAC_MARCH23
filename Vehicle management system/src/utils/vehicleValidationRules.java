package utils;

import java.time.LocalDate;
import java.util.List;

import code.Color;
import code.Vehicle;
import vehicle_exception.VehicleHandlingException;

public class vehicleValidationRules {
	
	public static Vehicle validateAllInputs(String chasisNo, String vehicleColor, double basePrice, String manufacturerDate, String company, List<Vehicle> vlist
		) throws VehicleHandlingException {
		
		checkForDupVehicle(chasisNo, vlist);
		Color ValidColor = parseAndValidateColor(vehicleColor);
		double netPrice = ValidColor.getColorCost()+basePrice;
		LocalDate validMdate =  parseAndValidateManufacturingDate(manufacturerDate);
		
		return new Vehicle(chasisNo,ValidColor,netPrice,validMdate,company);
		
		
		
	}

	//add a static method to parse n validate color
	public static Color parseAndValidateColor(String clr)
	throws VehicleHandlingException{
		Color validClr  = Color.valueOf(clr.toUpperCase());
		return validClr;
	}
	
	// add a static method to parse n validate manu. date
	public static LocalDate parseAndValidateManufacturingDate(String date) throws VehicleHandlingException
	{
		LocalDate d1 = LocalDate.parse(date);
		LocalDate beginYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
		if(d1.isAfter(beginYear))
			return d1;
		else
			throw new VehicleHandlingException("invalid manufacturing date");
	}
	
	// No dup vehicles should be added in the showroom 
	
	public static void checkForDupVehicle(String chasisNo, List<Vehicle> list) throws VehicleHandlingException {
		Vehicle newVehicle = new Vehicle(chasisNo);
		if(list.contains(newVehicle))
			throw new VehicleHandlingException("Duplicate chasis no.!!!!!!!");
		else
			System.out.println("no dup found");
	}
}
