package com.FactoryDesignPattern;

public class TEST_Vehilcle {
	public static void main(String[] args) {
		//get car obj by using vehicle factory class
		Vehicle car = new VehicleFactory().getInstanceOfSubClass("car", 124);
		System.out.println(car);
		
		Vehicle bike = new VehicleFactory().getInstanceOfSubClass("bike", 34534);
		System.out.println(bike);
		
		Vehicle vehicle = new VehicleFactory().getInstanceOfSubClass("", 23424);
		System.out.println(vehicle);
		
	}
}
