package com.hariom;

import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Stream_integer2 {
	public static void main(String[] args) {
		int[] numArry = {10,34,5,90,100,45,2};
		
		//calling only 1 time stream
		IntSummaryStatistics summaryStatistics = IntStream.of(numArry).summaryStatistics();//create a summary obj 
		
		System.out.println(summaryStatistics.getMin());
		System.out.println(summaryStatistics.getMax());
		System.out.println(summaryStatistics.getAverage());
		System.out.println(summaryStatistics.getSum());
		System.out.println(summaryStatistics.getCount());
		
	}
}
