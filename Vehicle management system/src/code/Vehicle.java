package code;

import java.time.LocalDate;
import java.util.Comparator;

import vehicle_exception.VehicleHandlingException;

public class Vehicle implements Comparable<Vehicle> {
	/*
	 * chasisNo(string) : Unique ID, color(enum) , netPrice(double) ,
	 * manufactureDate(LocalDate),company,isAvailable
	 */
	
	private String chasisNo;
	private Color vehicleColor;
	private double netPrice;
	private LocalDate manufacturerDate;
	private String company;
	private boolean isAvailable;
	public Vehicle(String chasisNo, Color vehicleColor, double netPrice, LocalDate manufacturerDate, String company) {
		super();
		this.chasisNo = chasisNo;
		this.vehicleColor = vehicleColor;
		this.netPrice = netPrice;
		this.manufacturerDate = manufacturerDate;
		this.company = company;
		this.isAvailable = true;
	}
	
	
	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", vehicleColor=" + vehicleColor + ", netPrice=" + netPrice
				+ ", manufacturerDate=" + manufacturerDate + ", company=" + company + ", isAvailable=" + isAvailable
				+ "]";
	}
	public String getChasisNo() {
		return chasisNo;
	}
	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}
	public Color getVehicleColor() {
		return vehicleColor;
	}
	public void setVehicleColor(Color vehicleColor) {
		this.vehicleColor = vehicleColor;
	}
	public double getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}
	public LocalDate getManufacturerDate() {
		return manufacturerDate;
	}
	public void setManufacturerDate(LocalDate manufacturerDate) {
		this.manufacturerDate = manufacturerDate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Vehicle)
			return this.getChasisNo().equals(((Vehicle)o).chasisNo);
		else
			return false;
	
	}
	
	public Vehicle(String newChasisNo)
	{
		this.chasisNo=newChasisNo;
	}




	@Override
	public int compareTo(Vehicle newVehicle) {
	  int i = this.chasisNo.compareTo(newVehicle.chasisNo);
	  System.out.println("in compareTo method of i="+i);
		return i;
	}

	





	
	
	
	
	

}
