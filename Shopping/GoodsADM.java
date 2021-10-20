package Shopping;

import java.util.ArrayList;
import java.util.Scanner;

public class GoodsADM {
	ArrayList<Buyer> Buyers = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	Goods myGoods = new Goods();
	Buyer loginBuyer = null;

	public GoodsADM() {
		System.out.println("환영합니다");
		while (true) {
			menu();
			String selMenu = sc.nextLine();
			if (selMenu.equals("1")) {
				addUser();
			} else if (selMenu.equals("2")) {
				modUser();
			} else if (selMenu.equals("3")) {
				delUser();
			} else if (selMenu.equals("4")) {
				login();
			} else if (selMenu.equals("5")) {
				viewUser();
			}
		}

	}

	private void menu() { // 메뉴
		System.out.println("1. 사용자 등록");
		System.out.println("2. 사용자 수정");
		System.out.println("3. 사용자 삭제");
		System.out.println("4. 로그인");
		System.out.println("5. 사용자 조회");
	}

	private void addUser() { // 사용자 등록
		Buyer B = new Buyer(myGoods);
		System.out.println("ID를 입력해주세요 : ");
		B.id = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요 : ");
		B.pw = sc.nextLine();

		Buyers.add(B);
	}

	private void delUser() { // 사용자 삭제
		System.out.println("삭제할 ID를 입력하세요");
		String delID = sc.nextLine();
		for (int i = 0; i < Buyers.size(); i++) {
			Buyer get = Buyers.get(i);
			if (get != null && delID.equals(get.id)) {
				Buyers.remove(i);
				System.out.println("삭제 완료");
				break;
			}
		}
	}

	private void modUser() { // 사용자 수정
		System.out.println("수정할 ID를 입력하세요");
		String modID = sc.nextLine();
		for (int i = 0; i < Buyers.size(); i++) {
			Buyer get = Buyers.get(i);
			if (get != null && modID.equals(get.id)) {
				System.out.println("수정할 값을 입력하세요");
				get.id = sc.nextLine();
				System.out.println("수정 완료");
				break;
			}
		}
	}

	private void login() { // 로그인
		System.out.println("ID 입력");
		String loginID = sc.nextLine();
		System.out.println("PASSWORD 입력");
		String loginPw = sc.nextLine();
		boolean checkFlag = true;
		for (int i = 0; i < Buyers.size(); i++) {
			if (Buyers.get(i).id.equals(loginID)) {
				if (Buyers.get(i).pw.equals(loginPw)) {
					loginBuyer = Buyers.get(i);
					loginBuyer.menu();
					checkFlag = false;
				} else {
					System.out.println("WRONG PW");
				}
			}
		}
	}

	private void viewUser() {
		for (int i = 0; i < Buyers.size(); i++) {
			Buyer get = Buyers.get(i);
			if (get != null) {
				System.out.println("ID : " + get.id);
				System.out.println("PW : " + get.pw);
				System.out.println("----------------");
			}
		}
	}
}
