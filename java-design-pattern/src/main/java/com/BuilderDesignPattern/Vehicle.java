package com.BuilderDesignPattern;

//problem : too many fields values
//solution : builder 
public class Vehicle {
	//required parameter
	private String req1;
	private int req2;
	
	//optional parameter
	private int opt1;

	//1. private constructor - 
	//1.1 : but input argument can be taken from VehicalBuilder obj
	//2. getter (no setter coz anyone can change this)
	
	private Vehicle(VehicleBuilder vehicleBuilder) {//1 
		super();
		this.req1 = vehicleBuilder.req1;//1.1
		this.req2 = vehicleBuilder.req2;
		this.opt1 = vehicleBuilder.opt1;
	}

	public String getReq1() {
		return req1;
	}

	public int getReq2() {
		return req2;
	}

	public int getOpt1() {
		return opt1;
	}
	
	//2. static nested class --> VehicleBuilder
	//3. same argume as above
	//4. for required parameter-> create constructor , 
	//5. for optional create setter && return type is this VehicleBuilder class
	//6. create build() --> internally call above Vehicle constructor
	public static class VehicleBuilder {
		//required parameter
		private String req1;
		private int req2;
		
		//optional parameter
		private int opt1;

		//"public" constructor --> using required parameter
		public VehicleBuilder(String req1, int req2) {//4
			super();
			this.req1 = req1;
			this.req2 = req2;
		}
		
		//setter using --> optional parameter
		public VehicleBuilder setOpt1(int opt1) {//5
			this.opt1 = opt1;
			return this;
		}
		
		public Vehicle build() {
			Vehicle vehicle = new Vehicle(this);//internally calls Vehicle class constructor
			return vehicle;//return to user
		}
		
	}


	@Override
	public String toString() {
		return "Vehicle [req1=" + req1 + ", req2=" + req2 + ", opt1=" + opt1 + "]";
	}
	
	
	
	
}
