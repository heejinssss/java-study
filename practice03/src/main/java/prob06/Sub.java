package prob06;

public class Sub implements Operation {
	private int a;
	private int b;

	@Override
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int calculate() {
		return a - b;
	}
}
