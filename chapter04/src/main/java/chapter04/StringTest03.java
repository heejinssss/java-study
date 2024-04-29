package chapter04;

public class StringTest03 {
	public static void main(String[] args) {
		// s1과 s2는 연산 방식이 동일
//		String s1 = "Hello" + "World" + " Java " + 17;
//		String s2 = new StringBuffer("Hello")
//						.append("World")
//						.append(" Java ")
//						.append(17)
//						.toString();

//		System.out.println(s1);
//		System.out.println(s2);

		// 실행 결과 출력 시간 초과 (alloc => 가장 오랜 시간이 걸림)
//		String s2 = "";
//		for (int i = 0; i < 1000000; i++) {
//			s2 += "h";
//			s2 = new StringBuffer(s2).append("h").toString();
//		}

		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < 1000000; i++) {
			sb.append("h");
		}
		String s3 = sb.toString();

		// String Methods
		String s4 = "aDcFGHabcAbc";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc", 7)); // 결과 없을 경우 -1
		System.out.println(s4.substring(2));
		System.out.println(s4.substring(2, 5));

		String s5 = "         ab          cd";
		String s6 = "efg,hij,klm,nop,qrs";
		String s7 = s5.concat(s6);
		System.out.println(s7);

		System.out.println("###" + s5.trim() + "###"); // 좌우 공백민 삭제
		System.out.println("###" + s5.replaceAll(" ", "") + "###"); // A 문자를 B 문자로 대체

		String[] tokens = s6.split(",");
		for (String s : tokens) {
			System.out.println(s);
		}

		String[] tokens2 = s6.split(" ");
		for (String s : tokens) {
			System.out.println(s);
		}
	}
}
