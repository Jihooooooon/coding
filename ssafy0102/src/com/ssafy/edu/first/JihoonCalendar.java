package com.ssafy.edu.first;

public class JihoonCalendar {
	public static int[] LEAP = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static int[] PLAI = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		boolean isS = false;
		// 윤년구하기
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			isS = true;

		}
		return isS;

	}

	/*
	 * 2019년 1월 달력 -> 1~2018 몇일 지났니?
	 * 
	 * @param year
	 * 
	 * @return 1.1.1~ .몇일 경과
	 * 
	 * 
	 */
	public int totalDay(int year) {
		int tot = 0;
		for (int i = 1; i < year; i++) {
			if (isLeapYear(i)) {
				tot += 366;

			} else {
				tot += 365;
			}
		}
		return tot;
	}

	public int totalDay(int year, int month) {
		int tot = totalDay(year);
		for (int i = 1; i < month; i++) {
			if (this.isLeapYear(year)) {
				tot += LEAP[i - 1];
			} else {
				tot += PLAI[i - 1];
			}
		}
		return tot;
	}

	public int totalDay(int year, int month, int day) {
		return totalDay(year, month) + day;
	}

	public int lastDay(int year, int month) {
		int tot = 0;
		if (isLeapYear(year)) {
			tot = LEAP[month - 1];
		} else {
			tot = PLAI[month - 1];
		}
		return tot;

	}

	public void calendare(int year, int month) {
		String a = String.format("\t%d년\t%d월", year, month);
		String b = String.format("일\t월\t화\t수\t목\t금\t토", year, month);
		System.out.println(a);
		System.out.println(b);
		int dayOfWeek = (1 + totalDay(year, month, 1) - 1) % 7;

		for (int i = 1; i < dayOfWeek; i++) {
			System.out.println("\t");
		}
		int lastDay = lastDay(year, month);
		for (int i = 1; i <= lastDay; i++) {
			System.out.printf("%d\t",i);
			if((i+dayOfWeek)%7==0) {
				System.out.println();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			JihoonCalendar jc = new JihoonCalendar();
			jc.calendare(2019, 2);
	}

}
