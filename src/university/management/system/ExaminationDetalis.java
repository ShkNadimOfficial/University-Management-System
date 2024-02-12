
package university.management.system;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ExaminationDetalis extends JFrame implements ActionListener{
    JTextField search;
    JButton submit,cancel;
    JTable table;
    ExaminationDetalis(){
    
        setSize(900,650);
        setLocation(150,20);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
    JLabel heading=new JLabel("Check Result");
    heading.setBounds(50,10,500,50);
    heading.setFont(new Font("serif",Font.BOLD,30));
    add(heading);
        
    search=new JTextField();
    search.setBounds(50,90,200,30);
    add(search);
    
     
    //buttons
    submit=new JButton("Result");
    submit.setBounds(270,90,100,30);
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    submit.addActionListener(this);
    add(submit);
    
    cancel=new JButton("Cancel");
    cancel.setBounds(390,90,100,30);
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.addActionListener(this);
    add(cancel);
    
    table=new JTable();
    table.setFont(new Font("Tahoma",Font.PLAIN,12));
    
    JScrollPane jsp=new JScrollPane(table);
    jsp.setBounds(0,130,890,640);
    add(jsp);
    
    try{
    
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery("select * from student");
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
        
    }catch(Exception e){ e.printStackTrace();}
    
    //mouse listener event add here
    table.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent me) {
        int row = table.getSelectedRow();
        search.setText(table.getModel().getValueAt(row, 2).toString());
        }
    });

   
    
            
            
            
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
    
        
        if(ae.getSource()==submit){
            
            setVisible(false);
            new Marks(search.getText());
            
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
    
        new ExaminationDetalis();
    }
    
}
