package chapter04;

public class ObjectTest03 {
	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");

		System.out.println(s1 == s2); // false
		System.out.println(s1.equals(s2)); // true
		System.out.println(s1.hashCode() + " : " + s2.hashCode());
		System.out.println(System.identityHashCode(s1)); // address 기반 hash 값 989110044
		System.out.println(System.identityHashCode(s2)); // address 기반 hash 값 424058530

		System.out.println("===================================");

		// String 객체를 만들 때 new String이 아닌, Literal을 써야하는 이유
		String s3 = "hello";
		String s4 = "hello";

		System.out.println(s3 == s4); // true
		System.out.println(s3.equals(s4)); // true
		System.out.println(s3.hashCode() + " : " + s4.hashCode()); // 99162322 : 99162322
		System.out.println(System.identityHashCode(s3)); // 321001045
		System.out.println(System.identityHashCode(s4)); // 321001045
	}
}
