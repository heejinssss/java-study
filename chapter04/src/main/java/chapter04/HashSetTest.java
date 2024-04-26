package chapter04;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set<Rect> set = new HashSet<>();

		Rect r1 = new Rect(10, 20);
		Rect r2 = new Rect(10, 20);

		set.add(r1);
		set.add(r2);

		for (Rect r : set) {
			System.out.println(r);
			/**
			 * chapter04.Rect@2f92e0f4 chapter04.Rect@28a418fc
			 */
		}
	}
}
