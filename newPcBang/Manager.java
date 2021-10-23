package newPcBang;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager { // 요금 설정, 매출관리, 유저관리(나중에 구현)
	Scanner sc = new Scanner(System.in);
	ArrayList<User> controlUsers = null; // 블랙리스트 유저 삭제
	ArrayList<User> loginUsers = null;
	ArrayList<PriceList> controlPrice = new ArrayList<>();
	String id = null;
	String pw = null;
	int wallet = 0;

	Manager(ArrayList<User> u, ArrayList<User> loginU) {
		this.controlUsers = u;
		this.loginUsers = loginU; // 여기서 말고 removeUser때 받아오는게 맞지 않나 싶음 ㅇㅇ
	}

	public void loginMenu() { // Admin에서 로그인시 출력

		System.out.println("안녕하세요" + id + "관리자님\n");
		while (true) {
			System.out.println("1 . 시간별 요금 생성");
			System.out.println("2 . 현재 매출 조회");
			System.out.println("3 . 블랙리스트 유저 삭제");
			System.out.println("4 . 로그아웃");

			String selMenu = sc.nextLine();
			if (selMenu.equals("1")) {
				addPrice();
			} else if (selMenu.equals("2")) {
				seeWallet();
			} else if (selMenu.equals("3")) {
				removeUser();
			} else if (selMenu.equals("4")) {
				break;
			}
		}
	}

	private void removeUser() {
//		loginUsers = Admin.getLogged(); 이런식으로ㅇㅇ
		System.out.println("삭제할 유저의 아이디를 입력해주세요");
		String delID = sc.nextLine();
		for (int i = 0; i < loginUsers.size(); i++) {
			if (delID.equals(loginUsers.get(i).id)) {
				loginUsers.remove(i);
				System.out.println("삭제완료");
				break;
			} else {
				System.out.println("검색 불가");
				break;
			}
		}
	}

	private void seeWallet() { // 매출 조회
		for (int i = 0; i < loginUsers.size(); i++) {
			wallet += loginUsers.get(0).myP.setPrice;
		}
		System.out.println("오늘의 매출 : " + wallet + "원");
		wallet = 0;
	}

	private void addPrice() { // 요금 설정
		PriceList setCost = new PriceList();
		System.out.println("시간을 입력해주세요");
		setCost.setTime = sc.nextInt();
		System.out.println(setCost.setTime + "시간 : 가격을 지정해주세요");
		setCost.setPrice = sc.nextInt();
		System.out.println("요금 설정 완료");
		controlPrice.add(setCost);
		sc.nextLine();
	}

	public ArrayList<PriceList> getPrice() { // 설정 시간 Admin 제출
		return this.controlPrice;
	}
}
