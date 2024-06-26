package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for (int i = 0; i < COUNT_GOODS; i++) {
			String productName = scanner.next();
			int price = scanner.nextInt();
			int addStock = scanner.nextInt();

			goods[i] = new Goods(productName, price, addStock);
		}

		// 상품 출력
		for (int i = 0; i < COUNT_GOODS; i++) {
			System.out.println(goods[i].getProductName() + "(가격: "
							 + goods[i].getPrice() + "원)이 "
							 + goods[i].getAddStock() + "개 입고되었습니다.");
		}

		// 자원정리
		scanner.close();
	}
}
