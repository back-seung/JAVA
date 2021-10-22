package pcBang;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	ArrayList<User> Users = new ArrayList<>();
	ArrayList<User> loginUsers = new ArrayList<>();
	ArrayList<priceList> prices = new ArrayList<>();
	User loginUser = null;
	Scanner sc = new Scanner(System.in);
	int wallet = 0;
	int cnt = 0;
	String adminPW = "admin";

	Admin() {
		System.out.println("<< 백승한초롱 PC방 >>");
		System.out.println("");
		while (true) {
			adminMenu();
			System.out.println("");
			System.out.println("메뉴를 선택해주세요");
			String selMenu = sc.nextLine();
			if (selMenu.equals("1")) {
				addPrice();
			} else if (selMenu.equals("2")) {
				seeWallet();
			} else if (selMenu.equals("3")) {
				register();
			} else if (selMenu.equals("4")) {
				login();
			}
		}
	}

	private void seeWallet() {
		System.out.println("ADMIN 비밀번호 입력 : ");
		String inputPw = sc.nextLine();
		if (inputPw.equals(adminPW)) {
			for (int i = 0; i < loginUsers.size(); i++) {
				wallet += loginUsers.get(i).myList.price;
			}

			System.out.println("사장님 지갑 : " + wallet);
			wallet = 0;
		} else {
			System.out.println("ERROR ! : 비밀번호 다름");
		}
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
					if (cnt == 0) { // 최초 로그인 유저
						loginUsers.add(loginUser);
						cnt++;
					} else {
						loginCheck(loginUser);
					}
					loginUser.menu();
				}
			}
		}
	}

	private void loginCheck(User loginUser) {

		for (int i = 0; i < loginUsers.size(); i++) {
			if (loginUsers.get(i).name.equals(loginUser.name)) {
				loginUsers.remove(i);
				loginUsers.add(loginUser);
			} else {
				loginUsers.add(loginUser);
			}
		}
	}

	private void addPrice() {
		System.out.println("ADMIN 비밀번호 입력 : ");
		String inputPw = sc.nextLine();
		priceList myP = new priceList();
		if (inputPw.equals(adminPW)) {
			System.out.println("가격 입력");
			myP.price = sc.nextInt();
			System.out.println("시간 입력");
			myP.time = sc.nextInt();
			sc.nextLine();
			prices.add(myP);
			System.out.println("가격 : " + prices.get(0).price + "원");
			System.out.println("시간 : " + prices.get(0).time + "시간");
		} else {
			System.out.println("ERROR ! : 비밀번호 다름");
		}
	}

	private void register() {
		User user = new User(this.prices);
		System.out.println("이름 입력 : ");
		user.name = sc.nextLine();
		System.out.println("휴대폰 뒷번호 4자리 입력 : ");
		user.pw = sc.nextLine();
		System.out.println("010-XXXX-" + user.pw + "가 맞습니까?");
		sc.nextLine();
		Users.add(user);
	}

	private void adminMenu() {
		System.out.println("ADMIN MENU");
		System.out.println("1. 요금책정 💰");
		System.out.println("2. 지갑보기 💸");
		System.out.println("");
		System.out.println("USER MENU");
		System.out.println("3. 회원가입 👱‍");
		System.out.println("4. 접속하기 🔑");

	}
}
