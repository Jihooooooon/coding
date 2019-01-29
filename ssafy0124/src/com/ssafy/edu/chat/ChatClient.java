package com.ssafy.edu.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class ChatClient {
	public final static int PORT = 9958;
	public final static String IP="127.0.0.1";
	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		client.go();
	}
	public void go() {
		Socket s =null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			s = new Socket(IP, PORT);
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
			String msg="";
			while((msg=br.readLine())!=null) {
				//System.out.println(msg);
				pw.println(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pw!=null) {
				pw.close();
			}
			if(s!=null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
