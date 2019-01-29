package com.ssafy.edu.j3;


import java.net.*;
import java.io.*;
import java.util.Vector;

public class Server{
	ServerSocket ss;
	Socket s;
	Vector<ServerThread> v;
	public Server(){
		v = new Vector<>(10,10);
	}
	public synchronized void addThread(ServerThread st){
		v.add(st);
	}
	public synchronized void removeThread(ServerThread st){
		v.remove(st);
	}
	public synchronized void broadcast(String str){
		for ( int i = 0 ; i < v.size() ; i++ ){
			ServerThread st1 = v.get(i);
			st1.sendMessage(str);
		}
	}
	public void go(){
		try{
			ss = new ServerSocket(5432);
			ss.setReuseAddress(true);
			System.out.println("1. ready~~~~");
			
			while ( true ){
				s = ss.accept();
				System.out.println("2. Contact ! new Client");
				System.out.println(s.getPort());
				System.out.println(s.getInetAddress());
				System.out.println(s.getLocalAddress());
				ServerThread st = new ServerThread(this, s);
				this.addThread(st);
				st.start();
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	public static void main(String [] args) throws IOException{
		Server server = new Server();
		server.go();
	}
}

class ServerThread extends Thread{
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	String str;
	Server server;

	public ServerThread(Server server,Socket s) throws IOException {
		this.server = server;
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
		System.out.println(s.getInetAddress()+"가 붙음");
	}
	public void sendMessage(String string){
		pw.println(string);
	}
	public void run(){
		try{
			while ( ( str = br.readLine() ) != null ){
				server.broadcast(str);
			}
		}catch (IOException e){
			System.out.println(s.getInetAddress()+"가 나감.");
			server.removeThread(this);
			try{
				s.close();
			}catch (IOException ie){ }
		}
	}
}
