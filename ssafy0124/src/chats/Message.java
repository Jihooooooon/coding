package chats;

//package chats;
import java.io.*;
import java.util.*;
public class Message implements Serializable{
    private String message; //client�� message�� �����ϴ� ����
    private String name;    //client�� user name�� �����ϴ� ����
    private String ip;
    private int state;      //client�� STATE�� �����ϴ� ����
    private transient ObjectOutputStream oos;//
    private Vector userName;
    public static final int INITCONTACT=0;
    public static final int END=-1;
    public static final int PROGRESS=1;
    public Message(String name,String message,int state,ObjectOutputStream o){
      this.name=name;
      this.message=message;
      this.state=state;
      this.oos=oos;
    }
    public Message(String name,String message,int state){
      this(name,message,state,null);
    }
    public String getMessage(){
      return message;
    }
    public void setMessage(String s){
      message=s;
    }
    public String getName(){
      return name;
    }
    public void setName(String s){
      name=s;
    }
    public int getState(){
      return state;
    }
    public void setState(int i){
      state=i;
    }
    public ObjectOutputStream getObjectStream(){
      return oos;
    }
    public void setObjectStream(ObjectOutputStream o){
      oos=o;
    }
    public Vector getUserName(){
      return this.userName;
    }
    public void setUserName(Vector v){
      this.userName=v;
    }

    public String getIp() {
      return ip;
    }

    public void setIp(String ip) {
      this.ip = ip;
    }
}



