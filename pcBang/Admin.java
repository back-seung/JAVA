package pcBang;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	ArrayList<User> Users = new ArrayList<>();
	User loginUser = null;
	ArrayList<priceList> prices = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	int wallet = 0;

	Admin() {
		System.out.println("PC방");
		System.out.println("사장님 지갑 : " + wallet);
		while (true) {
			menu();
			System.out.println("메뉴를 선택해주세요");
			String selMenu = sc.nextLine();
			if (selMenu.equals("1")) {
				register();
			} else if (selMenu.equals("2")) {
				addPrice();
			} else if (selMenu.equals("3")) {
				login();
			} else if (selMenu.equals("4")) {
				seeWallet();
			} else if (selMenu.equals("5")) {
				// 아직 기능 없음
			}
		}
	}

	private void seeWallet() {
		wallet = loginUser.myList.price;
		System.out.println("사장님 지갑 : " + wallet);
	}

	private void login() {
		System.out.println("이름 입력");
		String inputID = sc.nextLine();
		System.out.println("비밀번호 입력");
		String inputPW = sc.nextLine();
		for (int i = 0; i < Users.size(); i++) {
			if (inputID.equals(Users.get(i).name)) {
				if (inputPW.equals(Users.get(i).pw)) {
					loginUser = Users.get(i);
					loginUser.menu();
				}
			}
		}

	}

	private void addPrice() {
		priceList myP = new priceList();

		System.out.println("가격 입력");
		myP.price = sc.nextInt();
		System.out.println("시간 입력");
		myP.time = sc.nextInt();
		sc.nextLine();
		prices.add(myP);
		System.out.println("가격 : " + prices.get(0).price);
		System.out.println("시간 : " + prices.get(0).time);
	}

	private void register() {
		User user = new User(prices, wallet);
		System.out.println("이름 입력 : ");
		user.name = sc.nextLine();
		System.out.println("휴대폰 뒷번호 4자리 입력 : ");
		user.pw = sc.nextLine();
		System.out.println("010-XXXX-" + user.pw + "가 맞습니까?");
		sc.nextLine();
		Users.add(user);
	}

	private void menu() {
		System.out.println("1. 회원가입");
		System.out.println("2. 시간표 책정하기");
		System.out.println("3. 로그인");
		System.out.println("4. 지갑보기 - 사장님꺼");

	}
}
