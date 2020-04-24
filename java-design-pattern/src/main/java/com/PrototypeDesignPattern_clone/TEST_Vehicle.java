package com.PrototypeDesignPattern_clone;

public class TEST_Vehicle {
	public static void main(String[] args) throws CloneNotSupportedException {
		Vehicle vehicle = new Vehicle();
		vehicle.insertData();
		System.out.println(vehicle);
		
		Vehicle vehicle2 = (Vehicle) vehicle.clone();
		vehicle2.getVehicleList().add("new car");//add new value into that object
		System.out.println(vehicle2);
	}
}
