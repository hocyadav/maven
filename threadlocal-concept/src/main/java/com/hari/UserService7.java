package com.hari;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadLocal_SafeFormatter {
	public static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {//call once for each thread
			return new SimpleDateFormat("yyyy-MM-dd");
		}
		
		@Override
		public SimpleDateFormat get() {//each thread will get its own copy
			return super.get();
		}
		
	};
}

public class UserService7 {
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		
		for (int i = 0; i < 1000; i++) {
			int id = i;
			executorService.submit(() -> {
				String dob = new UserService7().getBday(id);
				System.out.println(Thread.currentThread().getName() + " user id : " + id + ", dob	: " + dob);
			});
		}
	}

	public static String getBday(int userId) {
		Date birthday = new Date();
		final SimpleDateFormat simpleDateFormat = ThreadLocal_SafeFormatter.threadLocal.get();
		return simpleDateFormat.format(birthday);// using global object
	}

}
