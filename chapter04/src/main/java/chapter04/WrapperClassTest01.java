package chapter04;

public class WrapperClassTest01 {
	public static void main(String[] args) {
//		Integer i = new Integer(10);
//		Character c = new Character("word");
//		Boolean b = new Boolean(true);
		// Deprecated
		// 왜? 직접 생성할 경우 Heap 상에 객체가 존재하게 된다.
		// Literal을 사용하면 JVM 안의 Constant Pool에서 관리하게 된다.
		
		// Auto Boxing
		Integer i1 = 10;
		Integer i2 = 20;
		
		System.out.println(i1 != i2);
		System.out.println(i1.equals(i2));
		
		// Auto Unboxing
		int m = i1 + 10; // (1)
//		int m = i1.intValue() + 10; // (1)과 동일한 코드 
		int n = i2 + 20; // (2)
//		int m = i2.intValue() + 10; // (2)와 동일한 코드
	}
}
