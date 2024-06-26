package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class ChatClientThread extends Thread {
	private final Reader reader;

	public ChatClientThread(Reader reader) {
		this.reader = reader;
	}

	@Override
	public void run() {
		BufferedReader br = (BufferedReader) reader;
		String msg;

		try {
			while (true) {
				msg = br.readLine();
				if (msg == null) {
					System.out.println("서버 연결 끊김");
					break;
				}

				String[] tokens = msg.split(":", 2);

				if (tokens == null || tokens.length == 0) {
					continue;
				}

				if ("message".equals(tokens[0]) && tokens.length >= 2) {
					System.out.println(tokens[1]);
				} else if ("join:ok".equals(msg)) {
					System.out.println("새로운 유저가 입장하였습니다.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
