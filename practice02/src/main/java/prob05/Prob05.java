package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("수를 결정하였습니다. 맞추어 보세요.");
		int turn = 1;

		while (true) {

			/* 게임 작성 */

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt(100) + 1;
			boolean flag = true;

			while (flag) {
				System.out.print(turn + "-");
				int userAnswer = scanner.nextInt();

				if (userAnswer > correctNumber) {
					System.out.println("더 낮게");
					turn++;
				} else if (userAnswer < correctNumber) {
					System.out.println("더 높게");
					turn++;
				} else {
					flag = false;
				}
			}

			// 새 게임 여부 확인하기
			System.out.println("맞았습니다.");
			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = scanner.next();
			if ("y".equals(answer) == false) {
				break;
			}
			turn = 1;
		}

		scanner.close();
	}
}
