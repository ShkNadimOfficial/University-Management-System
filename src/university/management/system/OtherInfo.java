
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class OtherInfo extends JFrame implements ActionListener{
    JButton ok;
    OtherInfo(){
    
        setSize(600,300);
        setLocation(200,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading=new JLabel("Other Information");
        heading.setBounds(10,10,200,20);
        heading.setFont(new Font("serif",Font.BOLD,16));
        add(heading);
        
        JLabel detail=new JLabel("Contact: Visit SPPU Official website for more Information");
        detail.setBounds(10,40,500,20);
        detail.setFont(new Font("serif",Font.PLAIN,20));
        add(detail);
        
        JLabel detail3=new JLabel("Website: http://www.unipune.ac.in");
        detail3.setBounds(10,80,400,20);
        detail3.setFont(new Font("serif",Font.BOLD,16));
        add(detail3);
        
        JLabel detail2=new JLabel("Thank you");
        detail2.setBounds(10,180,200,20);
        detail2.setFont(new Font("serif",Font.BOLD,16));
        add(detail2);
        
        ok=new JButton("OK");
        ok.setBounds(400,150,100,30);
        ok.addActionListener(this);
        ok.setBackground(Color.BLACK);
        ok.setForeground(Color.WHITE);
        add(ok);

        
        setVisible(true);
    }
    
    public static void main(String[] args){
    
        new OtherInfo();
    }
    
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource()==ok){
        setVisible(false);
        }
    }
    
    
}
