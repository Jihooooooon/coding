package chats;

//package chats;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AboutDialog extends JDialog {
  private static final long serialVersionUID=122487214237L;//JAVA5
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JLabel jLabel1 = new JLabel();
  ImageIcon icon ;
  String title;
  public AboutDialog(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    this.title=title;
    inits();
    this.setSize(new Dimension(280,100));
  }
  public AboutDialog() {
    this(null, "", false);
  }
  private void inits() {
    panel1.setLayout(borderLayout1);
    String imageNums="image/about.png";
    icon = new ImageIcon(chats.ChatClientWindow.class.getResource(imageNums));
    String str=title+": made by Cho, Hyo-eun \r\n";
    jLabel1.setText(str);
        jLabel1.setIcon(icon);
    getContentPane().add(panel1);
    panel1.add(jLabel1, BorderLayout.CENTER);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
   if (frameSize.height > screenSize.height) {
     frameSize.height = screenSize.height;
   }
   if (frameSize.width > screenSize.width) {
     frameSize.width = screenSize.width;
   }
   this.setLocation((screenSize.width - frameSize.width) / 2,
           (screenSize.height - frameSize.height) / 2);
   this.addWindowListener(new WindowAdapter(){
                  public void windowClosing(WindowEvent e){
                        System.out.println("Dialog dispose!");
                        dispose();
                  }
          });
  }
}