package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar time = Calendar.getInstance();
		sc.init();
		ProductMgr product = ProductMgr.getInstance();
		MemMgr member = MemMgr.getInstance();
		System.out.println("상품 재고 관리 프로그램을 시작합니다..");
		System.out.println("접속 일시    : "+time.getTime());
		System.out.println("---------------------------------------------------------------------------------------------");
		while(true) {
			System.out.println("1. 상품 정보 관리");
			System.out.println("2. 고객 정보 관리");
			System.out.println("3. 상품 판매 관리");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호를 선택하세요 :");
			int n = sc.nextInt();
			boolean flag=false;
			switch (n) {
			case 0:
				System.out.println("접속을 종료합니다.."+time.getTime());
				flag=true;
				break;
			case 1:
				System.out.println("1. 상품 추가");
				System.out.println("2. 상품 검색");
				System.out.println("3. 상품 가격 수정");
				System.out.println("4. 상품 삭제");
				
				System.out.print("번호를 선택하세요 :");
				int t = sc.nextInt();
				if(t==1) {
					String no, name;
					int price,amount;
					System.out.print("상품 번호를 입력하세요 :");
					no = sc.next();
					System.out.print("상품명을 입력하세요 :");
					name = sc.next();
					System.out.print("상품 가격을 입력하세요 :");
					price =sc.nextInt();
					System.out.print("상품 수량을 입력하세요 :");
					amount = sc.nextInt();
					product.add(new Product(no,name,price,amount));
					
				}
				else if(t==2) {
					System.out.println("1. 상품리스트 전체 출력");
					System.out.println("2. 상품번호로 검색");
					System.out.print("번호를 선택하세요 :");
					int temp = sc.nextInt();
					if(temp==1) {
						for(Product p : product.findAll()) {
							System.out.println(p);
						}
					}
					else if(temp==2) {
						System.out.print("상품 번호를 입력하세요 : ");
						String tt = sc.next();
						Product pro = product.findByNo(tt);
						if(pro!=null) {
							System.out.println(pro);
						}
						else {
							System.out.println("검색 된 상품이 없습니다...");
						}
					}
					else {
						System.out.println("잘못 된 입력입니다.");
					}
				}
				else if(t==3) {
					System.out.print("상품 번호를 입력하세요 : ");
					String tt = sc.next();
					System.out.print("상품 가격을 입력하세요 : ");
					int tp = sc.nextInt();
					product.updateProduct(tt, tp);
				}
				else if(t==4) {
					System.out.print("상품 번호를 입력하세요 : ");
					String tt = sc.next();
					product.deleteProduct(tt);
				}
				else {
					System.out.println("잘못 된 입력입니다.");
				}
				break;
			case 2:
				System.out.println("1.회원 추가");
				System.out.println("2.회원 검색");
				System.out.println("3.회원 삭제");
				System.out.print("번호를 입력하세요 :");
				int nnn = sc.nextInt();
				switch (nnn) {
				case 1:
					System.out.print("회원 ID를 입력하세요 :");
					int id=sc.nextInt();
					System.out.print("회원 전화번호를 입력하세요 :");
					int num=sc.nextInt();
					System.out.print("회원 이름을 입력하세요 :");
					String name=sc.next();
					System.out.print("회원 나이를 입력하세요 :");
					int age=sc.nextInt();
					member.save(new Member(id, num, name, age));
					
					break;
				case 2:
					System.out.print("회원 ID를 입력하세요 :");
					int idd=sc.nextInt();
					System.out.println(member.searchById(idd));
					break;
				case 3:
					System.out.print("회원 ID를 입력하세요 :");
					int iddr=sc.nextInt();
					if(member.removeById(iddr)) {
						System.out.println("삭제 성공!");
					}
					else {
						System.out.println("삭제 실패");
					}
					break;
				default:
					break;
				}
				
				break;
			case 3:
				System.out.print("판매 상품 번호를 입력하세요 :");
				String tt = sc.next();
				System.out.print("판매 상품 수량을 입력하세요 :");
				int am = sc.nextInt();
				product.soldProduct(tt, am);
				break;
			default:
				break;
			}
			if(flag) {
				break;
			}
		}
		
	}

	static class sc {
		static BufferedReader br;
		static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}

		static String readLineReplace() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return st.nextToken();
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}
	}

}
