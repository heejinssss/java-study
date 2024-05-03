package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
//	private List<ChatServerThread> userList;
	List<PrintWriter> listWriters;

	public ChatServerThread(Socket socket, List<PrintWriter> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			String msg = null;

			while ((msg = br.readLine()) != null) {
				System.out.println(msg);

				String[] tokens = msg.split(":");

				if (tokens[0].equals("join")) {
					doJoin(tokens[1], pw);
					System.out.println("현재 인원: " + listWriters.size());
				} else if (tokens[0].equals("message")) {
					doMessage(tokens[1]);
				} else if (tokens[0].equals("quit")) {
					doQuit(pw);
					break;
				}
			}

		} catch (SocketException e) {
			System.out.println("[ServerError] : " + e);
		} catch (IOException e) {
			System.out.println("[ServerError] : " + e);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("[ServerError] : " + e);
			}
		}
	}

//	public void notifyAllClients(String message) {
//		try {
//			for (ChatServerThread client : listWriters) {
//				PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.socket.getOutputStream()), true);
//				pw.println(message);
//			}
//		} catch (IOException e) {
//			System.out.println("[ServerError] : " + e);
//
//		}
//
//	}

	private void doQuit(PrintWriter writer) {
		removeWriter(writer);
		String data = this.nickname + "님이 퇴장했습니다.";
		broadcast(data);
		System.exit(0);
	}

	private void doJoin(String nickname, PrintWriter writer) {
		this.nickname = nickname;
		String data = nickname + "님이 입장하였습니다";
		broadcast(data);

		addWriter(writer);
	}

	private void doMessage(String data) {
		broadcast(nickname + ":" + data);
	}

	private void addWriter(PrintWriter writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void removeWriter(PrintWriter writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (PrintWriter writer : listWriters) {
				writer.println(data);
				writer.flush();
			}
		}
	}
}
