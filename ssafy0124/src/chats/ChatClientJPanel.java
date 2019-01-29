package chats;

//package chats;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.event.*;
public class ChatClientJPanel extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel np = new JPanel();
  JPanel cp = new JPanel();
  JPanel ep = new JPanel();
  JPanel sp = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JLabel stateLb = new JLabel();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel cnp = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  BorderLayout borderLayout5 = new BorderLayout();
  JLabel chatLb = new JLabel("Chatting Message", JLabel.CENTER);
  BorderLayout borderLayout6 = new BorderLayout();
  JLabel userLb = new JLabel("Chatting Message", JLabel.CENTER);
  JPanel ccp = new JPanel();
  BorderLayout borderLayout7 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea chatTextArea = new JTextArea();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  TitledBorder titledBorder3;
  TitledBorder titledBorder4;
  JPanel ecp = new JPanel();
  JPanel esp = new JPanel();
  JScrollPane jScrollPane2 = new JScrollPane();
  BorderLayout borderLayout8 = new BorderLayout();
  JList userList = new JList();
  BorderLayout borderLayout9 = new BorderLayout();
  JPanel essp = new JPanel();
  BorderLayout borderLayout10 = new BorderLayout();
  JLabel userCountLb = new JLabel();
  JLabel whoContacLb = new JLabel();
  JTextField sendTf = new JTextField(40);
  JButton sendButton = new JButton();
  TitledBorder titledBorder5;
  TitledBorder titledBorder6;
  TitledBorder titledBorder7;
  TitledBorder titledBorder8;
  TitledBorder titledBorder9;
  TitledBorder titledBorder10;
  TitledBorder titledBorder11;
  TitledBorder titledBorder12;
  TitledBorder titledBorder13;
  TitledBorder titledBorder14;
  TitledBorder titledBorder15;
  Socket socket;
  ObjectInputStream     ois;
  ObjectOutputStream    oos;
  Thread            t;
  ChatClientThread cct;
  String name;
  String ip;
  int port;
  JFrame jframe;
  public JList getUserList(){
    return userList;
  }
  public JLabel getUserCountLb(){
    return userCountLb;
  }
  public JTextArea getChatTextArea(){
    return chatTextArea;
  }

  public ChatClientJPanel(JFrame jframe) {
    this.jframe=jframe;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    titledBorder3 = new TitledBorder("");
    titledBorder4 = new TitledBorder("");
    titledBorder5 = new TitledBorder("");
    titledBorder6 = new TitledBorder("");
    titledBorder7 = new TitledBorder("");
    titledBorder8 = new TitledBorder("");
    titledBorder9 = new TitledBorder("");
    titledBorder10 = new TitledBorder("");
    titledBorder11 = new TitledBorder("");
    titledBorder12 = new TitledBorder("");
    titledBorder13 = new TitledBorder("");
    titledBorder14 = new TitledBorder("");
    titledBorder15 = new TitledBorder("");
    this.setLayout(borderLayout1);
    np.setLayout(borderLayout2);
    stateLb.setFont(new java.awt.Font("Arial", 1, 15));
    stateLb.setForeground(Color.black);
    stateLb.setBorder(titledBorder15);
    stateLb.setText("Connect to the Server-   User ID : ");
    cnp.setLayout(borderLayout4);
    cp.setLayout(borderLayout5);
    chatLb.setFont(new java.awt.Font("Dialog", 1, 20));
    chatLb.setAlignmentY((float) 0.5);
    chatLb.setBorder(titledBorder12);
    ep.setLayout(borderLayout6);
    userLb.setAlignmentY((float) 0.5);
    userLb.setBorder(titledBorder14);
    userLb.setFont(new java.awt.Font("Dialog", 1, 20));
    ccp.setLayout(borderLayout7);
    chatTextArea.setBorder(BorderFactory.createLineBorder(Color.black));
    chatTextArea.setEditable(false);
    chatTextArea.setText("");
    jScrollPane1.setForeground(Color.black);
    jScrollPane1.setBorder(titledBorder2);
    ecp.setLayout(borderLayout8);
    esp.setLayout(borderLayout9);
    essp.setLayout(borderLayout10);
    userCountLb.setFont(new java.awt.Font("Arial", 1, 13));
    userCountLb.setToolTipText("");
    userCountLb.setText("Current User Counts: 0                 ");
    whoContacLb.setFont(new java.awt.Font("Arial", 1, 13));
    whoContacLb.setPreferredSize(new Dimension(69, 30));
    whoContacLb.setText("No Select");
    sendTf.setBorder(BorderFactory.createLineBorder(Color.black));
    sendTf.setToolTipText("Please input message");
    sendTf.setText("");
    sendButton.setText("Send Message");
    ep.setPreferredSize(new Dimension(258, 196));
    ecp.setBorder(titledBorder6);
    ecp.setPreferredSize(new Dimension(200, 100));
    sp.setBorder(BorderFactory.createEtchedBorder());
    esp.setBorder(titledBorder10);
    ccp.setBorder(titledBorder8);
    userList.setBorder(BorderFactory.createLineBorder(Color.black));
    userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    userList.addListSelectionListener(new ChatClientJPanel_userList_listSelectionAdapter(this));
    cp.add(cnp,  BorderLayout.NORTH);
    cnp.add(chatLb,  BorderLayout.NORTH);
    cp.add(ccp, BorderLayout.CENTER);
    ep.add(userLb, BorderLayout.NORTH);
    ep.add(ecp,  BorderLayout.CENTER);
    ep.add(esp,  BorderLayout.SOUTH);
    sp.add(sendTf, null);
    np.add(stateLb,  BorderLayout.CENTER);
    ccp.add(jScrollPane1,  BorderLayout.CENTER);
    jScrollPane1.getViewport().add(chatTextArea, null);
    ecp.add(jScrollPane2,  BorderLayout.CENTER);
    jScrollPane2.getViewport().add(userList, null);
    esp.add(essp, BorderLayout.WEST);
    essp.add(userCountLb,  BorderLayout.SOUTH);
    essp.add(whoContacLb, BorderLayout.NORTH);
    sp.add(sendButton, null);
    sendButton.addActionListener(new Handler());
    sendTf.addActionListener(new Handler());
    setServerIP();
    this.add(np, BorderLayout.NORTH);
    this.add(cp,  BorderLayout.CENTER);
    this.add(ep,  BorderLayout.EAST);
    this.add(sp,  BorderLayout.SOUTH);
  }
  //�����ʰ� �����ϴ� �޼���
   public void connection(String serverName,int port) throws IOException{
     socket = new Socket(serverName, port);
     System.out.println("Connect to "+serverName);

     oos = new ObjectOutputStream(socket.getOutputStream());
     ois = new ObjectInputStream(socket.getInputStream());

     System.out.println("Server Ready : Writing");
     Message mess = new Message(name, "���� �����ϼ̽��ϴ�.", Message.INITCONTACT);
     mess.setIp(socket.getInetAddress().toString());
     oos.writeObject(mess);

     System.out.println("Server Ready : Reading");
     cct = new ChatClientThread(ois, this);
     t = new Thread(cct);
     t.start();
   }
   public void disConnection() {
     try{
       Message d=new Message(name,"���� ��������.",Message.END);
       oos.writeObject(d);
      }catch(IOException e){}
      t=null;
  }
  public void setIpPort(String ip, int port,String name){
    this.ip = ip;
    this.port = port;
    this.name=name;
  }
  public void setServerIP(){
    ChattingEnteranceDialog di=
    new ChattingEnteranceDialog(jframe,this,"Welcom Dialog", true);
    di.setVisible(true);
    try{
       connection(ip,5200);
     }catch(IOException e1){
       System.out.println("connection �� Exception�� �߻��߽��ϴ�.");
    }
     this.stateLb.setText("Connection to "+ip+" ,  UserID: "+name);
  }
        //��ư�� �̺�Ʈ ó���� ������ inner-class
  public class Handler implements ActionListener{
       public void actionPerformed(ActionEvent e){
         if (e.getSource() == sendButton || e.getSource() == sendTf) {
           try {
             oos.writeObject(new Message(name, sendTf.getText(), Message.PROGRESS));
           }
           catch (IOException e2) {
             System.out.println("Communication IOEXception Occurs.");
           }
           sendTf.setText("");
         } //if
      }//actionperformed
  }

  void userList_valueChanged(ListSelectionEvent e) {
     whoContacLb.setText((String)userList.getSelectedValue());
  }/////inner class
}

class ChatClientJPanel_userList_listSelectionAdapter implements javax.swing.event.ListSelectionListener {
  ChatClientJPanel adaptee;

  ChatClientJPanel_userList_listSelectionAdapter(ChatClientJPanel adaptee) {
    this.adaptee = adaptee;
  }
  public void valueChanged(ListSelectionEvent e) {
    adaptee.userList_valueChanged(e);
  }
}
