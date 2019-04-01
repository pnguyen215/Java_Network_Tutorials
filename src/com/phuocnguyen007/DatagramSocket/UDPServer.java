package com.phuocnguyen007.DatagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPServer {

	public static final int PORT = 3000;

	public static void main(String[] args) {

		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			InetAddress inetAddress = InetAddress.getByName("localhost");
			String contents = "Hello PhuocNguyen";
			/*
			 * create new UDP
			 */
			DatagramPacket datagramPacket = new DatagramPacket(contents.getBytes(), contents.length(), inetAddress,
					PORT);
			/*
			 * send packet
			 */
			datagramSocket.send(datagramPacket);
			/*
			 * close connection
			 */
			datagramSocket.close();
		} catch (SocketException e) {
			System.out.println(e.getMessage());
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
