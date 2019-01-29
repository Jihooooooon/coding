package chats;

//package chats;
import  java.io.*;
import  java.net.*;
import  java.util.*;

public class ChatServer{
   Vector		buffer=new Vector(5,3);
   ServerSocket			serverSocket;
   Socket				socket;
   ObjectInputStream	ois;
   ObjectOutputStream   oos;

   public void service(){
     try{
        System.out.println("���� �غ���");
        serverSocket=new ServerSocket(5200);
        }catch(IOException e){
        System.out.println("���� �غ��߿� IOException �߻�.");
     }
    while(true){
      try{
           socket=serverSocket.accept();
           System.out.println(socket.getInetAddress()+"�� �پ����ϴ�.");
           ois=new ObjectInputStream(socket.getInputStream());
           oos=new ObjectOutputStream(socket.getOutputStream());
           String ip=socket.getInetAddress().toString();
           Thread t=new Thread(new ChatServerThread(buffer,ois,oos));
           t.start();
         }catch(IOException e){
           System.out.println("IOException�� �߻��߽��ϴ�.");
      }
    }
  }

  public static void main(String args[]){
    System.out.println("start Server service...");
    ChatServer cs=new ChatServer();
    cs.service();
  }
}

