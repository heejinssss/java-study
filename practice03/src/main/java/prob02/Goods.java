package prob02;

public class Goods {
	private String productName;
	private int price;
	private int addStock;
	
	Goods(String pn, int p, int as) {
		productName = pn;
		price = p;
		addStock = as;
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
