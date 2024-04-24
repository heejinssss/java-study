package chapter03;

public class SwapTest02 {
	public static void main(String[] args) {
		int i = 10;
		int j = 20;

		System.out.println(i + ", " + j);

		swap(i, j);

		System.out.println(i + ", " + j);
	}

	// 외부 함수에서 변수 값을 바꿀 수 없음 (swap 함수의 결과로 i와 j가 교차되지 않음)
	private static void swap(int n1, int n2) {
		int temp = n1;
		n1 = n2;
		n2 = temp;
	}
}
