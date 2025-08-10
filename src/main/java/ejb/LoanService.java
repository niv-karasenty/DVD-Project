package ejb;

import entities.Loan;
import entities.Movie;
import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Date;

@Stateless
public class LoanService {

    @PersistenceContext(unitName = "BlockkBusterrBackEnd1.0PU")
    private EntityManager em;

    public String rentMovie(int userId, int movieId, int rentalDays) {
    Movie movie = em.find(Movie.class, movieId);
    User user = em.find(User.class, userId);

    if (movie == null || movie.getAvailability() <= 0 || user == null) {
        return "Movie not available or user not found.";
    }

    Loan loan = new Loan();
    loan.setUserID(user); // FIXED
    loan.setMovieID(movie); // FIXED
    loan.setLoanDate(new Date()); // FIXED
    loan.setRentalPeriod(rentalDays);
    loan.setStatus(true);

    em.persist(loan);

    movie.setAvailability(movie.getAvailability() - 1);
    em.merge(movie);

    return "Movie rented successfully.";
}

    public String returnMovie(int loanId) {
    Loan loan = em.find(Loan.class, loanId);
    if (loan == null || !loan.getStatus()) {
        return "Loan not found or already returned.";
    }

    loan.setStatus(false);
    loan.setReturnDate(new Date()); // FIXED
    em.merge(loan);

    Movie movie = loan.getMovieID(); // Use object directly
    movie.setAvailability(movie.getAvailability() + 1);
    em.merge(movie);

    return "Movie returned successfully.";
}

    public List<Loan> getUserLoans(int userId) {
        return em.createQuery("SELECT l FROM Loan l WHERE l.userID = :uid", Loan.class)
                .setParameter("uid", userId)
                .getResultList();
    }

    public List<Loan> getAllLoans() {
        return em.createQuery("SELECT l FROM Loan l", Loan.class).getResultList();
    }
}