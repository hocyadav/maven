package com.hari;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserService3 {
	public static void main(String[] args) {
		//running 1000 thread same time
		//both using simple date format obj , total 1000 objects
		for(int i = 0; i < 1000; i++) {
			int id = i;
			new Thread( () -> {
				String dob = new UserService3().getBday(id);
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
