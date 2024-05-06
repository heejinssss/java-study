package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class ChatServerThread extends Thread {
	private List<Writer> listWriters;
	private String nickname;
	private Socket socket;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			System.out.println("[" + remoteHostAddress + "]" + ":" + remotePort);

			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // auto 플러시 true

			while (true) {
				String request = br.readLine(); // blocking

				if (request == null) {
					System.out.println("클라이언트로부터 연결 끊김");
					doQuit(pw);
					break;
				}

				// 4. 프로토콜 분석
				String[] tokens = request.split(":");
				if ("join".equals((tokens[0]))) {
					doJoin(tokens[1], pw);
				} else if ("message".equals(tokens[0])) {
					if (tokens.length == 1) { // 공백 메시지를 보낼 때는 pass
					} else {
						doMessage(tokens[1]);
					}
				} else if ("quit".equals(tokens[0])) {
					doQuit(pw);
					break;
				} else {
					System.out.println("Error : (" + tokens[0] + ")");
				}

			}
		} catch (SocketException e) {
			System.out.println("[ServerError] : " + e);
			doQuit(pw);
		} catch (IOException e) {
			System.out.println("[ServerError] : " + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);
		String data = "⋆⁺₊⋆ ⋆⁺₊⋆ ★ " + nickname + "님이 퇴장하셨습니다." + " ★⋆⁺₊⋆ ⋆⁺₊⋆";
		broadcast(data);
		try {
			writer.close(); // 해당 클라이언트와의 연결을 닫음
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doJoin(String nickname, Writer writer) {
		PrintWriter pw = (PrintWriter) writer;
		this.nickname = nickname;
		String data = "⋆⁺₊⋆ ⋆⁺₊⋆ ❤ " + nickname + "님이 입장하셨습니다." + " ❤⋆⁺₊⋆ ⋆⁺₊⋆";
		broadcast(data);
		addWriter(writer);
		pw.println("join:ok");
	}

	private void doMessage(String data) {
		Date now = new Date();
		int hour = now.getHours();
		int minute = now.getMinutes();
		int second = now.getSeconds();

		broadcast(nickname + ":" + data + " (" + hour + ":" + minute + ":" + second + ")");
	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}
}
