package prob06;

public abstract class Arith {
	protected int a;
	protected int b;

	public void setValue(int a, int b) {
		this.a = a;
		this.b = a;
	}

	public abstract int calculate();
}