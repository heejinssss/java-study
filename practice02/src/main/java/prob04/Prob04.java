package prob04;

public class Prob04 {
	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);

		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}

	public static char[] reverse(String str) {
		char[] arr = str.toCharArray();
		int size = arr.length;
		char[] reverseArr = new char[size];

		int idx = 0;
		for (int i = size - 1; i >= 0; i--) {
			reverseArr[idx] = arr[i];
			idx++;
		}
		return reverseArr;
	}

	public static void printCharArray(char[] array) {
		/* 코드를 완성합니다 */
		System.out.println(array);
	}
}
