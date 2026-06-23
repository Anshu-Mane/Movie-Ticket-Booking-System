import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnection {


    public static Connection getConnection(){

        Connection con = null;
        

        try{

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/movie_booking",
                    "root",
                    "MySQL_Anshu@08"
            );
            //System.out.println("Database Connected Successfully");


        }
        catch(Exception e){

            e.printStackTrace();

        }


        return con;

    }

}