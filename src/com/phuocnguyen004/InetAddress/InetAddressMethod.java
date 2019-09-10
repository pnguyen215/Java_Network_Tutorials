package com.phuocnguyen004.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMethod {
	public final String SET_URL = "https://github.com";

	public void inetAddressMethod() throws UnknownHostException {
		InetAddress inetAddress = InetAddress.getByName(SET_URL);

		System.out.println(inetAddress.getHostAddress());
		System.out.println(inetAddress.getHostName());
		System.out.println(inetAddress.getAddress());
	}
}
