
package university.management.system;
import javax.swing.*;
import java.awt.*;

public class About extends JFrame{
    
    About(){
    
        setSize(700,500);
        setLocation(250,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
    
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
     Image i2=i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     image.setBounds(370,0,300,200);
     add(image);   
        
        
    JLabel heading=new JLabel("<html>University<br/>Management System</html>");
    heading.setBounds(70,10,500,100);
    heading.setFont(new Font("serif",Font.BOLD,30));
    add(heading);
        
    JLabel name=new JLabel("Developed  BY: Shaikh Nadim");
    name.setBounds(70,220,300,30);
    name.setFont(new Font("serif",Font.PLAIN,15));
    add(name);
    
    JLabel detail1=new JLabel("BE Production");
    detail1.setBounds(70,240,300,30);
    detail1.setFont(new Font("serif",Font.PLAIN,15));
    add(detail1);
    
    JLabel detail2=new JLabel("Contact: nadimhayatu@gmail.com");
    detail2.setBounds(70,260,300,30);
    detail2.setFont(new Font("serif",Font.PLAIN,15));
    add(detail2);
        
        setVisible(true);
    }
    
    
    public static void main(String [] args){
    
        new About();
    }
    
}
