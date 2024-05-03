package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	private String name;
	private Socket socket;
	private PrintWriter pw;

	public ChatWindow(String name, Socket socket, PrintWriter pw) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.name = name;
		this.socket = socket;
		this.pw = pw;

		new ChatClientThread(socket).start();
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.BLACK);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
//				System.out.println("Click");
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
//				System.out.println("****"); // 키보드 입력시 발생
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
//				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
				String request = "quit\r\n";
				pw.println(request);
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();

		// IOStream 받아오기
		// ChatClientThread 생성

	}

	// textField의 콘텐츠를 가져오기
	private void sendMessage() {
//		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
		String message = textField.getText();
//			System.out.println("메시지 보내는 프로토콜 구현 " + message);
		String request = "message:" + message + "\r\n";
		pw.println(request);

		textField.setText(""); // 채팅 전송 후 입력창 비움
		textField.requestFocus(); // 채팅 전송 후 입력창으로 Cursor 포커스 유지

		// ChatClientThread에서 서버로부터 받은 메시지가 있다는 전제 하에
//		updateTextArea("희진: " + message);
	}

//	private void updateTextArea(String message) {
//		textArea.append(message);
//		textArea.append("\n");
//	}

	private class ChatClientThread extends Thread {
		Socket socket = null;

		ChatClientThread(Socket socket) {
			this.socket = socket;
		}

		public void run() {
//			updateTextArea("희진: 임시 종료");
//			String message = br.readLine();
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
				while (true) {
					String msg = br.readLine();
					textArea.append(msg);
					textArea.append("\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

//	private void finish(PrintWriter pw) {
//		// quit 프로토콜 구현
//		try {
//			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
//			String request = "quit\r\n";
//			pw.println(request);
//			System.exit(0);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//
//		// exit java application
//		System.exit(0); // 정상 종료
//	}
}
