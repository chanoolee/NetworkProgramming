package com.socket.exam;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Socket05_SimpleServer {
	
	public static void main(String[] args){
		 
		 BufferedWriter bw;
		 PrintWriter pw=null;
		 OutputStream os;
		 ServerSocket serverSocket; //서버 소켓 클래스 객체
		 Socket s1=null;
		 InetAddress ipAddrs=null;
		 String connectedClient=null;
		 String outMessage=null;
		try{
			serverSocket= new ServerSocket(5434);
			System.out.println("서버 실행 중... ");
			
			while(true){
				//클라이언트의 접속을 인지 시에 accept()메소드를 호출해서 소켓 객체를 생성한다.
				//클라이어트가 특정 포트로 접속을 시도하면 accept메소드는 대기를 풀고  클라이언트와 연결시키는 Socket 클래스를 생성하여 반환
				s1= serverSocket.accept();
				
				os = s1.getOutputStream();//클라이언트랑 연결된 소켓으로 부터 OutputStream 객체를 가져온다.
				ipAddrs=s1.getInetAddress();
				
				connectedClient=ipAddrs.toString();//클라이언트의 ip주소를 얻어온다.
				bw = new BufferedWriter(new OutputStreamWriter(os));//바이트 출력 스트림에 연결되어 문자 출력 스트림인 Writer로 변환시키는 보조 스트림.
				pw=new PrintWriter(bw,true);
				pw.println(connectedClient+" 에서 서버에 접속하셨습니다.");
			
				pw.close();
				s1.close();
			}
		}catch(IOException ie){
			ie.printStackTrace();
		}
	}
}
