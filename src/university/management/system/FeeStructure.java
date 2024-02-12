
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
      
        
public class FeeStructure extends JFrame {
    
    FeeStructure(){
    setSize(900,650);
    setLocation(150,20);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    
    JLabel heading=new JLabel("Fees Structure");
    heading.setBounds(70,10,500,50);
    heading.setFont(new Font("serif",Font.BOLD,30));
    add(heading);
    
    JTable table=new JTable();
    
    try{
    
        Conn c=new Conn();
        ResultSet rs = c.s.executeQuery("select * from fee");
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
        
    }catch(Exception e){ e.printStackTrace();}
    
    
    JScrollPane jsp=new JScrollPane(table);
    jsp.setBounds(0,60,900,650);
    add(jsp);
    
    
    
    
    
    
    
    
    setVisible(true);
    }

    
    
public static void main(String[] args){

    new FeeStructure();
}    

   
}
