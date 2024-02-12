
package university.management.system;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class TeacherLeave extends JFrame implements ActionListener{
    Choice cempid,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    
    TeacherLeave(){
    
       setSize(500,550);
       setLocation(400,100);
       setLayout(null);
       getContentPane().setBackground(Color.WHITE);
       
       JLabel heading=new JLabel("Apply Leave (Teacher)");
       heading.setBounds(40,50,300,30);
       heading.setFont(new Font("Tahoma",Font.BOLD,20));
       add(heading);
       
       JLabel lblrollno=new JLabel("Search By empID");
       lblrollno.setBounds(60,100,200,20);
       lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
       add(lblrollno);
       
        cempid=new Choice();
        cempid.setBounds(60,130,200,20);
        add(cempid);
        
       
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher");
            while(rs.next()){
            cempid.add(rs.getString("empid"));
            }
            
        }catch(Exception e){e.printStackTrace();}
        
        // Leave Date
       JLabel lbldate=new JLabel("Select Date");
       lbldate.setBounds(60,180,200,20);
       lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
       add(lbldate);
       
       dcdate=new JDateChooser();
       dcdate.setBounds(60,210,200,20);
       add(dcdate);
       
       JLabel lbltime=new JLabel("Time Duration");
       lbltime.setBounds(60,260,200,20);
       lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
       add(lbltime);
       
        ctime=new Choice();
        ctime.setBounds(60,300,200,30);
        ctime.add("Full Day"); 
        ctime.add("Half Day");
        add(ctime); 
        
            //buttons
        submit=new JButton("Submit");
        submit.setBounds(200,350,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
    
        cancel=new JButton("Cancel");
        cancel.setBounds(60,350,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
    
    
    setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource()==submit){
        String rollno=cempid.getSelectedItem();
        String date=((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
        String duration=ctime.getSelectedItem();
        
        String query="insert into teacherleave values('"+rollno+"','"+date+"','"+duration+"')";
        
         try{
            Conn con=new Conn();
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Leave Confirmed");
            setVisible(false);
            
        }catch(Exception e){ e.printStackTrace(); }
            
        }
        else if(ae.getSource()==cancel){
        
            setVisible(false);
        }
        
        
    }
    
    
    public static void main(String[] args){
    
        new TeacherLeave();
    }
    
}
