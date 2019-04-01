package com.phuocnguyen007.DatagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {
	public static final int PORT = 3000;

	public static void main(String[] args) {

		try {
			InetAddress inetAddress = InetAddress.getByName("localhost");
			DatagramSocket datagramSocket = new DatagramSocket(PORT, inetAddress);
			byte[] buffer = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
			/*
			 * receive packet from server
			 */
			datagramSocket.receive(datagramPacket);
			String contents = new String(datagramPacket.getData(), 0, buffer.length);
			/*
			 * output to screen
			 */
			System.out.println(contents);
			datagramSocket.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (SocketException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
