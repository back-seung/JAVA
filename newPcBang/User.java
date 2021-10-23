package newPcBang;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	String id = null;
	String pw = null;
	ArrayList<PriceList> showP = null;
	PriceList myP = new PriceList();
	Scanner sc = new Scanner(System.in);

	User(ArrayList<PriceList> prices) {
		showP = prices;
	}

	private void addTime() { // 시간 충전
		System.out.println("--------------------");
		seeTable();
		System.out.println("--------------------");
		System.out.println("원하는 시간을 입력해주세요");
		int selTime = sc.nextInt();
		for (int i = 0; i < showP.size(); i++) {
			if (selTime == showP.get(i).setTime) {
				myP.setTime += showP.get(i).setTime;
				System.out.println(showP.get(i).setTime + "시간이 충전되었습니다.");
				myP.setPrice += showP.get(i).setPrice;
			}
		}
	}

	private void seeTable() { // 시간 충전시 시간표 출력
		System.out.println("<<\t시\t간\t표\t>>");
		for (int i = 0; i < showP.size(); i++) {
			System.out.println("시간");
			System.out.print(showP.get(i).setTime + "\t");
			System.out.println("");
			System.out.println("가격");
			System.out.print(showP.get(i).setPrice + "\t");
			System.out.println("");
		}
	}

	private void showMyTime() { // 현재까지 충전한 시간 조회
		System.out.println(id + "님 남은시간 : " + myP.setTime);
	}

	public void loginMenu() {
		System.out.println("안녕하세요" + id + "유저님\t");
		while (true) {
			System.out.println("1 . 시간 충전");
			System.out.println("2 . 내 남은 시간 조회");
			System.out.println("3 . 로그아웃");

			String selMenu = sc.nextLine();
			if (selMenu.equals("1")) {
				addTime();
			} else if (selMenu.equals("2")) {
				showMyTime();
			} else if (selMenu.equals("3")) {
				break;
			}
		}
	}

}
