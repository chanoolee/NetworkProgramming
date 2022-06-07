package com.socket.exam;

import java.net.URL;

public class Socket02_Url {

	public static void main(String[] args) throws Exception {
		
		String path = "http://www.google.com:8080";
		path += "/depth1/page.jsp?param1=%EA%B0&921#123&param2=rkqt2";
		URL url = new URL(path);
		
		System.out.println("URL 함수");
		print("전체경로", path);
		print("getProtocol", url.getProtocol());
		print("getHost", url.getHost());
		print("getPort", url.getPort());
		print("getPath", url.getPath());
		print("getFile", url.getFile());
		print("getQuery", url.getQuery());
		print("getAuthority", url.getAuthority());
		print("getRef", url.getRef());
		print("getDrfaultPort", url.getDefaultPort());
		print("toExternalForm", url.toExternalForm());
		System.out.println();
		
	}

	public static void print(String name, Object value) {
		System.out.println("[" + name + "] = \t" + value);
	}

}