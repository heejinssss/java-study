package prob02;

public class Goods {
	private String productName;
	private int price;
	private int addStock;
	
	Goods(String productName, int price, int addStock) {
		this.productName = productName;
		this.price = price;
		this.addStock = addStock;
	}

	public String getProductName() {
		return productName;
	}

	public int getPrice() {
		return price;
	}

	public int getAddStock() {
		return addStock;
	}
}
