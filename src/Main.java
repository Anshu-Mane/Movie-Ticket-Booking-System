public class Main {
    public static void main(String[] args) {
        //Instantiates (creates an instance of) your MovieDAO.
        // MovieDAO movie = new MovieDAO();
        // movie.displayMovies();
        UserDAO user = new UserDAO();
        user.registerUser();
    }
}