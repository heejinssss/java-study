package chapter04;

public class ObjectTest01 {
	public static void main(String[] args) {
		Point point = new Point();

		Class klass = point.getClass(); // reflection;
		System.out.println(klass);            // 출력: class chapter04.Point
		System.out.println(point.hashCode()); // 출력: 798154996 (address 기반의 hash 값)
		System.out.println(point.toString()); // 출력: chapter04.Point@2f92e0f4
											  // getClass().toString() + "@" + hashCode()
		System.out.println(point);            // 출력: chapter04.Point@2f92e0f4
	}
}
