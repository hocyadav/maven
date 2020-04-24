package com.FactoryDesignPattern;

class Car extends Vehicle{
	int carVal;
	@Override
	public int getSubClassValue() {
		return this.carVal;
	}
	
	//set value by constructor
	public Car(int carVal) {
		this.carVal = carVal;
	}

	@Override
	public String toString() {
		return "Car [carVal=" + carVal + "]";
	}
	
	
}
