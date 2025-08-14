package ejb;

import entities.Movie;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MovieService {

    @PersistenceContext(unitName = "BlockkBusterrBackEnd1.0PU")
    private EntityManager em;

    public List<Movie> getAllMovies() {
        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return em.createQuery("SELECT m FROM Movie m WHERE m.genre = :genre", Movie.class)
                .setParameter("genre", genre)
                .getResultList();
    }

    public Movie getMovieById(int movieId) {
        return em.find(Movie.class, movieId);
    }
    
    public void addMovie(Movie movie) {
        em.persist(movie);
    }
    
    public void updateMovie(Movie movie) {
        em.merge(movie);
    }
    
    public List<Movie> getMoviesByTitle(String title) {
        return em.createQuery("SELECT m FROM Movie m WHERE LOWER(m.title) LIKE LOWER(:title)", Movie.class)
                 .setParameter("title", "%" + title.toLowerCase() + "%")
                 .getResultList();
    }

    public String deleteMovie(int movieId) {
        Movie movie = em.find(Movie.class, movieId);
        if (movie != null) {
            em.remove(movie);
            return "Movie deleted successfully.";
        }
        return "Movie not found.";
    }
}