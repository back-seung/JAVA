package human;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanUser {
	String id = null;
	String pw = null;
	Scanner sc = new Scanner(System.in);
	SubjectList sList = null;
	ArrayList<String> myList = new ArrayList<>();

	HumanUser(SubjectList s) {
		sList = s;
	}

	public void addClass() {
		String[] ls = sList.getSubject();
		for (int i = 0; i < ls.length; i++) {
			if (ls[i] != null) {
				System.out.println(i + "번 : " + ls[i]);
			}
		}
		System.out.println("신청할 과목의 번호를 누르세요");
		int selNum = sc.nextInt();
		sc.nextLine();
		myList.add(ls[selNum]);
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
				System.out.println(">> " + myList.get(i));
			}
		}
	}

	private void viewMenu() {
		System.out.println("현재 사용 : " + id + "님");
		System.out.println("1. 수강신청");
		System.out.println("2. 장바구니");
		System.out.println("3. 종료");
		System.out.println("메뉴선택 >> ");
	}
}
