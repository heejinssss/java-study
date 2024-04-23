package prob4;

import java.util.Scanner;

public class Prob4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();

		String str = text;
		String[] arr = str.split("");

		for (int i = 0; i < text.length(); i++) {
			int idx = 0;
			while (idx <= i) {
				System.out.print(arr[idx]);
				idx += 1;
			}

			System.out.println();
		}

		scanner.close();
	}
}
