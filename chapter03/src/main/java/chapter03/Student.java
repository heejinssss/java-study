package chapter03;

public class Student extends Person {
	public Student() {
		/**
		 * 자식 생성자에서 부모 생성자를 명시적으로 호출하지 않으면 자동으로 부모의 기본 생성자를 호출하게 된다.
		 * 부모의 기본 생성자는 자식 생성자보다 반드시 먼저 호출되어야 한다.
		 */
		// super();
		System.out.println("Student called");
		// super()를 호출할 경우 Error 발생
	}
}
