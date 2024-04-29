package collection;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<String> s = new Stack<>();

		s.push("하단");
		s.push("중간");
		s.push("상단");

		while (s.isEmpty()) {
			String str = s.pop();
			System.out.println(str);
		}
		
		// Error
//		s.pop();
		
		s.push("하단");
		s.push("중간");
		s.push("상단");
		
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
	}
}
