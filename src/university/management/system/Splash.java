
package university.management.system;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
    Image i2=i1.getImage().getScaledInstance(900, 650, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    add(image);
    setVisible(true);
    
    t=new Thread(this);
    t.start();
    
    setSize(900,650);
    setLocation(200,30);
 
    }
    
    public static void main(String[] args){
    new Splash(); //anonymous object
    }
    
    public void run(){
            try{
          Thread.sleep(2000);
          setVisible(false);
          new Login();
            }catch (Exception e){}
    }
    
}
