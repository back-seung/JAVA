package newPcBang;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin { // 회원가입 및 로그인 설정
	Scanner sc = new Scanner(System.in);
	ArrayList<User> Users = new ArrayList<>();
	ArrayList<User> loginUsers = new ArrayList<>();
	Manager newM = null;
	User loginUser = null;
	ArrayList<PriceList> prices = null;
	int cnt = 0;

	Admin() { // 생성자
		System.out.println("<< 프로그램 실행 완료 >>");
		while (true) {
			menu();
			String selMenu = sc.nextLine();
			if (selMenu.equals("1")) {
				ManagerRegister();
			} else if (selMenu.equals("2")) {
				ManagerLogin();
			} else if (selMenu.equals("3")) {
				checkTable();
			} else if (selMenu.equals("4")) {
				UserRegister();
			} else if (selMenu.equals("5")) {
				UserLogin();
			}
		}
	}

	private void checkTable() { // 매니저가 생성한 요금표 조회

		System.out.println("<<< \t시\t간\t표\t >>>");
		for (int i = 0; i < prices.size(); i++) {
			System.out.print(prices.get(i).setPrice + "\t");
		}
		System.out.println("");
		for (int i = 0; i < prices.size(); i++) {
			System.out.print(prices.get(i).setTime + "시간\t");
		}
		System.out.println("");
	}

	private void ManagerLogin() { // 매니저 로그인
		System.out.println("ID 입력 : ");
		String inputID = sc.nextLine();
		System.out.println("PW 입력 : ");
		String inputPW = sc.nextLine();
		if (inputID.equals(newM.id) && inputPW.equals(newM.pw)) {
			newM.loginMenu();
			prices = newM.getPrice();

		}
	}

	private void UserLogin() { // 유저 로그인
		Users = newM.getBlacked(); // 기능 실행시 블랙 당할 경우의 Users[]로 최신화
		System.out.println("ID 입력 : ");
		String inputID = sc.nextLine();
		System.out.println("PW 입력 : ");
		String inputPW = sc.nextLine();
		for (int i = 0; i < Users.size(); i++) {
			if (inputID.equals(Users.get(i).id)) {
				if (inputPW.equals(Users.get(i).pw)) {
					loginUser = Users.get(i);
					if (cnt == 0) { // 최초 유저 로그인
						loginUsers.add(loginUser);
						cnt++;
					} else { // 최초 아닌 유저's
						loginCheck(loginUser);
					}
					loginUser.loginMenu();
				}
			}
		}
	}

	private void loginCheck(User loginUser) { // 유저의 로그인 기록을 조회
		for (int i = 0; i < loginUsers.size(); i++) {
			if (loginUsers.get(i).id.equals(loginUser.id)) { // 기록이 있을 때 해당 기록 삭제 후 현재 기록 저장
				loginUsers.remove(i);
				loginUsers.add(loginUser);
			} else { // 없을 때는 그냥 저장
				loginUsers.add(loginUser);
			}
		}
	}

	private void menu() { // 메뉴 출력
		System.out.println("1 : 관리자 회원가입");
		System.out.println("2 : 관리자 로그인");
		System.out.println("3 : 매니저가 생성한 시간표 확인");
		System.out.println("");
		System.out.println("▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶");
		System.out.println("");
		System.out.println("4 : 유저 회원가입");
		System.out.println("5 : 유저 로그인");
	}

	private void ManagerRegister() { // 매니저 회원가입
		newM = new Manager(this.Users, this.loginUsers);
		System.out.println("ID 입력 ⬇");
		newM.id = sc.nextLine();
		System.out.println("PW 입력 ⬇");
		newM.pw = sc.nextLine();
	}

	private void UserRegister() { // 유저 회원가입
		User newU = new User(this.prices);
		System.out.println("ID 입력 ⬇");
		newU.id = sc.nextLine();
		System.out.println("PW 입력 ⬇");
		newU.pw = sc.nextLine();
		Users.add(newU);
		System.out.println(Users);
	}

	public ArrayList<User> getLogined() { // 매니저에게 로그인 기록을 넘겨줌
		return loginUsers;
	}
}
