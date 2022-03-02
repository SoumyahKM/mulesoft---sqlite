import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class RecordSelectionCondition {  
   
    private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/movie.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void selectAll(){  
        String sql = "SELECT * FROM movie WHERE actor LIKE '%Leonardo Dicaprio%'";
          
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getString("moviename") +  "\t" +   
                                   rs.getString("actor") + "\t" +  
                                   rs.getString("actress") + "\t" +
                                   rs.getString("director") + "\t" +
                                   rs.getString("year_of_release"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
      
     
    
    public static void main(String[] args) {  
        RecordSelectionCondition app = new RecordSelectionCondition();  
        app.selectAll();  
    }  
   
}  