package com.phuocnguyen008.URLProcessing;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		Method method = new Method();
		try {
			method.URLConnectionsMethod();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
