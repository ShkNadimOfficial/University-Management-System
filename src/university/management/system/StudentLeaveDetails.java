
package university.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class StudentLeaveDetails extends JFrame implements ActionListener{
    
    Choice crollno;
    JTable table;
    JButton search,print,update,add,cancel;
    
    StudentLeaveDetails(){
    
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(900,650);
        setLocation(150,20);
        
        JLabel heading=new JLabel("Search By Roll No");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        crollno=new Choice();
        crollno.setBounds(180,20,150,20);
        add(crollno);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next()){
            crollno.add(rs.getString("rollno"));
            }
            
        }catch(Exception e){e.printStackTrace();}
        
        
        table=new JTable();
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
     
        
        cancel=new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
         try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){e.printStackTrace();}
        
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
            
            if(ae.getSource()==search){
            String query="select  * from studentleave where rollno='"+crollno.getSelectedItem()+"'";
            
            try{
            
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch(Exception e){e.printStackTrace();}
            
            }
            
            else if(ae.getSource()==print){
                try{
                table.print();
                 }catch(Exception e){e.printStackTrace();}
            }
       
            else if (ae.getSource()==cancel){
            setVisible(false);
            }
         
            
    }
    
    public static void main(String[] args){

        new StudentLeaveDetails();
    }
}
