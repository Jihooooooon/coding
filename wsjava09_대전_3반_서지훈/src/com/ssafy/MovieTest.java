package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReservMgr reserve = ReservMgr.getInstance();
		MemMgr mem = reserve.memMgr;
		MovieMgr movie = reserve.movieMgr; 
		Scanner sc = new Scanner(System.in);
		System.out.println("<<< 영화 예매 관리 프로그램 >>>");
		while(true) {
			boolean flag = false;
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영호 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화 시간별 검색");
			System.out.println("5. 영화 정보 삭제");
			System.out.println("6. 회원 정보 저장");
			System.out.println("7. 회원 정보 검색");
			System.out.println("8. 회원 정보 수정");
			System.out.println("9. 회원 정보 삭제");
			System.out.println("10. 영화 예매 관리");
			System.out.println("0. 종료");
			System.out.print("원하는 번호를 선택하세요.");
			int n = sc.nextInt();
			sc.nextLine();
			switch (n) {
			case 0:
				flag=true;
				break;
			case 1:
				int no;
				String title;
				String director;
				int grade;
				String genre;
				String summary;
				int time;
				System.out.print("영화번호를 입력하세요:");
				no = sc.nextInt();
				sc.nextLine();
				System.out.print("영화제목을 입력하세요:");
				
				title=sc.nextLine();
				//sc.nextLine();
				System.out.print("영화 시간을 입력하세요:");
				time=sc.nextInt();
				sc.nextLine();
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
				
				
				movie.add(new Movie(no,time,title,director,grade,genre,summary));
				break;
			case 2:
				System.out.print("출력 방식을 설정해 주세요(1:시간별 오름차순 2: 영화제목별 오름차순) : ");
				int sortM = sc.nextInt();
				sc.nextLine();
				if(sortM==1) {
					System.out.println(movie.sortTime());
				}
				else if(sortM==2) {
					System.out.println(movie.sortName());
				}
				else {
					System.out.println("잘못 된 입력입니다..");
				}
				break;
			case 3:
				String name;
				System.out.print("검색할려는 영화명을 입력하세요:");
				name=sc.nextLine();
				System.out.println("검색된 영화를 출력합니다..");
				System.out.println(Arrays.toString(movie.search(name)));
				break;
			case 4:
				int timeT;
				System.out.print("검색할려는 영화 시간대를 입력하세요:");
				timeT=sc.nextInt();
				sc.nextLine();
				System.out.println("검색된 영화를 출력합니다..");
				System.out.println(movie.searchTime(timeT));
				break;
			case 5:
				String movieT;
				System.out.print("삭제할려는 영화를 입력하세요:");
				movieT = sc.nextLine();
				movie.delete(movieT);
				System.out.println("삭제가 성공적으로 끝났습니다..");
				
				break;
			case 6:
				//회원정보저장
				int idT;
				int telT;
				String nameT;
				int ageT;
				System.out.print("회원 ID를 입력하세요:");
				idT=sc.nextInt();
				sc.nextLine();
				System.out.print("회원 전화번호를 입력하세요:");
				telT=sc.nextInt();
				sc.nextLine();
				System.out.print("회원 이름을 입력하세요:");
				nameT=sc.nextLine();
				
				System.out.print("회원 나이를 입력하세요:");
				ageT=sc.nextInt();
				sc.nextLine();
				mem.save(new Member(idT, telT, nameT, ageT));

				
				break;
			case 7:
				//7. 회원 정보 검색
				int id;
				System.out.print("검색할려는 회원 ID를 입력하세요:");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println("검색된 회원 정보를 출력합니다..");
				System.out.println(mem.searchById(id));
				break;
			case 8:
				//8. 회원 정보 수정
				int infoId;
				int infoTel;
				int infoAge;
				System.out.print("수정할려는 회원 ID를 입력하세요:");
				infoId = sc.nextInt();
				sc.nextLine();
				System.out.print("회원 전화번호를 입력하세요:");
				infoTel = sc.nextInt();
				sc.nextLine();
				System.out.println("회원 나이를 입력하세요:");
				infoAge = sc.nextInt();
				sc.nextLine();
				if(mem.updateName(infoId, infoTel, infoAge)) {
					System.out.println("성공적으로 업데이트 되었습니다..");
				}
				else {
					System.out.println("업데이트에 실패했습니다.");
				}
				break;
			case 9:
				//회원 삭제
				int tempId;
				System.out.print("삭제할려는 회원 ID를 입력하세요:");
				infoId = sc.nextInt();
				sc.nextLine();
				if(mem.removeById(infoId)) {
					System.out.println("성공적으로 삭제 되었습니다..");
				}
				else {
					System.out.println("삭제에 실패했습니다.");
				}
				break;
			case 10:
				//예매 관리
				System.out.println("1. 영화 예매");
				System.out.println("2. 예매 정보 삭제");
				System.out.print("번호를 입력하세요:");
				int tempNum=sc.nextInt();
				sc.nextLine();
				if(tempNum==1) {
					System.out.println(mem.search());
					System.out.println(movie.search());
					int movieNo;
					int memNo;
					System.out.print("회원 id를 입력하세요:");
					memNo= sc.nextInt();
					sc.nextLine();
					System.out.print("영화 넘버를 입력하세요:");
					movieNo = sc.nextInt();
					sc.nextLine();
					if(movie.searchNo(movieNo)==null) {
						System.out.println("예매 실패");
					}
					else if(mem.searchById(memNo)==null) {
						System.out.println("예매 실패");
					}
					else if(reserve.reserve(movie.searchNo(movieNo), mem.searchById(memNo))) {
						System.out.println("예매 성공");
					}
					else {
						System.out.println("예매 실패");
					}
					
				}
				else if(tempNum==2) {
					System.out.println("예매정보");
					reserve.print();
				
					int memNo;
					System.out.print("예매한 회원 ID를 입력하세요:");
					memNo= sc.nextInt();
					sc.nextLine();
					if(reserve.cancel(memNo)) {
						System.out.println("삭제 성공");
					}
					else {
						System.out.println("삭제 실패");
					}
					
				}
				
				else {
					System.out.println("잘못 된 입력입니다..");
				}
				
				
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
