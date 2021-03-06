package ovh.challangers.tokentolearn.Servlet;

import ovh.challangers.tokentolearn.beans.*;
import ovh.challangers.tokentolearn.controlers.database.DaoFactory;
import ovh.challangers.tokentolearn.forms.LoginForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet for connection
 */
@WebServlet(name = "Connection", urlPatterns = "/connection")
public class ConnectionServlet extends GenericServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

        // try log in user
        User user = LoginForm.loginUser(request);

        if (user != null) {
            // register user in session and redirect to welcome servlet
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("logged", true);
            response.sendRedirect(request.getContextPath() + "/projectChooser"); // changer par la redirection necessaire
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
