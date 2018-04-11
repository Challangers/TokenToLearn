package ovh.challangers.tokentolearn.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to tokenMain
 */
@WebServlet (name = "TokenMain", urlPatterns = "/tokenMain")
public class TokenMainServlet extends GenericServlet{

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }
}
