package com.hari;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService4 {
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);
	
	public static void main(String[] args) {
		//running 10 thread same time and total task is 1000
		//both using simple date format obj , total 10 objects
		
		for(int i = 0; i < 1000; i++) {
			int id = i;
			executorService.submit( () -> {
				String dob = new UserService4().getBday(id);
				System.out.println(Thread.currentThread().getName()+" user id : "+id+", dob	: "+dob);
			});
		}
	}

	public static String getBday(int userId) {
		Date birthday = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		return simpleDateFormat.format(birthday);
	}

}
