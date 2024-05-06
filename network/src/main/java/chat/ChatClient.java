package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 6000;

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;

		try {
			scanner = new Scanner(System.in);
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			System.out.println("닉네임을 입력하세요>>");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);
			
			new ChatClientThread(br).start();
			
//			String confirm = br.readLine();
//
//			if (confirm.equals("입장: 확인")) {
//				System.out.println("채팅방에 입장했어요.");
//
//			}

			while (true) {
				String msg = scanner.nextLine();

				if (msg.toLowerCase().equals("quit")) {
					System.out.println("채팅을 종료합니다.");
					break;
				} else {
					pw.println("message:" + msg);
				}
			}
		} catch (ConnectException e) {
			System.out.println("Socket Exception : " + e);
		} catch (IOException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (socket != null && socket.isClosed()) {
					socket.close();
				}
				if (scanner != null) {
					scanner.close();
				}					
			} catch (IOException e) {
				System.out.println("Error] : " + e);
			}
		}
	}
}
