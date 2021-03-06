package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import DTO.Schedule;

public class PartManager {
	private ScheduleManager baek = null;
	private Scanner sc = new Scanner(System.in);

	PartManager(ScheduleManager b) {
		this.baek = b;
	}

	public void loginMenu() {
		boolean flag = true;
		while (flag) {
			menu();
			String selMenu = sc.nextLine();
			switch (selMenu) {
			case "1":
				addManagerS();
				break;
			default:
				flag = false;
			}
		}
	}

	private void addManagerS() {
		System.out.println("관리자를 지정할 스케줄의 번호를 입력하세요");
		ArrayList<Schedule> sListArr1 = baek.getMyS();
		for (int i = 0; i < sListArr1.size(); i++) {
			System.out.println("##### NO : " + i + " ####");
			sListArr1.get(i).prt();
		}
		int selNo = sc.nextInt();
		sc.nextLine();
		System.out.println("담당자를 입력해주세요");
		String selM = sc.nextLine();
		sListArr1.get(selNo).setmName(selM);
		System.out.println("지정 완료");
	}

	private void menu() {
		System.out.println("1. 스케줄 담당자 지정");
	}
}
