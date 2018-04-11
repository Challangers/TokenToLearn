package ovh.challangers.tokentolearn.Servlet;

import ovh.challangers.tokentolearn.beans.*;
import ovh.challangers.tokentolearn.controlers.database.DaoFactory;
import ovh.challangers.tokentolearn.misc.ServletUtil;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet to get all students
 */
@WebServlet(name = "CreateProject", urlPatterns = "/createProject")
public class CreateProjectServlet extends GenericServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);

        if (request.getSession().getAttribute("user") == null ) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        if (request.getSession().getAttribute("mode").equals("create")) {

            List<Student> students = DaoFactory.getDatastore().createQuery(Student.class).asList();
            List<Tag> tags = DaoFactory.getDatastore().createQuery(Tag.class).asList();
            List<Tutor> tutors = DaoFactory.getDatastore().createQuery(Tutor.class).asList();


            request.setAttribute("tutors", tutors);
            request.setAttribute("tags", tags);
            request.setAttribute("Students", students);
            request.getRequestDispatcher("/CreateProject.jsp").forward(request, response);
        } else {
//            test
        }
    }
}
