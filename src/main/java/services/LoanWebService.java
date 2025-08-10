package services;

import ejb.LoanService;
import entities.Loan;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class LoanWebService {

    @EJB
    private LoanService loanService;

    @WebMethod
    public String rentMovie(int userId, int movieId, int rentalDays) {
        return loanService.rentMovie(userId, movieId, rentalDays);
    }

    @WebMethod
    public String returnMovie(int loanId) {
        return loanService.returnMovie(loanId);
    }

    @WebMethod
    public List<Loan> getUserLoans(int userId) {
        return loanService.getUserLoans(userId);
    }

    @WebMethod
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }
}