package com.phuocnguyen005.Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public final static int PORT = 6666;
	private static ServerSocket serverSocket;

	/*
	 * Server side
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Server ready!");
			serverSocket = new ServerSocket(PORT);
			/*
			 * wait for client send data
			 */
			Socket socket = serverSocket.accept();
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			/*
			 * input from client
			 */
			String string = dataInputStream.readUTF();
			System.out.println(string);
			/*
			 * close connection
			 */
			dataInputStream.close();
			socket.close();
			System.out.println("Close gate connection!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
