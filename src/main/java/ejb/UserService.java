package ejb;

import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserService {

    @PersistenceContext(unitName = "BlockkBusterrBackEnd1.0PU")
    private EntityManager em;

    public User login(String username, String password) {
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();

        return users.isEmpty() ? null : users.get(0);
    }

    public void register(User user) {
        em.persist(user);
    }

    public User findById(int userId) {
        return em.find(User.class, userId);
    }
}
