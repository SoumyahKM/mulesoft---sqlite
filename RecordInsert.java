import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
   
public class RecordInsert {  
   
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
   
  
    public void insert(String moviename,String actor,String actress,String director,String year_of_release ) {  
        String sql = "INSERT INTO movie(moviename,actor,actress,director,year_of_release) VALUES(?,?,?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, moviename);  
            pstmt.setString(2, actor); 
            pstmt.setString(3, actress);  
            pstmt.setString(4, director); 
            pstmt.setString(5, year_of_release); 
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    public static void main(String[] args) {  
   
        RecordInsert app = new RecordInsert();  
        // insert three new rows  
        app.insert("Dune", "Tim","Zendaya","Denis","2021");  
        app.insert("The Dark Knight","Christian","Heath","ChristopherNolan","2008");  
        app.insert("Titanic", "Leonardo Dicaprio","Kate Winslet","James Cameron","1997");  
        app.insert("The sixth sense", "Haley joel osmalt","Toni","Night Shyamalan","1999");
        app.insert("Inception", "Leonardo Dicaprio","Marion","ChristopherNolan","2010");
    }  
   
}  