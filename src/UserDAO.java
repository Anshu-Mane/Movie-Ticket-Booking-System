import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class UserDAO {
    public void registerUser()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your Phone Number:) ");
        String phoneNo = sc.nextLine();
        sc.nextLine();
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        //System.out.print("User Registered Successfully");


        //Writing query to insert user details into database
        try
        {
            Connection con = DBconnection.getConnection();
            String query = "INSERT INTO users (user_name, phone_number, email, password) VALUES (?,?,?,?)";
            //PreparedStatement object creation
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,name);
            pstmt.setString(2,phoneNo);
            pstmt.setString(3,email);
            pstmt.setString(4,password);
            int rows =pstmt.executeUpdate();

            if(rows >0)
            {
                System.out.println("User Registered Successfully");
                loginUser();
            }
            else
            {
                System.out.println("User Registration Failed");
            }            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    

    public void loginUser()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        try
        {
            Connection con = DBconnection.getConnection();
            String query = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
        {
            Session.userId = rs.getInt("user_id"); // Store the user ID in the Session class

            System.out.println("Login Successful");

            System.out.println(
            "Welcome "+ rs.getString("user_name"));

            MovieDAO movie = new MovieDAO();
            movie.displayMovies();

        }
        else
        {

            System.out.println("Invalid email or password");

        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
