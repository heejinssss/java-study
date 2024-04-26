package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException {
		System.out.println(1);
		System.out.println(2);

		// if 조건에 넣지 않으면 이후 코드는 Dead Code
		if (true) {			
			throw new IOException();
		}

		System.out.println(3);
		System.out.println(4);
	}
}
