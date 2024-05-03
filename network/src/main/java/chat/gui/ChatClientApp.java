package chat.gui;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "0.0.0.0";
	private static final int SERVER_PORT = 6000;

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		// doJoin pw

		while (true) {

			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();

			if (name.isEmpty() == false) {
				break;
			}

			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}

		scanner.close();

		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			pw.println("join:" + name);

			System.out.println("채팅방에 입장하셨습니다.");
			new ChatWindow(name, socket, pw).show();

		} catch (SocketException e) {
			System.out.println("[Client] socket disconnected");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
