import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ShowDAO {
    public void displayshows(int ID)
    {
        try
        {
            Connection con = DBconnection.getConnection();
            String query= "SELECT * FROM shows WHERE movie_id=?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1,ID);

            ResultSet rs = pstmt.executeQuery();
            System.out.println("Available Shows:");
            while(rs.next())
            {
                System.out.println(rs.getInt("movie_id")+" "+rs.getString("show_date")+" "+rs.getString("timing")+" "+rs.getString("show_date")+" "+rs.getString("show_price"));
            }
           // int userId = rs.getInt("user_id");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the Show ID: ");
            int showId = sc.nextInt();

            SeatDAO seatDAO = new SeatDAO();
            seatDAO.displaySeats(showId);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            

        }
    }
}
