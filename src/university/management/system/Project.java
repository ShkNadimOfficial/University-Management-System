package university.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    Project(){
        setSize(1540,850);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);

        JMenuBar mb=new JMenuBar();
        //information tab
        JMenu newInfo=new JMenu("New Information");
        mb.add(newInfo);
        newInfo.setForeground(Color.BLUE);

        JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo=new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        JMenuItem otherInfo=new JMenuItem("Other Information");
        otherInfo.setBackground(Color.WHITE);
        otherInfo.addActionListener(this);
        newInfo.add(otherInfo);

        //details tab
        JMenu details=new JMenu("View Details");
        mb.add(details);
        details.setForeground(Color.RED);

        JMenuItem facultydetails=new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails=new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        //leave tab
        JMenu leave=new JMenu("Apply Leave");
        mb.add(leave);
        leave.setForeground(Color.BLUE);

        JMenuItem facultyleave=new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave=new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);

        //leave deatlas tab
        JMenu leaveDetails=new JMenu("Leave Details");
        mb.add(leaveDetails);
        leaveDetails.setForeground(Color.RED);

        JMenuItem facultyleaveDEtails=new JMenuItem("Faculty Leave Details");
        facultyleaveDEtails.setBackground(Color.WHITE);
        facultyleaveDEtails.addActionListener(this);
        leaveDetails.add(facultyleaveDEtails);

        JMenuItem studentleaveDetails=new JMenuItem("Student Leave Details");
        studentleaveDetails.setBackground(Color.WHITE);
        studentleaveDetails.addActionListener(this);
        leaveDetails.add(studentleaveDetails);

        // examination tab
        JMenu exam=new JMenu("Examinations");
        mb.add(exam);
        exam.setForeground(Color.BLUE);

        JMenuItem examDetails=new JMenuItem("Exam Results");
        examDetails.setBackground(Color.WHITE);
        examDetails.addActionListener(this);
        exam.add(examDetails);

        JMenuItem entermarks=new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);

        // update info tab
        JMenu updateInfo=new JMenu("Update Details");
        mb.add(updateInfo);
        updateInfo.setForeground(Color.RED);

        JMenuItem updatefacultyinfo=new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);

        JMenuItem updatestudentInfo=new JMenuItem("Update Student Details");
        updatestudentInfo.setBackground(Color.WHITE);
        updatestudentInfo.addActionListener(this);
        updateInfo.add(updatestudentInfo);

        // fees tab
        JMenu fee=new JMenu("Fee Details");
        mb.add(fee);
        fee.setForeground(Color.BLUE);

        JMenuItem feestructure=new JMenuItem("Fees Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);

        JMenuItem feeform=new JMenuItem("Student Fees Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);

        // utility tab
        JMenu utility=new JMenu("Utility");
        mb.add(utility);
        utility.setForeground(Color.RED);

        JMenuItem notepad=new JMenuItem("NotePad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc=new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);
        
        //about
        JMenu about=new JMenu("About");
        mb.add(about);
        about.setForeground(Color.BLUE);
        
        JMenuItem ab=new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);

        // exit tab
        JMenu exit=new JMenu("Exit");
        mb.add(exit);
        exit.setForeground(Color.RED);

        JMenuItem ex=new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);
        setVisible(true);
    }

   public void actionPerformed(ActionEvent ae) {
    String msg = ae.getActionCommand();
        if (msg.equals("Exit")) {
             setVisible(false);
         } else if (msg.equals("Calculator")) {
              try {
            Runtime.getRuntime().exec("calc.exe");
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }
          } else if (msg.equals("Notepad")) {
        try {
            Runtime.getRuntime().exec("notepad");
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }
         } else if (msg.equals("New Faculty Information")) {
        new AddTeacher();
         } else if (msg.equals("New Student Information")) {
        new AddStudent();
         }
        
        else if (msg.equals("View Faculty Details")) {
        new TeacherDetails();
         }
        
        else if (msg.equals("View Student Details")) {
        new StudentDetails();
         }
         else if (msg.equals("Faculty Leave")) {
        new TeacherLeave();
         }
        
        else if (msg.equals("Student Leave")) {
        new StudentLeave();
         }
        else if (msg.equals("Faculty Leave Details")) {
        new TeacherLeaveDetails();
         }
        
        else if (msg.equals("Student Leave Details")) {
        new StudentLeaveDetails();
         }
         else if (msg.equals("Update Faculty Details")) {
        new UpdateTeacher();
         }
        
        else if (msg.equals("Update Student Details")) {
        new UpdateStudent();
         }
        else if (msg.equals("Enter Marks")) {
        new EnterMarks();
         }
         else if (msg.equals("Exam Results")) {
        new ExaminationDetalis();
         }
        else if (msg.equals("Fees Structure")) {
        new FeeStructure();
         }
         else if (msg.equals("About")) {
        new About();
         }
         else if (msg.equals("Student Fees Form")) {
        new StudentFeeForm();
         }
        else if (msg.equals("Other Information")) {
        new OtherInfo();
         }
        
        
        
        
        
        
        
}   



    public static void main(String[] args) {
        new Project(); // Assuming Project class has a constructor that does something
    }

}
