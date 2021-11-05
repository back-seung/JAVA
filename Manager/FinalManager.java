package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import DTO.Schedule;

public class FinalManager {
	private ScheduleManager baek = null;
	private Scanner sc = new Scanner(System.in);

	public FinalManager(ScheduleManager b) {
		this.baek = b;
	}

	public void loginMenu() {
		boolean flag = true;
		while (flag) {
			menu();
			String selMenu = sc.nextLine();
			switch (selMenu) {
			case "1":
				addDate();
				break;
			default:
				flag = false;
			}
		}
	}

	private void addDate() {
		System.out.println("날짜를 지정할 스케줄의 번호를 입력하세요");
		ArrayList<Schedule> sListForDate = baek.getMyS();
		for (int i = 0; i < sListForDate.size(); i++) {
			System.out.println("##### NO : " + i + " ####");
			sListForDate.get(i).prt();
		}
		int selNo = sc.nextInt();
		sc.nextLine();
		System.out.println("날짜를 입력해주세요");
		String selM = sc.nextLine();
		sListForDate.get(selNo).setDate(selM);
		System.out.println("지정 완료");
	}

	private void menu() {
		System.out.println("1. 스케줄 날짜 지정");
	}
}
