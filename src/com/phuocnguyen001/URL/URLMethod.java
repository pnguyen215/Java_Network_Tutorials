package com.phuocnguyen001.URL;

import java.io.IOException;
import java.net.URL;

public class URLMethod {

	public void urlMethod() throws IOException {
		URL url = new URL("https://github.com/pnuyen215");
		/*
		 * get protocol
		 */
		System.out.println(url.getProtocol());
		/*
		 * get host
		 */
		System.out.println(url.getHost());
		/*
		 * get port
		 */
		System.out.println(url.getPort());
		/*
		 * get file
		 */
		System.out.println(url.getFile());
		/*
		 * get path
		 */
		System.out.println(url.getPath());
		/*
		 * get Authority
		 */
		System.out.println(url.getAuthority());
		/*
		 *
		 */
		System.out.println(url.getUserInfo());
	}
}
