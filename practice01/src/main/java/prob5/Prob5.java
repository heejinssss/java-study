package prob5;

public class Prob5 {
	public static void main(String[] args) {

		for (int i = 3; i <= 99; i++) {
			String str = Integer.toString(i);
			String[] arr = str.split("");
			boolean flag = false;

			for (int j = 0; j < arr.length; j++) {
				int temp = Integer.parseInt(arr[j]);
				if (temp % 3 == 0 & temp != 0) {
					flag = true;
				}
			}

			if (flag) {
				System.out.println(i + " 짝");
			}
		}
	}
}
