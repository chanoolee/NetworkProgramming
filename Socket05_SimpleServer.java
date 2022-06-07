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
		 ServerSocket serverSocket; //���� ���� Ŭ���� ��ü
		 Socket s1=null;
		 InetAddress ipAddrs=null;
		 String connectedClient=null;
		 String outMessage=null;
		try{
			serverSocket= new ServerSocket(5434);
			System.out.println("���� ���� ��... ");
			
			while(true){
				//Ŭ���̾�Ʈ�� ������ ���� �ÿ� accept()�޼ҵ带 ȣ���ؼ� ���� ��ü�� �����Ѵ�.
				//Ŭ���̾�Ʈ�� Ư�� ��Ʈ�� ������ �õ��ϸ� accept�޼ҵ�� ��⸦ Ǯ��  Ŭ���̾�Ʈ�� �����Ű�� Socket Ŭ������ �����Ͽ� ��ȯ
				s1= serverSocket.accept();
				
				os = s1.getOutputStream();//Ŭ���̾�Ʈ�� ����� �������� ���� OutputStream ��ü�� �����´�.
				ipAddrs=s1.getInetAddress();
				
				connectedClient=ipAddrs.toString();//Ŭ���̾�Ʈ�� ip�ּҸ� ���´�.
				bw = new BufferedWriter(new OutputStreamWriter(os));//����Ʈ ��� ��Ʈ���� ����Ǿ� ���� ��� ��Ʈ���� Writer�� ��ȯ��Ű�� ���� ��Ʈ��.
				pw=new PrintWriter(bw,true);
				pw.println(connectedClient+" ���� ������ �����ϼ̽��ϴ�.");
			
				pw.close();
				s1.close();
			}
		}catch(IOException ie){
			ie.printStackTrace();
		}
	}
}
