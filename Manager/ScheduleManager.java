package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import DTO.Schedule;

public class ScheduleManager {

	private Scanner sc = new Scanner(System.in);
	ArrayList<Schedule> myS = new ArrayList<>();
	private Upgrade baek = new Upgrade(getMyS());
	private BadManager badM = new BadManager(this);
	private PartManager partM = new PartManager();

	public ArrayList<Schedule> getMyS() {
		return myS;
	}

	public ScheduleManager() {
		boolean flag = true;
		while (flag) {
			init();
			menu();
			String selMenu = sc.nextLine();
			switch (selMenu) {
			case "1":
				addSchedule();
				break;
			case "2":
				modSchedule();
				break;
			case "3":
				delSchedule();
				break;
			case "4":
				srchSchedule();
				break;
			case "5":
				listSchedule();
				break;
			case "6":
				baek.loginMenu();
				break;
			case "7":
				badM.loginMenu();
			default:
				flag = false;
			}
		}
	}

	private void addSchedule() {
		Schedule s = new Schedule();
		System.out.println("스케줄 이름 입력");
		String addN = sc.nextLine();
		s.setsName(addN);
		System.out.println("스케줄 내용 입력");
		String addD = sc.nextLine();
		s.setsDescription(addD);
		myS.add(s);
	}

	private void delSchedule() {
		System.out.println("삭제할 스케줄 이름 입력");
		String delN = sc.nextLine();
		for (int i = 0; i < myS.size(); i++) {
			if (myS.get(i).getsName().equals(delN)) {
				myS.remove(i);
				System.out.println("삭제 완료");
				break;
			}
		}
	}

	private void modSchedule() {
		System.out.println("수정할 스케줄 이름 입력");
		String findN = sc.nextLine();
		for (int i = 0; i < myS.size(); i++) {
			if (myS.get(i).getsName().equals(findN)) {
				System.out.println("수정할 내용 입력");
				String modN = sc.nextLine();
				myS.get(i).setsDescription(modN);
				System.out.println("수정 완료");
				break;
			}
		}
	}

	private void srchSchedule() {
		System.out.println("검색할 스케줄 이름 입력");
		String findN = sc.nextLine();
		for (int i = 0; i < myS.size(); i++) {
			if (myS.get(i).getsName().equals(findN)) {
				myS.get(i).prt();
				break;
			}
		}
	}

	private void listSchedule() {
		System.out.println("전체 스케줄 조회 중...");
		for (int i = 0; i < myS.size(); i++) {
			System.out.println("제목 : " + myS.get(i).getsName());
			System.out.println("내용 : " + myS.get(i).getsDescription());
		}
		System.out.println("끝");
	}

	private void menu() {
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
		System.out.println("4. 검색");
		System.out.println("5. 전체조회");
		System.out.println("6. UPGRADE");
		System.out.println("7. BAD SCHEDULE");
	}

	private void init() {
		System.out.println("시스템을 준비 합니다.");
		System.out.println("Database에서 자료를 가져오는 중입니다.");
	}
}
