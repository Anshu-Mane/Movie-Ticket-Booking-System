import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SeatDAO {
    public void displaySeats( int showId)
    {
        try
        {
            Connection con = DBconnection.getConnection();

            String query = "SELECT * FROM seats WHERE show_id=?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1,showId);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                System.out.println(rs.getString("seat_number")+" " +rs.getString("state"));
            }
            BookingDAO booking = new BookingDAO();

        booking.bookTicket(Session.userId, showId);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
