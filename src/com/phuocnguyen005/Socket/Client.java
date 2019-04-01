package com.phuocnguyen005.Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public final static int PORT = 6666;
	public static Scanner scanner = new Scanner(System.in);

	/*
	 * Client side
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Client is connected!");
			Socket socket = new Socket("localhost", PORT);
			String contents;
			/*
			 * put data to server
			 */
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			System.out.println("Enter contents, you want to send to server: ");
			contents = scanner.nextLine();
			dataOutputStream.writeUTF(contents);
			dataOutputStream.flush(); /* post data to server */
			/*
			 * close all gate connection
			 */
			dataOutputStream.close();
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
