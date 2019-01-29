package com.ssafy.edu.first;

import java.util.Scanner;

public class GameTest {
	static Scanner sc = new Scanner(System.in);

	// 가위:0, 바위 : 1 , 보 :2
	public int change_user_input(String userInput) {
		switch (userInput) {
		case "가위":
			return 0;

		case "바위":

			return 1;
		case "보":

			return 2;

		default:
			return -1;
		}

	}

	public int rock_paper_scissors(int randomInput, int userInput) {
		int result = 0;
		if (randomInput == userInput) {
			return result;
		} else if (randomInput < userInput) {
			if (userInput - randomInput == 2) {
				result= -1;
			} else {
				result = 1;
			}
		} else if (randomInput > userInput) {
			if (randomInput - userInput == 2) {
				result= 1;
			} else {
				result = -1;
			}
		}
		return result;
	}

	public void solution() {
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1.5판 3승");
		System.out.println("3판 2승");
		System.out.println("1판 1승");
		System.out.print("번호를 입력하세요. ");
		int gameType = sc.nextInt();
		int user_winCount = 0;
		int com_winCount = 0;
		switch (gameType) {
		case 1:
			while (user_winCount < 3 && com_winCount < 3) {
				System.out.print("가위바위보 중 하나 입력: ");
				String inputTemp = sc.next();
				int userInput = change_user_input(inputTemp);
				int comInput = (int) (Math.random() * 3);
				int result = rock_paper_scissors(comInput, userInput);
				if (result == 1) {
					user_winCount++;
					// System.out.println("컴퓨터:"+comInput+" 사용자:"+userInput);
					System.out.println("이겼습니다!!!");
				} else if (result == -1) {
					// System.out.println("컴퓨터:"+comInput+" 사용자:"+userInput);
					com_winCount++;
					System.out.println("졌습니다!!!");
				} else if (result == 0) {
					// System.out.println("컴퓨터:"+comInput+" 사용자:"+userInput);
					System.out.println("비겼습니다.!!!");

				}
			}
			break;
		case 2:
			while (user_winCount < 2 && com_winCount < 2) {
				System.out.print("가위바위보 중 하나 입력: ");
				String inputTemp = sc.next();
				int userInput = change_user_input(inputTemp);
				int comInput = (int) (Math.random() * 3);
				int result = rock_paper_scissors(comInput, userInput);
				if (result == 1) {
					user_winCount++;
					System.out.println("이겼습니다!!!");
				} else if (result == -1) {
					//System.out.println("컴퓨터:" + comInput + " 사용자:" + userInput);
					com_winCount++;
					System.out.println("졌습니다!!!");
				} else if (result == 0) {
					System.out.println("비겼습니다.!!!");

				}
			}
			break;
		case 3:
			while (user_winCount < 1 && com_winCount < 1) {
				System.out.print("가위바위보 중 하나 입력: ");
				String inputTemp = sc.next();
				int userInput = change_user_input(inputTemp);
				int comInput = (int) (Math.random() * 3);
				int result = rock_paper_scissors(comInput, userInput);
				if (result == 1) {
					user_winCount++;
					System.out.println("이겼습니다!!!");
				} else if (result == -1) {
					//System.out.println("컴퓨터:" + comInput + " 사용자:" + userInput);
					com_winCount++;
					System.out.println("졌습니다!!!");
				} else if (result == 0) {
					System.out.println("비겼습니다.!!!");

				}
			}
			break;
		default:
			break;
		}
		System.out.println();
		System.out.println();
		System.out.println();
		if (com_winCount > user_winCount) {
			System.out.println("### 컴퓨터 승!!!");
		} else {
			System.out.println("### 사용자 승!!!");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameTest temp = new GameTest();

		temp.solution();
	}

}
