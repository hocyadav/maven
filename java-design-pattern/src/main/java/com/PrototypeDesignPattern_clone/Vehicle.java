package com.PrototypeDesignPattern_clone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//problem : get object copy not instance
//solution : Prototype --> implement cloneable interface and its clone method
class Vehicle implements Cloneable {
	private List<String> vehicleList;

	

	//constructor -default
	public Vehicle() {
		this.vehicleList = new ArrayList<String>();
	}

	//constructor - set fields
	public Vehicle(List<String> list) {
		this.vehicleList = list;
	}

	//set some dummy data into object
	public void insertData() {
		vehicleList.add("Honda amaze");
		vehicleList.add("Audi A4");
		vehicleList.add("Hyundai Creta");
		vehicleList.add("Maruti Baleno");
		vehicleList.add("Renault Duster");
	}

	//return field value
	public List<String> getVehicleList() {
		return this.vehicleList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> tempList = new ArrayList<String>();
		for(String s : this.getVehicleList()) {
			tempList.add(s);
		}

		//create new obj with new field values - by calling constriuctor
		Vehicle vehicle = new Vehicle(tempList);
		return vehicle;

	}
	
	@Override
	public String toString() {
		return "Vehicle [vehicleList=" + vehicleList + "]";
	}
}
