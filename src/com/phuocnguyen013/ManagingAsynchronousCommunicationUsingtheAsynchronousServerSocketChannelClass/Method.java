package com.phuocnguyen013.ManagingAsynchronousCommunicationUsingtheAsynchronousServerSocketChannelClass;

import java.io.Serializable;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Scanner;
import java.util.concurrent.Future;

public class Method implements Serializable {
	private Scanner scanner = new Scanner(System.in);
	private static final long serialVersionUID = 1L;

	public void service() {
		try {
			AsynchronousSocketChannel asynchronousServerSocketChannel = AsynchronousSocketChannel.open();
			InetSocketAddress address = new InetSocketAddress("localhost", 5000);

			Future<Void> future = asynchronousServerSocketChannel.connect(address);
			System.out.println("Client: waiting for the connection to complete!");
			future.get();
			String message = "";
			while (!message.equals("exit")) {
				System.out.println("Enter a message: ");
				message = scanner.nextLine();
				System.out.println("Client: sending...");
				ByteBuffer byteBuffer = ByteBuffer.wrap(message.getBytes());
				System.out.println("Client: message sent: " + new String(byteBuffer.array()));
				asynchronousServerSocketChannel.write(byteBuffer);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
