package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {
	public static void main(String[] args) {
		Reader in = null;
		InputStream is = null;

		try {
			in = new FileReader("text.txt");
			is = new FileInputStream("text.txt");

			int data = -1;
			int count = 0;
			while ((data = in.read()) != -1) { // data 1개 안에 3byte
				System.out.print((char) data); // char 단위로 캐스팅
				count++;
			}

			System.out.println("");
			System.out.println("텍스트 개수 count: " + count);

			count = 0;
			data = -1;
			while ((data = is.read()) != -1) {
				count++;
			}

			System.out.println("탐색 횟수 count: " + count);

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
