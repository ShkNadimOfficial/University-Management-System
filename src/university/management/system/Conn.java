
package university.management.system;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
    try{
        //1 Register the Driver class
        //2 creating connection string
        //3 Creating Statment
        //4 executing mysql quries
        //5 Closing the connection
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","Nadim@123");
        s=c.createStatement();
        
          }catch(Exception e){
            e.printStackTrace();
                }
    }

    PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
