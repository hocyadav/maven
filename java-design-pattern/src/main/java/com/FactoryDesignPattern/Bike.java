package com.FactoryDesignPattern;

class Bike extends Vehicle{
	int bikeVal;
	
	@Override
	public int getSubClassValue() {
		return this.bikeVal;
	}
	
	//set value by constructor
	public Bike(int bikeval) {
		this.bikeVal = bikeval;
	}

	@Override
	public String toString() {
		return "Bike [bikeVal=" + bikeVal + "]";
	}
	
	
}
