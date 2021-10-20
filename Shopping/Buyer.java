package Shopping;

import java.util.ArrayList;
import java.util.Scanner;

public class Buyer {
	String id = null;
	String pw = null;
	Goods myGoods = null;
	Scanner sc = new Scanner(System.in);
	ArrayList<String> basket = new ArrayList<>();

	Buyer(Goods g) {
		myGoods = g;
	}

	public void menu() {
		System.out.println("로그인 완료");
		while (true) {
			System.out.println("1. 쇼핑하기");
			System.out.println("2. 장바구니 조회");
			System.out.println("메뉴를 선택하세요");
			String selNum = sc.nextLine();
			if (selNum.equals("1")) {
				shopping();
			} else if (selNum.equals("2")) {
				showBasket();
			} else {
				break;
			}
		}
	}

	public void shopping() {
		String[] list = myGoods.getGoods();
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				System.out.println(i + " : " + list[i]);
			}
		}
		System.out.println("장바구니에 추가할 상품번호를 입력하세요");
		int selNum = sc.nextInt();
		basket.add(list[selNum]);
	}

	public void showBasket() {
		for (int i = 0; i < basket.size(); i++) {
			String get = basket.get(i);
			if (get != null) {
				System.out.println(get);
			}
		}
	}
}
