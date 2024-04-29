package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();

		q.offer("상단");
		q.offer("중간");
		q.offer("하단");

		while (!q.isEmpty()) {
			String s = q.poll();
			System.out.println(s);
		}

//		System.out.println(q.poll()); // null

		q.offer("상단");
		q.offer("중간");
		q.offer("하단");

		System.out.println(q.poll());
		System.out.println(q.peek());
	}
}
