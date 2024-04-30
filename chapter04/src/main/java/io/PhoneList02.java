package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneList02 {
	public static void main(String[] args) {
		Scanner scanner = null;

		try {
			File file = new File("./phone.txt");
			if (!file.exists()) { // file이 존재하지 않으면 에러 처리 전에 프로그램 종료
				System.out.println("File not found.");
				return;
			}

			System.out.println("=== 파일정보 ===");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "Bytes");
			System.out.println(file.lastModified());

			System.out.println("=== 전화번호 ===");
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String name = scanner.next();
				String phone1 = scanner.next();
				String phone2 = scanner.next();
				String phone3 = scanner.next();

				System.out.println(name + ":" + phone1 + "-" + phone2 + "-" + phone3);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
