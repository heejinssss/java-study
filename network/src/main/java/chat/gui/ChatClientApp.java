package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 6000;

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("대화명을 입력하세요.");
			System.out.print(">> ");
			name = scanner.nextLine();

			if (!name.isEmpty()) {
				break;
			}
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}

		Socket socket = null;

		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			String req = "join:" + name;
			pw.println(req);

			while (true) {
				String res = br.readLine();
				if (res == null) {
					System.out.println("서버 연결 끊김");
					break;
				}
				if ("join:ok".equals(res)) {
					System.out.println(name + "님이 채팅방에 입장하였습니다.");
					new ChatWindow(name, socket, br, pw).show();
					break;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
