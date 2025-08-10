package services;

import ejb.UserService;
import entities.User;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class UserWebService {

    @EJB
    private UserService userService;

    @WebMethod
    public User login(String username, String password) {
        return userService.login(username, password);
    }

    @WebMethod
    public String register(String firstName, String lastName, String email, String username, String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setIsAdmin(false); // default

        userService.register(user);
        return "User registered successfully.";
    }

    @WebMethod
    public User findUser(int userId) {
        return userService.findById(userId);
    }
}