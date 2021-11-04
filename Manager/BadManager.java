package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import DTO.Schedule;

public class BadManager {
	private ScheduleManager baek = null;
	private ArrayList<Schedule> dontTouch = null;
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Schedule> BadSList = new ArrayList<>(); // 별도 관리

	BadManager(ScheduleManager b) {
		this.baek = b;
		dontTouch = baek.getMyS();
	}

	public void loginMenu() {
		boolean flag = true;
		while (flag) {
			menu();
			System.out.println("메뉴 선택 ");
			String selNum = sc.nextLine();
			switch (selNum) {
			case "1":
				addBad();
				break;
			case "2":
				viewAll();
				break;
			default:
				flag = false;
				break;
			}
		}
	}

	private void menu() {
		System.out.println("1 : 나쁜 스케줄 등록");
		System.out.println("2 : 나쁜 스케줄 전체보기");
	}

	private void addBad() {
		System.out.println("나쁜 스케줄 i 번호입력");
		for (int i = 0; i < dontTouch.size(); i++) {
			System.out.println("##### NO : " + i + " ####");
			dontTouch.get(i).prt();
		}
		int selNo = sc.nextInt();
		sc.nextLine();
		BadSList.add(dontTouch.get(selNo));
	}

	private void viewAll() {
		for (int i = 0; i < BadSList.size(); i++) {
			System.out.println("##### NO : " + i + " ####");
			BadSList.get(i).prt();
		}
	}
}
