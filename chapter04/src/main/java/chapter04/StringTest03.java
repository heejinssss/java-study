package chapter04;

public class StringTest03 {
	public static void main(String[] args) {
		// s1과 s2는 연산 방식이 동일
		String s1 = "Hello" + "World" + " Java " + 17;
		String s2 = new StringBuffer("Hello").append("World").append(" Java ").append(17).toString();
		
		System.out.println(s1);
		System.out.println(s2);
	}
}
