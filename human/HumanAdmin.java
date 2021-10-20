package human;

import java.util.ArrayList;
import java.util.Scanner;

// 수강생 관리, 등록, 수정, 삭제, 검색
public class HumanAdmin {
	// 생성자 : 클래스 구조를 가진 객체가 생성될 때 호출되는 메서드.
	ArrayList<HumanUser> Users = new ArrayList<>(); // ArrayList 객체 생성
	Scanner sc = new Scanner(System.in);
	HumanUser loginUser = null;
	SubjectList subjectList = new SubjectList();

	HumanAdmin() {
		System.out.println("객체가 만들어졌습니다.");
		while (true) {
			menu();
			String selMenu = sc.nextLine();
			if (selMenu.equals("1")) {
				addUser();
			} else if (selMenu.equals("2")) {
				delUser();
			} else if (selMenu.equals("3")) {
				searchUser();
			} else if (selMenu.equals("4")) {
				print();
			} else if (selMenu.equals("5")) {
				login();
			}
		}
	}

	private void login() {
		System.out.println("ID 입력");
		String loginID = sc.nextLine();
		System.out.println("PASSWORD 입력");
		String loginPw = sc.nextLine();
		boolean checkFlag = true;
		for (int i = 0; i < Users.size(); i++) {
			if (Users.get(i).id.equals(loginID)) {
				if (Users.get(i).pw.equals(loginPw)) {
					loginUser = Users.get(i);
					loginUser.menu();
					checkFlag = false;
				} else {
					System.out.println("WRONG PW");
				}
			}
		}
	}

// ***************************************************** Level 1
	private void searchUser() {
		System.out.println("검색할 ID를 입력해주세요");
		String searchID = sc.nextLine();

		for (int i = 0; i < Users.size(); i++) {
			if (Users.get(i).id.equals(searchID)) {
				System.out.println("찾는 값 : " + searchID + "\n" + i + "번째의 값(" + Users.get(i).id + ")을 검색합니다.");
				System.out.println("ID : " + Users.get(i).id);
				System.out.println("PW : " + Users.get(i).pw);
				break;
			}
		}
	}

	private void delUser() {
		System.out.println("삭제할 ID를 입력해주세요");
		String delID = sc.nextLine();

		for (int i = 0; i < Users.size(); i++) {
			if (Users.get(i).id.equals(delID)) {
				System.out.println("찾는 값 : " + delID + "\n" + i + "번째의 값(" + Users.get(i).id + ")을 삭제합니다.");
				Users.remove(i);
				break;
			}
		}
	}

	private void addUser() {
		HumanUser User = new HumanUser(subjectList);
		System.out.println("ID 입력");
		User.id = sc.nextLine();
		System.out.println("PW 입력");
		User.pw = sc.nextLine();
		Users.add(User);
		System.out.println("ID : " + User.id + "PW : " + User.pw);
	}

	public static void menu() {
		System.out.println("1 : ADD USER");
		System.out.println("2 : DELETE USER");
		System.out.println("3 : SEARCH USER");
		System.out.println("4 : PRINT USER");
		System.out.println("5 : LOGIN USER");
	}

	private void print() {
		for (int i = 0; i < Users.size(); i++) {
			System.out.println("ID : " + Users.get(i).id);
			System.out.println("PW : " + Users.get(i).pw);
		}
	}
}
