package com.phuocnguyen006.ChatSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	public static final int PORT = 6666;
	public static Scanner scanner = new Scanner(System.in);
	private static ServerSocket serverSocket;

	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(PORT);
			/*
			 * wait data from client
			 */
			Socket socket = serverSocket.accept();
			/*
			 * declared thread read data
			 */
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			String contents;
			String contentsFromServer;
			while (true) {
				contents = dataInputStream.readUTF();
				if (contents.equals(" ")) {
					break;
				}
				System.out.println("Client say: " + contents);
				/*
				 * transfer data from server back
				 */
				contentsFromServer = scanner.nextLine();
				dataOutputStream.writeUTF(contentsFromServer);
				dataOutputStream.flush();
			}
			/*
			 * close all gate connection
			 */
			dataInputStream.close();
			dataOutputStream.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
