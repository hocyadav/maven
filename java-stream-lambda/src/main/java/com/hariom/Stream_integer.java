package com.hariom;

import java.util.stream.IntStream;

public class Stream_integer {
	public static void main(String[] args) {
		int[] numArry = {10,34,5,90,100,45,2};
		//calling 4 times stream
		IntStream.of(numArry)
				.min()
				.ifPresent(min -> System.out.println(min));
		
//		int min1 = 0;
//		IntStream.of(numArry).min().ifPresent(min -> min1 = min);
//		
		
		IntStream.of(numArry)
				.max()
				.ifPresent(max -> System.out.println(max));
		
		IntStream.of(numArry)
				.average()
				.ifPresent(avg -> System.out.println(avg));
		
		int i = (int) IntStream.of(numArry)
				.count();
		System.out.println(i);
		
		int sum = IntStream.of(numArry)
				.sum();
		System.out.println(sum);
		
	}
}
