package pcBang;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	String name = null;
	String pw = null;
	Scanner sc = new Scanner(System.in);
	ArrayList<priceList> pList = null;
	priceList myList = new priceList();

	User(ArrayList<priceList> p) {
		this.pList = p;
	}

	public void menu() {
		System.out.println(name + "님 남은 시간 : " + myList.time);
		viewTime();
		while (true) {
			System.out.println("");
			System.out.println("최대 충전 시간은" + pList.get(pList.size() - 1).time + "시간 입니다.");
			System.out.println("");
			System.out.println("1 : 충전");
			System.out.println("2 : 남은시간 조회");
			System.out.println("3 : 로그아웃");
			String selNum = sc.nextLine();
			if (selNum.equals("1")) {
				addTime();
			} else if (selNum.equals("2")) {
				System.out.println(name + "님 남은 시간 : " + myList.time);
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
		System.out.println("현재까지 총 지불 금액 : " + myList.price);
	}

	public void viewTime() {
		System.out.println("<<< \t시\t간\t표\t >>>");
		for (int i = 0; i < pList.size(); i++) {
			System.out.print(pList.get(i).price + "\t");
		}
		System.out.println("");
		for (int i = 0; i < pList.size(); i++) {
			System.out.print(pList.get(i).time + "시간\t");
		}
		System.out.println("");
	}
}
