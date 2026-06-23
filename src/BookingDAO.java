import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class BookingDAO {


    public void bookTicket(int userId,int showId) {

        Scanner sc = new Scanner(System.in);


        try {

            Connection con = DBconnection.getConnection();


            // Taking multiple seats input

            System.out.print("Enter seat numbers (comma separated): ");

            String seatInput = sc.nextLine();


            String seats[] = seatInput.split(",");



            // Check seat availability

            for(String seat : seats)
            {

                String checkQuery =
                "SELECT * FROM seats WHERE show_id=? AND seat_number=? AND state='Available'";


                PreparedStatement check =
                con.prepareStatement(checkQuery);


                check.setInt(1, showId);

                check.setString(2, seat.trim());


                ResultSet rs = check.executeQuery();



                if(!rs.next())
                {

                    System.out.println(
                    seat + " is not available"
                    );

                    return;

                }

            }



            // Calculate amount

            // Getting price from shows table

String priceQuery =
"SELECT show_price FROM shows WHERE show_id=?";


PreparedStatement priceStmt =
con.prepareStatement(priceQuery);


priceStmt.setInt(1, showId);


ResultSet priceRs =
priceStmt.executeQuery();


int pricePerSeat = 0;


if(priceRs.next())
{
    pricePerSeat = priceRs.getInt("show_price");
}


int totalAmount = seats.length * pricePerSeat;



            System.out.println(
            "Total Amount: ₹" + totalAmount
            );


            System.out.print("Confirm Payment (Y/N): ");

            String payment = sc.nextLine();



            if(payment.equalsIgnoreCase("Y"))
            { 

                // Insert booking for every seat

                for(String seat : seats)
                {


                    String insertQuery =
                    "INSERT INTO booking(user_id,show_id,seat_number,payment) VALUES(?,?,?,?)";


                    PreparedStatement pstmt =
                    con.prepareStatement(insertQuery);



                    pstmt.setInt(1,userId);

                    pstmt.setInt(2,showId);

                    pstmt.setString(3,seat.trim());

                    pstmt.setInt(4,pricePerSeat);



                    pstmt.executeUpdate();


                }





                // Update seats status

                for(String seat : seats)
                {


                    String updateQuery =
                    "UPDATE seats SET state='Booked' WHERE show_id=? AND seat_number=?";


                    PreparedStatement update =
                    con.prepareStatement(updateQuery);



                    update.setInt(1,showId);

                    update.setString(2,seat.trim());



                    update.executeUpdate();


                }



                System.out.println();
                System.out.println("===== TICKET BOOKED SUCCESSFULLY =====");
                System.out.println("Seats: " + seatInput);
                System.out.println("Amount Paid: ₹" + totalAmount);
                System.out.println("======================================");



            }
            else
            {

                System.out.println("Payment Cancelled");

            }



        }
        catch(Exception e)
        {

            e.printStackTrace();

        }


    }

}
