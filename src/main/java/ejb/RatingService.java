package ejb;

import entities.Movie;
import entities.Rating;
import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RatingService {

    @PersistenceContext(unitName = "BlockkBusterrBackEnd1.0PU")
    private EntityManager em;

    public void addRating(int userId, int movieId, int score, String review) {
        Movie movie = em.find(Movie.class, movieId);
        User user = em.find(User.class, userId);
        
        if (user == null || movie == null) {
            throw new IllegalArgumentException("Invalid user or movie ID.");
        }
        Rating rating = new Rating();
        rating.setUserID(user);
        rating.setMovieID(movie);
        rating.setRate(score);
        rating.setReview(review);
        em.persist(rating);
    }

    public List<Rating> getRatingsForMovie(int movieId) {
        return em.createQuery("SELECT r FROM Rating r WHERE r.movieID = :mid", Rating.class)
                .setParameter("mid", movieId)
                .getResultList();
    }
}