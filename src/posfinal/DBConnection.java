package posfinal;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;  
public class DBConnection {          
     public static Connection con;
     public static Connection getDatabaseConnection(){         
         try{             
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/posfinale", "root", "");            
         }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            System.exit(0); 
        }      
        return con;     
     } 
   
}

