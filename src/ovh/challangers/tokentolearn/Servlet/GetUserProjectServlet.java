package ovh.challangers.tokentolearn.Servlet;

import org.mongodb.morphia.Datastore;
import ovh.challangers.tokentolearn.beans.Group;
import ovh.challangers.tokentolearn.beans.Project;
import ovh.challangers.tokentolearn.beans.User;
import ovh.challangers.tokentolearn.beans.UserType;
import ovh.challangers.tokentolearn.controlers.database.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        // à voir
        if(user.getType()== UserType.TUTOR) return;


        Datastore datastore = DaoFactory.getDatastore();

        List<Group> groups = datastore
                .createQuery(Group.class)
                .field("groupStudent")
                .contains(user.getId())
                .asList();
        //TODO
        //modifier liste des projets
        List<Project> projects = datastore
                .createQuery(Project.class)
                .field("id")
                .in(Arrays.asList(request.getParameterValues("project")))
                .asList();


        request.setAttribute("projects", projects);
        request.getRequestDispatcher("/projectChooser.jsp").forward(request, response);
    }
}