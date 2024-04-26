package exception;

public class ExceptionTest {
	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;

		System.out.println(1);

		try {
			System.out.println(2);
			System.out.println(3);

			int result = (1 + 2 + 3) / b;

			System.out.println(4); // 실행 X
			System.out.println(5); // 실행 X

		} catch (ArithmeticException ex) { // 발생하는 예외 이름을 인자로
			/* 예외 처리 구문 (공란 X) */
//			ex.printStackTrace(); // console 출력

			// 1. 로그 저장
			System.out.println("error: " + ex);

			// 2. 사과
			System.out.println("죄송합니다. 에러가 발생하였습니다.");

			// 3. 정상 종료
//			System.exit(0);
			return;
		} finally {
			System.out.println("자원 정리: ex) close file, socket, db connect");
		}

		System.out.println(6);
		System.out.println(7);
	}
}
