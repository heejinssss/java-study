package mypackage;

public class Goods2 {
	public String name;
	/*
	 * public : can access that class from anywhere
	 */

	protected int price;
	/*
	 * protected : can access that member within the current package and only in the
	 * child class of the outside package
	 */

	int countStock;
	/*
	 * default : can access that class only within the current package
	 */

	private int countSold;
	/*
	 * private : can access them only from within the class
	 */
}
