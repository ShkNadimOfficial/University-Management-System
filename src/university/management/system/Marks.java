
package university.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;




public class Marks extends JFrame implements ActionListener{
    String rollno;
    JButton cancel;
    Marks(String rollno){
      
        this.rollno=rollno;
        
        setSize(500,600);
        setLocation(300,50);
        setLayout(null);
        
    getContentPane().setBackground(Color.WHITE);
        
    JLabel heading=new JLabel("Savitribai Phule University");
    heading.setBounds(70,10,500,50);
    heading.setFont(new Font("serif",Font.BOLD,30));
    add(heading);
    
    JLabel subheading=new JLabel("Result of Examination");
    subheading.setBounds(150,50,500,50);
    subheading.setFont(new Font("serif",Font.BOLD,20));
    add(subheading);
    
    JLabel lblrollno=new JLabel("Roll Number: "+rollno);
    lblrollno.setBounds(50,100,500,50);
    lblrollno.setFont(new Font("serif",Font.BOLD,20));
    add(lblrollno);
    
    JLabel lblsemester=new JLabel("");
    lblsemester.setBounds(50,130,500,50);
    lblsemester.setFont(new Font("serif",Font.BOLD,20));
    add(lblsemester);
    
    JLabel sub1=new JLabel("Subject 1");
    sub1.setBounds(50,180,500,50);
    sub1.setFont(new Font("serif",Font.PLAIN,16));
    add(sub1);
     
    JLabel sub2=new JLabel("Subject 1");
    sub2.setBounds(50,200,500,50);
    sub2.setFont(new Font("serif",Font.PLAIN,16));
    add(sub2);
     
    JLabel sub3=new JLabel("Subject 1");
    sub3.setBounds(50,220,500,50);
    sub3.setFont(new Font("serif",Font.PLAIN,16));
    add(sub3);
     
    JLabel sub4=new JLabel("Subject 1");
    sub4.setBounds(50,240,500,50);
    sub4.setFont(new Font("serif",Font.PLAIN,16));
    add(sub4);
     
    JLabel sub5=new JLabel("Subject 1");
    sub5.setBounds(50,260,500,50);
    sub5.setFont(new Font("serif",Font.PLAIN,16));
    add(sub5);
    
    try{
    
        Conn c=new Conn();
        ResultSet rs1=c.s.executeQuery("select * from subject where rollno='"+rollno+"'");
        while(rs1.next()){
            sub1.setText(rs1.getString("subject1"));
            sub2.setText(rs1.getString("subject2"));
            sub3.setText(rs1.getString("subject3"));
            sub4.setText(rs1.getString("subject4"));
            sub5.setText(rs1.getString("subject5"));
           }
        ResultSet rs2=c.s.executeQuery("select * from marks where rollno='"+rollno+"'");
        while(rs2.next()){
            sub1.setText(sub1.getText()+"---------"+rs2.getString("marks1"));
            sub2.setText(sub2.getText()+"---------"+rs2.getString("marks2"));
            sub3.setText(sub3.getText()+"---------"+rs2.getString("marks3"));
            sub4.setText(sub4.getText()+"---------"+rs2.getString("marks4"));
            sub5.setText(sub5.getText()+"---------"+rs2.getString("marks5"));
            lblsemester.setText("Semester "+rs2.getString("semester"));
            
        }
        
        
        
    }catch(Exception e){  e.printStackTrace();}
    
    
    cancel=new JButton("Cancel");
    cancel.setBounds(200,350,100,30);
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.addActionListener(this);
    add(cancel);
     
    
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource()==cancel){
        
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Marks("");
    }
    
}
