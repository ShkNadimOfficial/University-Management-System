
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;


public class AddTeacher extends JFrame implements ActionListener {
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfx,tfxii,tfaadhar;
    JLabel tfempid;
    JDateChooser dcdob;
    JButton submit,cancel;
    JComboBox cbcourse,cbbranch;
    Random ran=new Random();
    long firstfour=Math.abs((ran.nextLong()%9000L)+1000L);
    AddTeacher(){
    setSize(900,650);
    setLocation(150,20);
    setLayout(null);
    
    // heading
    JLabel heading=new JLabel("Add New Teacher Details");
    heading.setBounds(310,30,500,50);
    heading.setFont(new Font("serif",Font.BOLD,30));
    add(heading);
    
    //lblname
    JLabel lblname=new JLabel("Name");
    lblname.setBounds(50,150,100,30);
    lblname.setFont(new Font("serif",Font.BOLD,20));
    add(lblname);
    
    //text name
    tfname=new JTextField();
    tfname.setBounds(150,150,150,30);
    add(tfname);
    
    //lblfname
    JLabel lblfname=new JLabel("Fathers Name");
    lblfname.setBounds(450,150,200,30);
    lblfname.setFont(new Font("serif",Font.BOLD,20));
    add(lblfname);
    
    //text fname
    tffname=new JTextField();
    tffname.setBounds(600,150,150,30);
    add(tffname);
    
    
    //lbl empid
    JLabel lblempid=new JLabel("Emp ID");
    lblempid.setBounds(50,200,100,30);
    lblempid.setFont(new Font("serif",Font.BOLD,20));
    add(lblempid);
    
    //text tfempid
    tfempid=new JLabel("101"+firstfour);
    tfempid.setBounds(150,200,150,30);
    tfempid.setFont(new Font("serif",Font.BOLD,20));
    add(tfempid);
    
     //birthdate
    JLabel lbldob=new JLabel("Date of Birth");
    lbldob.setBounds(450,200,200,30);
    lbldob.setFont(new Font("serif",Font.BOLD,20));
    add(lbldob);
    //date chooser
    dcdob=new JDateChooser();
    dcdob.setBounds(600,200,150,30);
    add(dcdob);
    
    //lbladdress
    JLabel lbladdress=new JLabel("Address");
    lbladdress.setBounds(50,250,100,30);
    lbladdress.setFont(new Font("serif",Font.BOLD,20));
    add(lbladdress);
    
    //text tfaddress
    tfaddress=new JTextField();
    tfaddress.setBounds(150,250,150,30);
    add(tfaddress);
    
     //lblphone
    JLabel lblphone=new JLabel("Phone No");
    lblphone.setBounds(450,250,200,30);
    lblphone.setFont(new Font("serif",Font.BOLD,20));
    add(lblphone);
    
    //text tfphone
    tfphone=new JTextField();
    tfphone.setBounds(600,250,150,30);
    add(tfphone);
    
    //lblemail
    JLabel lblemail=new JLabel("Email ID");
    lblemail.setBounds(50,300,100,30);
    lblemail.setFont(new Font("serif",Font.BOLD,20));
    add(lblemail);
    
    //text tfemail
    tfemail=new JTextField();
    tfemail.setBounds(150,300,150,30);
    add(tfemail);
    
    //lbl10% called x
    JLabel lblx=new JLabel("10th %");
    lblx.setBounds(450,300,200,30);
    lblx.setFont(new Font("serif",Font.BOLD,20));
    add(lblx);
    
    //text tfx
    tfx=new JTextField();
    tfx.setBounds(600,300,150,30);
    add(tfx);
    
     //lbl12% called xii
    JLabel lblxii=new JLabel("12th %");
    lblxii.setBounds(50,350,100,30);
    lblxii.setFont(new Font("serif",Font.BOLD,20));
    add(lblxii);
    
    //text tfxii
    tfxii=new JTextField();
    tfxii.setBounds(150,350,150,30);
    add(tfxii);
    
    //lblaadhar
    JLabel lblaadhar=new JLabel("Aadhar No");
    lblaadhar.setBounds(450,350,200,30);
    lblaadhar.setFont(new Font("serif",Font.BOLD,20));
    add(lblaadhar);
    
    //text tfaadhar
    tfaadhar=new JTextField();
    tfaadhar.setBounds(600,350,150,30);
    add(tfaadhar);
    
    
    //lblcourse
    JLabel lblcourse=new JLabel("Qualification");
    lblcourse.setBounds(50,400,100,30);
    lblcourse.setFont(new Font("serif",Font.BOLD,20));
    add(lblcourse);
    
    //text tfcourse
    
    String course[]={"Btech","BBA","BCA","BSC","MSC","MBA","MCA","MCOM","MA","BA","BE"};
    cbcourse=new JComboBox(course);
    cbcourse.setBackground(Color.WHITE);
    cbcourse.setBounds(150,400,150,30);
    add(cbcourse);
    
     //lblbranch
    JLabel lblbranch=new JLabel("Department");
    lblbranch.setBounds(450,400,200,30);
    lblbranch.setFont(new Font("serif",Font.BOLD,20));
    add(lblbranch);
    
    //text tfbranch
    String branch[]={"Computer Science","Mechanical","Civil","Production","Electronics","Information Technology","Electrical","Automation"};
    cbbranch=new JComboBox(branch);
    cbbranch.setBackground(Color.WHITE);
    cbbranch.setBounds(600,400,150,30);
    add(cbbranch);
    
    //buttons
     submit=new JButton("Submit");
    submit.setBounds(550,500,200,30);
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    submit.addActionListener(this);
    add(submit);
    
    cancel=new JButton("Cancel");
    cancel.setBounds(150,500,200,30);
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.addActionListener(this);
    add(cancel);
    
   
    setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit)
        {String name=tfname.getText();
        String fname=tfname.getText();
        String empID=tfempid.getText();
        String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
        String address=tfaddress.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String x=tfx.getText();
        String xii=tfxii.getText();
        String aadhar=tfaadhar.getText();
        String course=(String)cbcourse.getSelectedItem();
        String branch=(String)cbbranch.getSelectedItem();
        
        try{
            String query="insert into teacher values('"+name+"','"+fname+"','"+empID+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
            Conn con=new Conn();
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Teacher Details inserted Sucessfully...");
            setVisible(false);
            
        }catch(Exception e){ e.printStackTrace(); }
        
            
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }   
         
    }
    
    
    
    
    public static void main(String[] args){
    new AddTeacher();
    }
}
