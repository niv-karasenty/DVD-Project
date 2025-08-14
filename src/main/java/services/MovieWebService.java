package services;

import ejb.MovieService;
import entities.Movie;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class MovieWebService {

    @EJB
    private MovieService movieService;

    @WebMethod
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @WebMethod
    public List<Movie> getMoviesByGenre(String genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @WebMethod
    public Movie getMovieById(int movieId) {
        return movieService.getMovieById(movieId);
    }
    
    @WebMethod
    public String addMovie (Movie movie) {
        movieService.addMovie(movie);
        return "Movie added";
    }
    
    @WebMethod
    public String updateMovie (Movie movie) {
        movieService.updateMovie(movie);
        return "Movie updated";
    }
    
    @WebMethod
    public List<Movie> getMoviesByTitle(String title) {
        return movieService.getMoviesByTitle(title);
    }

    @WebMethod
    public String deleteMovie(int movieId) {
        return movieService.deleteMovie(movieId);
    }
}