package exception;

import java.io.IOException;

public class MyClassTest {
	public static void main(String[] args) {
		try {
			new MyClass().danger();
//		} catch (Exception e) { // 모든 에러 한 번에 처리
		} catch (IOException e) {
			System.out.println("error: " + e);
//			e.printStackTrace(); // stack 상태를 구체적으로 출력
		} catch (MyException e) {
			System.out.println("error: " + e);
//			e.printStackTrace(); // stack 상태를 구체적으로 출력
		}
	}
}