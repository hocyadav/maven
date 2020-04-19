package com.hari;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserService2 {
	public static void main(String[] args) {
		//running 100 thread same time
		//both using simple date format obj , total 100 objects
		for(int i = 0; i < 100; i++) {
			int id = i;
			new Thread( () -> {
				String dob = new UserService2().getBday(id);
				System.out.println("user id	: "+id+" -- dob	: "+dob);
			}).start();
		}

	}

	public static String getBday(int userId) {
		Date birthday = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		return simpleDateFormat.format(birthday);
	}

}
