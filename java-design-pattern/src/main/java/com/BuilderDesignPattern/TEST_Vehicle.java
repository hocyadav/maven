package com.BuilderDesignPattern;

public class TEST_Vehicle {
	public static void main(String[] args) {
		Vehicle car = new Vehicle.VehicleBuilder("req parameter", 123).build();
		System.out.println(car);
		
		Vehicle vehicle = new Vehicle.VehicleBuilder("req param", 456)
									.setOpt1(34)
									.build();
		System.out.println(vehicle);
	}
}
