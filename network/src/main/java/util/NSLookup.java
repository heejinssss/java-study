package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {
	public static void main(String[] args) {
		Scanner scanner = null;

		try {
			scanner = new Scanner(System.in);
			String url = scanner.next();

			if ("quit".equals(url)) {
				System.out.println("시스템 종료");
				System.exit(0);
			}

			InetAddress[] InetAddresses = InetAddress.getAllByName(url);

			for (InetAddress InetAddress : InetAddresses) {
				System.out.println(InetAddress);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		scanner.close();
	}
}
