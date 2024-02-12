
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class StudentFeeForm extends JFrame implements ActionListener{
    JButton update,pay,cancel;
    Choice crollno;
    JComboBox cbcourse,cbbranch,cbsemester;
     JLabel labeltotal;
    StudentFeeForm(){
        setSize(900,500);
        setLocation(200,80);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
     Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     image.setBounds(400,50,450,300);
     add(image); 
     
     
     // heading
    JLabel heading=new JLabel("Student Fee Form");
    heading.setBounds(50,10,500,50);
    heading.setFont(new Font("serif",Font.BOLD,30));
    add(heading);
    
    JLabel lblrollnumber=new JLabel("Select By Roll No");
        lblrollnumber.setBounds(50,100,130,20);
        add(lblrollnumber);
        
        crollno=new Choice();
        crollno.setBounds(200,100,150,20);
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
    lblname.setBounds(50,130,130,30);
    lblname.setFont(new Font("serif",Font.BOLD,16));
    add(lblname);
    
    //text name
    JLabel labelname=new JLabel();
    labelname.setBounds(200,130,150,20);
   // labelname.setFont(new Font("serif",Font.BOLD,16));
    add(labelname);
    
    //lblfname
    JLabel lblfname=new JLabel("Fathers Name");
    lblfname.setBounds(50,160,130,30);
   lblfname.setFont(new Font("serif",Font.BOLD,16));
    add(lblfname);
    
    //text fname
    JLabel labelfname=new JLabel();
    labelfname.setBounds(200,160,150,20);
   // labelfname.setFont(new Font("serif",Font.BOLD,20));
    add(labelfname);
     
     try{
    
       Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                // Set data to corresponding text fields
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
              
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
               
        }
    }catch(Exception e){ e.printStackTrace();}
            
        }
    });
    
    
     //lblcourse
    JLabel lblcourse=new JLabel("Course");
    lblcourse.setBounds(50,190,130,30);
    lblcourse.setFont(new Font("serif",Font.BOLD,16));
    add(lblcourse);
    
    //text tfcourse
    
    String course[]={"BTech","BBA","BCA","BSC","MSC","MBA","MCA","MCOM","MA","BA","BE"};
    cbcourse=new JComboBox(course);
    cbcourse.setBackground(Color.WHITE);
    cbcourse.setBounds(200,190,150,20);
    add(cbcourse);
    
     //lblbranch
    JLabel lblbranch=new JLabel("Branch");
    lblbranch.setBounds(50,220,100,30);
    lblbranch.setFont(new Font("serif",Font.BOLD,16));
    add(lblbranch);
    
    //text tfbranch
    String branch[]={"Computer Science","Mechanical","Civil","Production","Electronics","Information Technology","Electrical","Automation"};
    cbbranch=new JComboBox(branch);
    cbbranch.setBackground(Color.WHITE);
    cbbranch.setBounds(200,220,150,20);
    add(cbbranch);
    
    JLabel lblsemester=new JLabel("Select Semester");
    lblsemester.setBounds(50,250,150,30);
    lblsemester.setFont(new Font("serif",Font.BOLD,16));
    add(lblsemester);
    
     String semester[]={"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
        
    cbsemester =new JComboBox(semester);
    cbsemester.setBounds(200, 250, 150, 20);
    cbsemester.setBackground(Color.WHITE);
    add(cbsemester);
    
    JLabel lbltotal=new JLabel("Total Payable");
    lbltotal.setBounds(50,280,150,30);
    lbltotal.setFont(new Font("serif",Font.BOLD,16));
    add(lbltotal);
    
    labeltotal=new JLabel();
    labeltotal.setBounds(200,280,150,20);
    labeltotal.setFont(new Font("serif",Font.BOLD,16));
    add(labeltotal);
    
    
        
        
        //buttons
    update=new JButton("Update");
    update.setBounds(160,340,90,30);
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    update.addActionListener(this);
    add(update);
    
    pay=new JButton("Pay Fee");
    pay.setBounds(270,340,90,30);
    pay.setBackground(Color.BLACK);
    pay.setForeground(Color.WHITE);
    pay.addActionListener(this);
    add(pay);
    
    cancel=new JButton("Cancel");
    cancel.setBounds(50,340,90,30);
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.addActionListener(this);
    add(cancel);
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            
            String course=(String)cbcourse.getSelectedItem();
            String semester=(String)cbsemester.getSelectedItem();
            String branch=(String)cbbranch.getSelectedItem();
            
            try{
            
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from fee where course='"+course+"'");
                while(rs.next()){
                    labeltotal.setText(rs.getString(semester));
                }
            }catch(Exception e){ e.printStackTrace();}
            
        }
        else if(ae.getSource()==cancel){
        setVisible(false);
        }
        else if(ae.getSource()==pay){
          String rollno=crollno.getSelectedItem();
         String course=(String)cbcourse.getSelectedItem();
         String semester=(String)cbsemester.getSelectedItem();
         String branch=(String)cbbranch.getSelectedItem();
         String total=labeltotal.getText();
         
          try{
            
                Conn c=new Conn();
                String query="insert into collagefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Collage Fee Submitted");
               setVisible(false);
            }catch(Exception e){ e.printStackTrace();}
         
         
        }
        
   
    }
    
    
    public static void main(String[] args){
    
    new StudentFeeForm();    
    }
    
}
