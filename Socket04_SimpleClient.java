package com.socket.exam;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Socket04_SimpleClient {
		
	public static void main(String[] args){
			
		 InputStream is;
		 BufferedReader br;
		 String message=null;
		try{
		Socket s1=new Socket("127.0.0.1",5434);
		is=s1.getInputStream();
		br = new BufferedReader(new InputStreamReader(is)); //서버의 바이트 스트림을 문자로 변환한다.
		message=br.readLine(); //버퍼에 있는 문자를 한줄씩 출력
		System.out.println(message);
		s1.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
