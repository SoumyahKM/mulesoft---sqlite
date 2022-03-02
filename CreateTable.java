import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class CreateTable {  
   
    public static void createNewTable() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/movie.db";  
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS movie (\n"  
                + " moviename String PRIMARY KEY,\n"  
                + " actor String NOT NULL,\n"  
                + " actress String NOT NULL,\n"  
                 + " director String NOT NULL,\n"  
                 + " year_of_release String NOT NULL\n"  
                + ");"; 
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
            System.out.println("A new table has been created.");  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        createNewTable();  
    }  
   
}