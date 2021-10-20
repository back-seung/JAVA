package human;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanUser {
	String id = null;
	String pw = null;
	Scanner sc = new Scanner(System.in);
	SubjectList sList = null;
	ArrayList<String> myList = new ArrayList<>();
	ArrayList<String> myPF = new ArrayList<>();
	ArrayList<String> myClass = new ArrayList<>();

	HumanUser(SubjectList s) {
		sList = s;
	}

	public void addClass() {
		ArrayList<String> ls = sList.getSubject();
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i) != null) {
				System.out.println(i + "번 : " + ls.get(i));
			}
		}
		System.out.println("신청할 과목의 번호를 누르세요");
		int selNum = sc.nextInt();
		sc.nextLine();
		myList.add(sList.subjectList.get(selNum));
		myPF.add(sList.PF.get(selNum));
		myClass.add(sList.classes.get(selNum));
	}

	public void menu() {
		while (true) {
			viewMenu();
			String selNum = sc.nextLine();
			if (selNum.equals("1")) {
				addClass();
			} else if (selNum.equals("2")) {
				viewList();
			} else if (selNum.equals("3")) {
				break;
			}
		}
	}

	private void viewList() {
		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i) != null) {
				System.out.println("수업 : " + myList.get(i));
				System.out.println("교수님 : " + myPF.get(i));
				System.out.println("교실 : " + myClass.get(i));
			}
		}
	}

	private void viewMenu() {
		System.out.println("현재 사용 : " + id + "님");
		System.out.println("1. 수강신청");
		System.out.println("2. 수강신청 내용");
		System.out.println("3. 종료");
		System.out.println("메뉴선택 >> ");
	}
}
