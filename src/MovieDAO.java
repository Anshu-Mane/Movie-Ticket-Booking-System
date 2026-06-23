import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MovieDAO {
    public void displayMovies()
    {
        try
        {
            Connection con = DBconnection.getConnection();
            String query = "SELECT * FROM movies";
            //Statement object creation
            Statement stmt = con.createStatement();
            //Executing the query in stmt object and storing the result in ResultSet object
            ResultSet rs = stmt.executeQuery(query);
            
            System.out.println("Available Movies in Theatre");

            while(rs.next())
            {
                int id = rs.getInt("movie_id");
                String name = rs.getString("movie_name");
                String duration = rs.getString("duration");
                String genre = rs.getString("genre");

                System.out.println( id+" "+ name +" "+ duration +" "+ genre);
            }
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the Movie ID: ");
            int movieId = sc.nextInt();

            ShowDAO show = new ShowDAO();
            show.displayshows(movieId);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
