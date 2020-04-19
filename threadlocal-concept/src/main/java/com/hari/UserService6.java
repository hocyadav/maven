package com.hari;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService6 {
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();//solution: create thread local
	//1. simpleDateFormat is global obj - 
	//2. multiple obj is accessing this obj
	//2. this obj is not synch so we will get wrong ans
	
	public static void main(String[] args) {
		//running 10 thread same time and total task is 1000
		//both using simple date format obj , total 10 objects
		for(int i = 0; i < 1000; i++) {
			int id = i;
			executorService.submit( () -> {
				String dob = new UserService6().getBday(id);
				System.out.println(Thread.currentThread().getName()+" user id : "+id+", dob	: "+dob);
			});
		}
	}

	public static String getBday(int userId) {
		Date birthday = new Date();
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat();//make it global
		String s;
		synchronized (UserService6.class) {//so only 1 thread is using this obj, so our problem solved, 
										//but we are using multiple thread so performace decrease
			s = simpleDateFormat.format(birthday);
		}
		return s;//using global object
	}

}
