package chapter03;

public class Goods {
	public static int countOfGoods = 0;

	private String name;
	private int price;
	private int countStock;
	private int countSold;

	public Goods() {
	}

	public Goods(String name, int price, int countStock, int countSold) {
		// 내부에서는 클래스명 생략해도 에러 없음
		countOfGoods++;

		// 인스턴스 변수 초기화
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price < 0) {
			price = 0;
		}

		this.price = price;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public void showInfo() {
		System.out.println("상품이름 : " + getName() + ", " + "가격 : " + getPrice() + ", " + "재고개수 : " + getCountStock()
				+ ", " + "팔린 개수 : " + getCountSold());
	}

	public int calcDiscountPrice(float percentage) {
		int result = price - (int) (price * percentage);
		return result;
	}
}
