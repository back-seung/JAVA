package pcBang;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	String name = null;
	String pw = null;
	Scanner sc = new Scanner(System.in);
	ArrayList<priceList> pList = null;
	priceList myList = new priceList();

	User(ArrayList<priceList> p, int w) {
		myList.price = w;
		pList = p;
	}

	public void menu() {
		viewTime();
		for (int i = 0; i < pList.size(); i++) {
			System.out.print("가격 : " + pList.get(i).price);
			System.out.println("");
			System.out.print("시간 : " + pList.get(i).time);
			System.out.println("");
		}
		while (true) {
			
			System.out.println("충전하시겠습니까?");
			System.out.println("1 : 충전  /  2 : 남은시간 조회  /  3 : 로그아웃");
			String selNum = sc.nextLine();
			if (selNum.equals("1")) {
				addTime();
			} else if (selNum.equals("2")) {
				viewTime();
			} else if (selNum.equals("3")) {
				break;
			}
		}
	}

	public void addTime() {
		System.out.println("충전할 시간을 입력해주세요");
		int selTime = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).time == selTime) {
				myList.time += selTime;
				myList.price += pList.get(i).price;
			}
		}
		System.out.println("지불 금액 : " + myList.price);
	}

	public void viewTime() {
		System.out.println(name + "님 남은 시간 : " + myList.time);
	}
}
