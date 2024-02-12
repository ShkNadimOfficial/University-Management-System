
package university.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;

public class EnterMarks extends JFrame implements ActionListener {
    Choice crollno;
    JComboBox  cbsemester;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    JButton submit,cancel;
    EnterMarks(){
    
        setSize(900,650);
        setLocation(150,20);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,40,400,300);
        add(image);
        
        // heading
    JLabel heading=new JLabel("Enter Marks of Students");
    heading.setBounds(50,0,500,40);
    heading.setFont(new Font("serif",Font.BOLD,30));
    add(heading);
    
    JLabel lblrollnumber=new JLabel("Select By Roll No");
        lblrollnumber.setBounds(50,100,150,20);
        add(lblrollnumber);
        
        crollno=new Choice();
        crollno.setBounds(200,100,200,20);
        add(crollno);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next()){
            crollno.add(rs.getString("rollno"));
            }
            
        }catch(Exception e){e.printStackTrace();}
        
        
        
    JLabel lblsemester=new JLabel("Select By Roll No");
        lblsemester.setBounds(50,150,150,20);
        add(lblsemester);
    
     String semester[]={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        
    cbsemester =new JComboBox(semester);
    cbsemester.setBounds(200, 150, 200, 20);
    cbsemester.setBackground(Color.WHITE);
    add(cbsemester);   
        
     JLabel lblsubject=new JLabel("Enter Subject");
        lblsubject.setBounds(50,250,150,20);
        add(lblsubject);
        
    JLabel lblmarks=new JLabel("Enter Marks");
        lblmarks.setBounds(250,250,150,20);
        add(lblmarks);
        
    tfsub1=new JTextField();
    tfsub1.setBounds(50,280,150,20);
    add(tfsub1);
    tfsub2=new JTextField();
    tfsub2.setBounds(50,300,150,20);
    add(tfsub2);
    tfsub3=new JTextField();
    tfsub3.setBounds(50,320,150,20);
    add(tfsub3);
    tfsub4=new JTextField();
    tfsub4.setBounds(50,340,150,20);
    add(tfsub4);
    tfsub5=new JTextField();
    tfsub5.setBounds(50,360,150,20);
    add(tfsub5);
    
    tfmarks1=new JTextField();
    tfmarks1.setBounds(200,280,150,20);
    add(tfmarks1);
    
    tfmarks2=new JTextField();
    tfmarks2.setBounds(200,300,150,20);
    add(tfmarks2);
    
    tfmarks3=new JTextField();
    tfmarks3.setBounds(200,320,150,20);
    add(tfmarks3);
    
   
    tfmarks4=new JTextField();
    tfmarks4.setBounds(200,340,150,20);
    add(tfmarks4);
    
    tfmarks5=new JTextField();
    tfmarks5.setBounds(200,360,150,20);
    add(tfmarks5);
    
 
       //buttons
        submit=new JButton("Submit");
        submit.setBounds(220,400,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
    
        cancel=new JButton("Cancel");
        cancel.setBounds(70,400,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
    
    
    
    setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==submit){
        
        try{
        
            Conn c=new Conn();
            
            String query1="insert into subject values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub2.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";
            String query2="insert into marks values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"')";

            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null,"Marks Inserted Sucessfully");
            setVisible(false);

        }catch(Exception e){ e.printStackTrace();}
        
        
    }
    else if(ae.getSource()==cancel){
        setVisible(false);
    }
        
    }
    
    public static void main(String[] args){
    
        new EnterMarks();
    }
    
}
