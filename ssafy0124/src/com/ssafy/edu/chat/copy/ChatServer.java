package com.ssafy.edu.chat.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public final static int PORT = 9989;
	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.go();
	}
	public void go() {
		ServerSocket ss =null;
		Socket s = null;
		PrintWriter pw=null;
		try {
			ss = new ServerSocket(PORT);
			ss.setReuseAddress(true);//끊어졌을때 10분동안 못쓰는걸 방지
			BufferedReader br=null;
			
			System.out.println("1. READY~~~~~~");
			//while(true) {
			s=ss.accept();
			System.out.println("2. Contact~~~~");
			System.out.println(s.getPort());
			System.out.println(s.getLocalAddress());
			System.out.println(s.getInetAddress());
		//	}
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw= new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
			String msg="";
			while((msg=br.readLine())!=null) {
				System.out.println(msg);
				pw.println("[s]:"+msg);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(pw!=null) {
				pw.close();
			}
			if(ss!=null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}
