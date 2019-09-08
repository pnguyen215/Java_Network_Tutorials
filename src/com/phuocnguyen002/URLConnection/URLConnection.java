package com.phuocnguyen002.URLConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLConnection {

	public void urlConnectionTest() throws IOException {
		URL url = new URL("https://github.com/pnguyen215");
		java.net.URLConnection urlConnection = url.openConnection();
		InputStream inputStream = urlConnection.getInputStream();
		int word = inputStream.read();
		while (word != -1) {
			System.out.print((char) word);
			word = inputStream.read();
		}
	}
}
