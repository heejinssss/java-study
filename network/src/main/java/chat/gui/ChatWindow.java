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
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.awt.Font;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	private final Socket socket;
	private final PrintWriter pw;
	private final BufferedReader br;

	public ChatWindow(String name, Socket socket, BufferedReader br, PrintWriter pw) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 30);

		this.socket = socket;
		this.br = br;
		this.pw = pw;
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.WHITE);
		buttonSend.setForeground(Color.PINK);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(30);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		Font font_pannel = new Font("Serif", Font.PLAIN, 16);
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		pannel.setFont(font_pannel);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		Font font_textarea = new Font("Serif", Font.BOLD, 16);
		textArea.setEditable(false);
		textArea.setBackground(Color.WHITE);
		textArea.setFont(font_textarea);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		// ChatClientThread 생성
		new ChatClientThread().start();
	}

	// textField의 콘텐츠를 가져오기
	private void sendMessage() {
		String message = textField.getText();

		if ("quit".equals(message)) {
			finish();
			return;

		} else {
			pw.println("message:" + message);
		}

		textField.setText(""); // 채팅 전송 후 입력창 비움
		textField.requestFocus(); // 채팅 전송 후 입력창으로 Cursor 포커스 유지
	}

	private void finish() {
		pw.println("quit");

		// exit java application
		System.exit(0);
	}

	private class ChatClientThread extends Thread {

		public void run() {
			try {
				while (true) {
					String res = br.readLine();
					if (res == null) {
						break;
					}
					updateTextArea(res);
				}
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
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

		private void updateTextArea(String message) {
			if (message != null) {
				textArea.append(message);
				textArea.append("\n");
			} else {
			}
		}
	}
}
