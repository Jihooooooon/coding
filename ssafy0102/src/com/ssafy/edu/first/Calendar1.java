package com.ssafy.edu.first;

import java.util.Calendar;
import java.util.Scanner;

public class Calendar1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("년도를 입력하세요: ");
		int year = sc.nextInt();
		
		System.out.print("월을 입력하세요: ");
		int month = sc.nextInt();
		
		Calendar start_day = Calendar.getInstance();
		Calendar end_day = Calendar.getInstance();
		
		start_day.set(year, month-1,1);
		end_day.set(year, month-1,start_day.getActualMaximum(Calendar.DATE));
		
		int sday_week = start_day.get(Calendar.DAY_OF_WEEK);
		
		int eday = end_day.get(Calendar.DATE);
		System.out.println("\t"+year+" 년"+month+" 월");
		System.out.println("일 월 화 수 목 금 토");
		

	}

}
