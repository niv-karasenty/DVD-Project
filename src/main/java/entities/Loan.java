/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author nivkarasenty
 */
@Entity
@Table(name = "Loan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loan.findAll", query = "SELECT l FROM Loan l"),
    @NamedQuery(name = "Loan.findByLoanID", query = "SELECT l FROM Loan l WHERE l.loanID = :loanID"),
    @NamedQuery(name = "Loan.findByLoanDate", query = "SELECT l FROM Loan l WHERE l.loanDate = :loanDate"),
    @NamedQuery(name = "Loan.findByRentalPeriod", query = "SELECT l FROM Loan l WHERE l.rentalPeriod = :rentalPeriod"),
    @NamedQuery(name = "Loan.findByReturnDate", query = "SELECT l FROM Loan l WHERE l.returnDate = :returnDate"),
    @NamedQuery(name = "Loan.findByStatus", query = "SELECT l FROM Loan l WHERE l.status = :status")})
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "loanID")
    private Integer loanID;
    @Column(name = "loanDate")
    @Temporal(TemporalType.DATE)
    private Date loanDate;
    @Column(name = "rentalPeriod")
    private Integer rentalPeriod;
    @Column(name = "returnDate")
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "movieID", referencedColumnName = "movieID")
    @ManyToOne
    private Movie movieID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne
    private User userID;

    public Loan() {
    }

    public Loan(Integer loanID) {
        this.loanID = loanID;
    }

    public Integer getLoanID() {
        return loanID;
    }

    public void setLoanID(Integer loanID) {
        this.loanID = loanID;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Integer getRentalPeriod() {
        return rentalPeriod;
    }

    public void setRentalPeriod(Integer rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Movie getMovieID() {
        return movieID;
    }

    public void setMovieID(Movie movieID) {
        this.movieID = movieID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loanID != null ? loanID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loan)) {
            return false;
        }
        Loan other = (Loan) object;
        if ((this.loanID == null && other.loanID != null) || (this.loanID != null && !this.loanID.equals(other.loanID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Loan[ loanID=" + loanID + " ]";
    }
    
}
