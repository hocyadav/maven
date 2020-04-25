package com.FactoryDesignPattern;

//problem : too many sub class
//solution : factory 
abstract class Vehicle {
	public abstract int getSubClassValue();
}

class VehicleFactory{
	public Vehicle getInstanceOfSubClass(String type, int parameter) {
		if(type == "car") {
			return new Car(parameter);
		}
		if(type == "bike") {
			return new Bike(parameter);
		}
		return null;
	}
}
