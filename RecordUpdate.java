import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RecordUpdate {

    
    private Connection connect() {
        
        String url = "jdbc:sqlite:C://sqlite/movie.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    public void update( String actor,String actress,String moviename) {
        String sql = "UPDATE movie SET actor = ? , "
                + "actress = ? "
                + "WHERE moviename = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, actor);  
            pstmt.setString(2, actress); 
            pstmt.setString(3, moviename);  
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        
        RecordUpdate app = new RecordUpdate();
        
        app.update("BillyZane","Gloria","Titanic");
    }

}