package ovh.challangers.tokentolearn.Servlet;

import org.mongodb.morphia.Datastore;
import ovh.challangers.tokentolearn.beans.*;
import ovh.challangers.tokentolearn.controlers.database.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet to chose a project
 */
@WebServlet(name = "projectChooser", urlPatterns = "/projectChooser")
public class GetUserProjectServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
        User user = (User) request.getSession().getAttribute("user");
        Datastore datastore = DaoFactory.getDatastore();
        List<Project> projects = new ArrayList<>();

        if(user.getType()== UserType.TUTOR){
            projects = datastore
                    .createQuery(Project.class)
                    .field("tutors")
                    .contains(user.getId())
                    .asList();
        }

        if(user.getType()== UserType.MANAGER){
            Manager manager = (Manager) datastore
                    .createQuery(Manager.class)
                    .field("user")
                    .equal(user);

            projects = datastore
                    .createQuery(Project.class)
                    .field("owner")
                    .equal(manager)
                    .asList();
        }

        if(user.getType()== UserType.STUDENT){
            Student student = (Student) datastore
                    .createQuery(Student.class)
                    .field("user")
                    .equal(user);

            projects = student.getProjects();
        }

        request.setAttribute("projects", projects);
        request.getRequestDispatcher("/projectChooser.jsp").forward(request, response);
        return;
    }
}