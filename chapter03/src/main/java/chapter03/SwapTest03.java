package chapter03;

import mypackage.Value;

public class SwapTest03 {
	public static void main(String[] args) {
		Value i = new Value(10);
		Value j = new Value(20);

		System.out.println(i.val + ", " + j.val);

		swap(i, j);

		System.out.println(i.val + ", " + j.val);
	}

	// 객체를 활용하여 변수 값 swap
	private static void swap(Value n1, Value n2) {
		int temp = n1.val;
		n1.val = n2.val;
		n2.val = temp;
	}
}
