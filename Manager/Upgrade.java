package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import DTO.Schedule;

public class Upgrade {
	private Scanner sc = new Scanner(System.in);
	ArrayList<Schedule> mList = null;
	private ArrayList<Schedule> justSaveS = new ArrayList<>();

	Upgrade(ArrayList<Schedule> scheduleList) {
		this.mList = scheduleList;
	}

	private void addValues() {
		for (int i = 0; i < mList.size(); i++) {
			if (!(justSaveS.contains(mList.get(i)))) {
				justSaveS.add(mList.get(i));
			}
		}
	}

	public void loginMenu() {
		addValues();
		boolean flag = true;
		while (flag) {
			menu();
			String selMenu = sc.nextLine();
			switch (selMenu) {
			case "1":
				addJSS();
				break;
			case "2":
				delJSS();
				break;
			case "3":
				listJSS();
				break;
			default:
				flag = false;
			}
		}
	}

	private void addJSS() {
		Schedule s = new Schedule();
		System.out.println("나만의 스케줄 이름 입력");
		String addN = sc.nextLine();
		s.setsName(addN);
		System.out.println("나만의 스케줄 내용 입력");
		String addD = sc.nextLine();
		s.setsDescription(addD);
		justSaveS.add(s);

	}

	private void delJSS() {
		System.out.println("삭제할 나만의 스케줄 이름 입력");
		String delN = sc.nextLine();
		for (int i = 0; i < justSaveS.size(); i++) {
			if (justSaveS.get(i).getsName().equals(delN)) {
				justSaveS.remove(i);
				break;
			}
		}
	}

	private void listJSS() {
		System.out.println("전체 스케줄 조회 중...");
		for (int i = 0; i < justSaveS.size(); i++) {
			justSaveS.get(i).prt();
		}
		System.out.println("끝");
	}

	private void menu() {
		System.out.println("1. 추가");
		System.out.println("2. 삭제");
		System.out.println("3. 전체보기");
	}

}
