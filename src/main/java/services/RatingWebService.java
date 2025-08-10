package services;

import ejb.RatingService;
import entities.Rating;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class RatingWebService {

    @EJB
    private RatingService ratingService;

    @WebMethod
    public String addRating(int userId, int movieId, int rate, String review) {
        ratingService.addRating(userId, movieId, rate, review);
        return "Rating added.";
    }

    @WebMethod
    public List<Rating> getRatingsForMovie(int movieId) {
        return ratingService.getRatingsForMovie(movieId);
    }
}