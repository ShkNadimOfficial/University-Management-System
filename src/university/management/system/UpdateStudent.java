
package university.management.system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;


public class UpdateStudent extends JFrame implements ActionListener {
    JTextField tfcourse,tfaddress,tfphone,tfemail,tfbranch;
    JLabel labelrollno;
    Choice crollno;
  
    JButton submit,cancel;
   
  
    UpdateStudent(){
    setSize(900,650);
    setLocation(150,20);
    setLayout(null);
    
    // heading
    JLabel heading=new JLabel("Update Student Details");
    heading.setBounds(50,10,500,50);
    heading.setFont(new Font("serif",Font.BOLD,30));
    add(heading);
    
    JLabel lblrollnumber=new JLabel("Select By Roll No");
        lblrollnumber.setBounds(50,100,200,20);
        add(lblrollnumber);
        
        crollno=new Choice();
        crollno.setBounds(250,100,200,20);
        add(crollno);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next()){
            crollno.add(rs.getString("rollno"));
            }
            
        }catch(Exception e){e.printStackTrace();}
    
    //lblname
    JLabel lblname=new JLabel("Name");
    lblname.setBounds(50,150,100,30);
    lblname.setFont(new Font("serif",Font.BOLD,20));
    add(lblname);
    
    //text name
    JLabel labelname=new JLabel();
    labelname.setBounds(150,150,150,30);
    labelname.setFont(new Font("serif",Font.BOLD,20));
    add(labelname);
    
    //lblfname
    JLabel lblfname=new JLabel("Fathers Name");
    lblfname.setBounds(450,150,200,30);
    lblfname.setFont(new Font("serif",Font.BOLD,20));
    add(lblfname);
    
    //text fname
    JLabel labelfname=new JLabel();
    labelfname.setBounds(600,150,150,30);
    labelfname.setFont(new Font("serif",Font.BOLD,20));
    add(labelfname);
    
    
    //lblrollno
    JLabel lblrollno=new JLabel("Roll No");
    lblrollno.setBounds(50,200,100,30);
    lblrollno.setFont(new Font("serif",Font.BOLD,20));
    add(lblrollno);
    
    //text frollno
    labelrollno=new JLabel();
    labelrollno.setBounds(150,200,150,30);
    labelrollno.setFont(new Font("serif",Font.BOLD,20));
    add(labelrollno);
    
     //birthdate
    JLabel lbldob=new JLabel("Date of Birth");
    lbldob.setBounds(450,200,200,30);
    lbldob.setFont(new Font("serif",Font.BOLD,20));
    add(lbldob);
    //date chooser
    JLabel labeldob=new JLabel();
    labeldob.setBounds(600,200,150,30);
    labeldob.setFont(new Font("serif",Font.BOLD,20));
    add(labeldob);
    
    //lbladdress
    JLabel lbladdress=new JLabel("Address");
    lbladdress.setBounds(50,250,100,30);
    lbladdress.setFont(new Font("serif",Font.BOLD,20));
    add(lbladdress);
    
    //text tfaddress
    tfaddress=new JTextField();
    tfaddress.setBounds(150,250,150,30);
    tfaddress.setFont(new Font("serif",Font.PLAIN,14));
    add(tfaddress);
    
     //lblphone
    JLabel lblphone=new JLabel("Phone No");
    lblphone.setBounds(450,250,200,30);
    lblphone.setFont(new Font("serif",Font.BOLD,20));
    add(lblphone);
    
    //text tfphone
    tfphone=new JTextField();
    tfphone.setBounds(600,250,150,30);
    tfphone.setFont(new Font("serif",Font.PLAIN,14));
    add(tfphone);
    
    //lblemail
    JLabel lblemail=new JLabel("Email ID");
    lblemail.setBounds(50,300,100,30);
    lblemail.setFont(new Font("serif",Font.BOLD,20));
    add(lblemail);
    
    //text tfemail
    tfemail=new JTextField();
    tfemail.setBounds(150,300,150,30);
    tfemail.setFont(new Font("serif",Font.PLAIN,14));
    add(tfemail);
    
    //lbl10% called x
    JLabel lblx=new JLabel("10th %");
    lblx.setBounds(450,300,200,30);
    lblx.setFont(new Font("serif",Font.BOLD,20));
    add(lblx);
    
    //text tfx
    JLabel labelx=new JLabel();
    labelx.setBounds(600,300,150,30);
    labelx.setFont(new Font("serif",Font.BOLD,14));
    add(labelx);
    
     //lbl12% called xii
    JLabel lblxii=new JLabel("12th %");
    lblxii.setBounds(50,350,100,30);
    lblxii.setFont(new Font("serif",Font.BOLD,20));
    add(lblxii);
    
    //text tfxii
    JLabel labelxii=new JLabel();
    labelxii.setBounds(150,350,150,30);
    labelxii.setFont(new Font("serif",Font.BOLD,14));
    add(labelxii);
    
    //lblaadhar
    JLabel lblaadhar=new JLabel("Aadhar No");
    lblaadhar.setBounds(450,350,200,30);
    lblaadhar.setFont(new Font("serif",Font.BOLD,20));
    add(lblaadhar);
    
    //text tfaadhar
    JLabel labelaadhar=new JLabel();
    labelaadhar.setBounds(600,350,150,30);
    labelaadhar.setFont(new Font("serif",Font.BOLD,14));
    add(labelaadhar);
    
    
    //lblcourse
    JLabel lblcourse=new JLabel("Course");
    lblcourse.setBounds(50,400,100,30);
    lblcourse.setFont(new Font("serif",Font.BOLD,20));
    add(lblcourse);
    
    //text tfcourse
    
    tfcourse=new JTextField();
    tfcourse.setBackground(Color.WHITE);
    tfcourse.setBounds(150,400,150,30);
    add(tfcourse);
    
     //lblbranch
    JLabel lblbranch=new JLabel("Branch");
    lblbranch.setBounds(450,400,200,30);
    lblbranch.setFont(new Font("serif",Font.BOLD,20));
    add(lblbranch);
    
    //text tfbranch
    tfbranch=new JTextField();
    tfbranch.setBackground(Color.WHITE);
    tfbranch.setBounds(600,400,150,30);
    add(tfbranch);
    
    try{
    
       Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                // Set data to corresponding text fields
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("adderss")); // Fix typo in "address" column
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("classx"));
                labelxii.setText(rs.getString("classxii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelrollno.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
        }
    }catch(Exception e){ e.printStackTrace();}
    
    crollno.addItemListener(new ItemListener(){ 
    
        public void itemStateChanged(ItemEvent ie){
                 try{
    
       Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                // Set data to corresponding text fields
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("adderss")); // Fix typo in "address" column
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("classx"));
                labelxii.setText(rs.getString("classxii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelrollno.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
        }
    }catch(Exception e){ e.printStackTrace();}
            
        }
    });
    
    
    //buttons
    submit=new JButton("Update");
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
        {
        String rollno=labelrollno.getText();
        String adderss=tfaddress.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String course=tfcourse.getText();
        String branch=tfbranch.getText();
        
        try{
            String query="update student set adderss='"+adderss+"',phone='"+phone+"',email='"+email+"',course='"+course+"',branch='"+branch+"' where rollno='"+rollno+"'";
            Conn con=new Conn();
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Students Details Updated Sucessfully...");
            setVisible(false);
            
        }catch(Exception e){ e.printStackTrace(); }
        
            
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }   
        
    }
    
    
    
    
   public static void main(String[] args) {
    new UpdateStudent();
    }
}
