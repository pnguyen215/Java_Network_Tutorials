package com.phuocnguyen008.URLProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Method {

	public void URLConnectionsMethod() throws IOException {
		String httpURL = "";
		String urlCurrent;
		URL url = new URL("https://github.com/pnguyen215");
		/* open connection throw URL */
		URLConnection urlConnection = url.openConnection();

		HttpURLConnection httpURLConnection = null;

		/*
		 * check URLConnection is HttpURLConnection
		 */
		if (urlConnection instanceof HttpURLConnection) {
			httpURLConnection = (HttpURLConnection) urlConnection;

		} else {
			System.out.println("Please, enter an HTTP URL!");
			return;
		}
		/*
		 *
		 */
		InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		/*
		 *
		 */
		while ((urlCurrent = bufferedReader.readLine()) != null) {
			httpURL += urlCurrent;
		}
		System.out.println(httpURL);
	}
}
