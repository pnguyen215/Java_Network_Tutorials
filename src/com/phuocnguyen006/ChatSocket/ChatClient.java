package com.phuocnguyen006.ChatSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static final int PORT = 6666;
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			String contents;
			String contentsFromServer;
			Socket socket = new Socket("localhost", PORT);
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			while (true) {
				/*
				 * transfer data to server
				 */
				contents = scanner.nextLine();
				dataOutputStream.writeUTF(contents);
				dataOutputStream.flush();
				/*
				 * break
				 */
				if (contents.equals(" ")) {
					break;
				}
				contentsFromServer = dataInputStream.readUTF();
				System.out.println("Server say: " + contentsFromServer);

			}
			dataInputStream.close();
			dataOutputStream.close();
			socket.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
