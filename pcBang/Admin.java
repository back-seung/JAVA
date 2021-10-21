package pcBang;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	ArrayList<User> Users = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	price pc = new price();

	Admin() {
		System.out.println("PC방");
		while (true) {
			menu();
			System.out.println("메뉴를 선택해주세요");
			String selMenu = sc.nextLine();
			if (selMenu.equals("1")) {
				register();
			} else if (selMenu.equals("2")) {
				viewPrice();
			} else if (selMenu.equals("3")) {
				viewPrice();
			} else if (selMenu.equals("4")) {
				login();
			}
		}
	}

	private void login() {
		// TODO Auto-generated method stub

	}

	private void viewPrice() {

	}

	private void register() {
		User user = new User();
		System.out.println("이름 입력 : ");
		user.name = sc.nextLine();
		System.out.println("비밀번호 입력 : ");
		user.pw = sc.nextLine();
		Users.add(user);
	}

	private void menu() {
		System.out.println("1. 회원가입");
		System.out.println("2. 시간가격표 보기");
		System.out.println("3. 로그인");

	}
}
