package com.hariom.dao;

import java.util.LinkedList;
import java.util.List;

import com.hariom.entity.Employee;

public class EmployeeDao {
	
	public static List<Employee> getAllEmp() {
		Employee employee = new Employee(1, "name 1");
		Employee employee1 = new Employee(2, "name 2");
		Employee employee2 = new Employee(3, "name 2");
		Employee employee3 = new Employee(4, "name 4");
		Employee employee4 = new Employee(5, "name 5");
		Employee employee5 = new Employee(6, "name 6");
		
		List<Employee> list = new LinkedList<Employee>();
		list.add(employee);
		list.add(employee1);
		list.add(employee2);
		list.add(employee3);
		list.add(employee4);
		list.add(employee5);
		
		return list;
	}
}
