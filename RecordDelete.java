

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RecordDelete {

    
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

    
    public void delete(String moviename) {
        String sql = "DELETE FROM movie WHERE moviename = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, moviename);
           
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

  
    public static void main(String[] args) {
        RecordDelete app = new RecordDelete();
        
        app.delete("Dune");
    }

}