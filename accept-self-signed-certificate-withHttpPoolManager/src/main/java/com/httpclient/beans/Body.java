package com.httpclient.beans;

public class Body {
	String name;
	int id;
	public Body() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Body(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Body [name=" + name + ", id=" + id + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

