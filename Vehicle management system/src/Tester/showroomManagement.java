package Tester;

import static utils.showroomUtils.populatedList;
import static utils.vehicleValidationRules.validateAllInputs;
import static utils.vehicleValidationRules.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import code.Color;
import code.Vehicle;
import custom_ordering.DatePriceComparator;
import custom_ordering.PriceComparator;
import vehicle_exception.VehicleHandlingException;

public class showroomManagement {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			List<Vehicle> showroom = populatedList();
			boolean exit = false;

			

			while (!exit) {
				
				System.out.println("=====menu=====");
				System.out.println("1. add vehicle");
				System.out.println("2. display all vehicle");
				System.out.println("3. get specific vehicle details");
				System.out.println("4. apply discount");
				System.out.println("5. delete vehicle by chasis no.");
				System.out.println("6. delete vehicle by  color");
				System.out.println("7. Sort by chasis no. (Comparable => compareTo) ");
				System.out.println("8. Sort by price (Comaparator => compare)  ");
				System.out.println("9. Sort by date and price ");
				System.out.println("0. exit ");
			

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter new vehicle : chasisNo, Color ,  Price, manufacturerDate(yyyy-mm-dd),  company ");
						Vehicle validVehicle = validateAllInputs(sc.next(), sc.next(), sc.nextDouble(), sc.next(),
								sc.next(), showroom);
						showroom.add(validVehicle);
						System.out.println("vehicle added");
						break;
						
						

					case 2:
						System.out.println("Diplaying all vehicle ===>");
						for (Vehicle v : showroom) {
							System.out.println(v);
						}
						break;
						
						

					case 3:
						System.out.println("Enter chasis no");
						Vehicle vcl = new Vehicle(sc.next());
						int index = showroom.indexOf(vcl);
						if(index == -1)
						{
							throw new VehicleHandlingException("vehicle not found!!!");
						}
						else
							System.out.println(showroom.get(index));

						break;
						
						
						
					case 4:
						System.out.println("enter date and discount amount");
						LocalDate date = LocalDate.parse(sc.next());
						double discount = sc.nextDouble();
						
						for(Vehicle v : showroom)
						{
							if(v.getManufacturerDate().isBefore(date))
							{
								v.setNetPrice(v.getNetPrice() - discount);
							}
						}
						System.out.println("Discount applied");
						break;
						
						
						
					case 5:
						System.out.println("enter chasis no. to delete vehilcle");
						Vehicle v = new Vehicle(sc.next());
						index = showroom.indexOf(v);
						if(index == -1)
						{
							throw new VehicleHandlingException("Vehicle not found , invalid chasis no!!");
						}
						else 
						{
							showroom.remove(index);
							System.out.println("vehicle removed");
						}
						break;
						
						
						
					case 6://delete vehicle by color
						System.out.println("Enter color");
						Color chosenColor = parseAndValidateColor(sc.next());
						
						for(Vehicle v1 : showroom)
						{
							if(v1.getVehicleColor() == chosenColor)
								showroom.remove(v1);
							System.out.println("vehicle removed");
						}

						break;
						
					case 7: //sorting based on chasis no --> vehicle implements comaparable -- override compareTo return int(0,1,-1)
						Collections.sort(showroom);
						break;
						
					case 8: //sorting based on price --> vehicle implements comparator -- override compare return int(0,1,-1)
						Collections.sort(showroom , new PriceComparator());
						break;
						
					case 9: //sorting on the basis of date and price ==> if dates are same then go for price
						Collections.sort(showroom, new DatePriceComparator());
						break;
						

					case 0:
						exit = true;
						break;
					}// end of switch

				} catch (Exception e) {
					e.printStackTrace();
				} // end of try-catch
			} // end of while
		} // end of outer try

	}// end of main

}
