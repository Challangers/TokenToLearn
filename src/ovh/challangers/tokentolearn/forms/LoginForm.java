package ovh.challangers.tokentolearn.forms;

import ovh.challangers.tokentolearn.beans.User;
import ovh.challangers.tokentolearn.controlers.database.DaoFactory;
import ovh.challangers.tokentolearn.misc.HashPass;
import ovh.challangers.tokentolearn.misc.ServletUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Login form to connect user
 */
public class LoginForm {

    /**
     * Log in a user
     *
     * @param request Request from connection servlet
     * @return The user, <code>User</code> otherwise
     * @see User
     */
    public static User loginUser(HttpServletRequest request) {
        // retrieve data from login form
        String mail = ServletUtil.retrieveValue(request, "mail");
        String password = ServletUtil.retrieveValue(request, "password");

        if (mail.isEmpty() || password.isEmpty()) {
            return null;
        }
        // retrieve user from database
        User user = DaoFactory.getDatastore().createQuery(User.class).field("id").equal(mail).get();

        if (!(user == null) && user.getPassword().equals(HashPass.hashPassword(password)))
            return user;
        else {
//        LogManager.getLogger(LoginForm.class).error(mail + " --> mot de passe incorrect : " + password);
            return null;
        }
    }
}