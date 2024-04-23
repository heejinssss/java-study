package prob3;

import java.util.Scanner;

public class Prob3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("숫자를 입력하세요. : ");
		int number = scanner.nextInt();

		int temp = number;
		int total = 0;

		while (temp > 0) {
			total += temp;
			temp -= 2;
		}

		System.out.println(total);

		scanner.close();
	}
}
