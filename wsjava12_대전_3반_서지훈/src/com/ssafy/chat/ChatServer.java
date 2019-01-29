package com.ssafy.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ChatServer {
	private final static int PORT=5432;
	ServerSocket ss;
	Socket s;
	ArrayList<ChatServerThread> userList;
	
	
	public ChatServer() {
		userList = new ArrayList<>();
	}
	public synchronized void addThread(ChatServerThread st){
		userList.add(st);
	}
	public synchronized void removeThread(ChatServerThread st){
		userList.remove(st);
	}
	public synchronized void broadcast(String str) {
		for(ChatServerThread user:userList) {
			
			user.sendMessage(str);
		}
	}
	
	public void go() {
		try {
			ss = new ServerSocket(PORT);
			ss.setReuseAddress(true);
			System.out.println("서버가 준비되었습니다.");
			while(true) {
				s= ss.accept();
				System.out.println("["+s.getInetAddress()+"]에서 접속했습니다...");
				ChatServerThread st = new ChatServerThread(this, s);
				this.addThread(st);
				st.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String [] args) throws IOException{
		ChatServer server = new ChatServer();
		server.go();
		
	}
}
class ChatServerThread extends Thread{
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	String str;
	ChatServer server;

	public ChatServerThread(ChatServer server,Socket s) throws IOException {
		this.server = server;
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
		
	}
	public void sendMessage(String string){
		pw.println(string);
	}
	public void run(){
		
		
		String name="";
		try {
			name = br.readLine();
			server.broadcast("#"+name+"님이 대화방에 입장하셨습니다");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try{
			while ( ( str = br.readLine() ) != null ){
				server.broadcast(str);
			}
		}catch (IOException e){
			server.broadcast("#"+name+"이 나가셨습니다.");
			System.out.println(s.getInetAddress()+"가 나감.");
			server.removeThread(this);
			try{
				s.close();
			}catch (IOException ie){ }
		}
	}
}
