package com.phuocnguyen003.HTTPURLConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPURLConnection {
	public final String SET_URL = "https://trungtamjava.com/";

	public void httpUrlTest() throws IOException {
		URL url = new URL(SET_URL);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		for (int i = 0; i < httpURLConnection.getHeaderFields().size(); i++) {
			System.out.println(httpURLConnection.getHeaderFieldKey(i) + " " + httpURLConnection.getHeaderField(i));
		}
	}
}
