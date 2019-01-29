package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieMgr movie = new MovieMgr();
		Scanner sc = new Scanner(System.in);
		System.out.println("<<< 영화 관리 프로그램 >>>");
		while(true) {
			boolean flag = false;
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영호 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화 장르별 검색");
			System.out.println("5. 영화 정보 삭제");
			System.out.println("0. 종료");
			System.out.print("원하는 번호를 선택하세요.");
			int n = sc.nextInt();
			sc.nextLine();
			switch (n) {
			case 0:
				flag=true;
				break;
			case 1:
				String title;
				String director;
				int grade;
				String genre;
				String summary;
				System.out.print("영화제목을 입력하세요:");
				
				title=sc.nextLine();
				//sc.nextLine();
				System.out.print("영화감독을 입력하세요:");
				director = sc.next();
				sc.nextLine();
				System.out.print("영화등급을 입력하세요:");
				grade = sc.nextInt();
				sc.nextLine();
				System.out.print("영화장르를 입력하세요:");
				genre = sc.nextLine();
				System.out.print("영화요약을 입력하세요:");
				summary = sc.nextLine();
				
				movie.add(new Movie(title,director,grade,genre,summary));
				break;
			case 2:
				System.out.println("저장된 전체 영화 정보를 출력합니다..");
				System.out.println(Arrays.toString(movie.search()));
				break;
			case 3:
				String name;
				System.out.print("검색할려는 영화명을 입력하세요:");
				name=sc.nextLine();
				System.out.println("검색된 영화를 출력합니다..");
				System.out.println(Arrays.toString(movie.search(name)));
				break;
			case 4:
				String genreT;
				System.out.print("검색할려는 장르를 입력하세요:");
				genreT = sc.nextLine();
				System.out.println("검색된 영화를 출력합니다..");
				System.out.println(Arrays.toString(movie.searchGenre(genreT)));
				break;
			case 5:
				String movieT;
				System.out.print("삭제할려는 영화를 입력하세요:");
				movieT = sc.nextLine();
				movie.delete(movieT);
				System.out.println("삭제가 성공적으로 끝났습니다..");
				
				break;
			default:
				break;
			}
			if(flag) {
				System.out.println("프로그램을 종료합니다..");
				break;
			}
		}
	}

}
