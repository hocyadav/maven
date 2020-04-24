package com.hariom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.hariom.dao.EmployeeDao;
import com.hariom.entity.Employee;

public class Stream_Employee {
	public static void main(String[] args) {
		List<Employee> allEmp = EmployeeDao.getAllEmp();
		
		//M1: normal
		List<Employee> copy = new ArrayList<Employee>(allEmp);
		
		//sort decending
		System.out.println(copy);
		copy.sort((o1, o2) -> o2.getEmpId() - o1.getEmpId());
		System.out.println(copy);
		
		//get 1st 3 emp
		System.out.println("\n3 emp with decending order id");
		for(int i = 0; i < 3; i++) {
			Employee employee = copy.get(i);
			System.out.println(employee);
		}
		
		//M2: stream
		//1. Create, 2. Operate/Logic , 3. Consule
		System.out.println("\nprint emp obj");
		allEmp.stream()//1
				.sorted(Comparator.comparing(Employee::getEmpId).reversed())//2
				.limit(3)//2
				//.map(Employee::getName)
				.forEach(System.out::println);//print emp object ..//3
		
		System.out.println("\nPrint emp name");
		allEmp.stream()//1
				.sorted(Comparator.comparing(Employee::getEmpId).reversed())//2
				.limit(3)//2
				.map(empObj -> empObj.getName())//map below to print only name field...//2
				.forEach(System.out::println);//3
		
		//map : we dont want object, instead we want one field i.e. name field
		
		System.out.println("\nPrint emp name");
		allEmp.stream()//1
				.sorted(Comparator.comparing(Employee::getEmpId).reversed())//2
				.limit(3)//2
				.map(Employee::getName)//map another way
				.forEach(System.out::println);//3
		
		
		System.out.println("\nemp name : divisible by 2");
		allEmp.stream()//1
				.sorted(Comparator.comparing(Employee::getEmpId).reversed())//2
				.filter( empObj -> (empObj.getEmpId() % 2 == 0) )
				.limit(3)//2
				.map(Employee::getName)//map another way
				.forEach(System.out::println);//3
		
		//collect result in list
		System.out.println("\nCollect emp name in list");
		List<String> collect = allEmp.stream()//1
				.sorted(Comparator.comparing(Employee::getEmpId).reversed())//2
				.limit(3)//2
				.map(Employee::getName)//map another way
				.collect(Collectors.toList());
		System.out.println("collect : "+collect);
		
		
		//collect result in set
		Set<String> collect2 = allEmp.stream()
				.sorted(Comparator.comparing(Employee::getEmpId).reversed())
				.map(empObj -> empObj.getName())
				.collect(Collectors.toSet());
		
		System.out.println("collect2 "+collect2);
		
		//collect in map :TODO learn all collector methods 
		Map<Employee, Employee> collect3 = allEmp.stream()
				.limit(4)
				.collect(Collectors.toMap(empObj -> empObj, empObj -> empObj));
		System.out.println(collect3);
		
		
	}
}
