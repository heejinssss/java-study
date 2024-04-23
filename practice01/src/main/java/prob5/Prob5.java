package prob5;

public class Prob5 {
	public static void main(String[] args) {

		for (int i = 3; i <= 99; i++) {
			String str = Integer.toString(i);
			String[] arr = str.split("");

			int times = 0;
			for (int j = 0; j < arr.length; j++) {
				int temp = Integer.parseInt(arr[j]);
				if (temp % 3 == 0 & temp != 0) {
					times++;
				}
			}

			if (times > 0) {
				System.out.print(i);
				System.out.print(" ");
				while (times > 0) {
					System.out.print("짝");
					times--;
				}

				System.out.println();
			}
		}
	}
}
