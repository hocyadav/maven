package com.hari;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserService {
	public static void main(String[] args) {
		//running 2 thread same time
		//both using simple date format obj , total 2 objects
		new Thread( () -> {
			String s = new UserService().getBday(1);
			System.out.println("s 1 : "+s);
		}).start();

		new Thread( () -> {
			String s = new UserService().getBday(2);
			System.out.println("s 2 : "+s);

		}).start();

	}

	public static String getBday(int userId) {
		Date birthday = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		return simpleDateFormat.format(birthday);
	}

}
