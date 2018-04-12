package ovh.challangers.tokentolearn.Servlet;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import ovh.challangers.tokentolearn.beans.*;
import ovh.challangers.tokentolearn.controlers.database.DaoFactory;
import ovh.challangers.tokentolearn.misc.JspHelper;
import ovh.challangers.tokentolearn.misc.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet to tokenMain
 */
@WebServlet (name = "TokenMain", urlPatterns = "/tokenMain")
public class TokenMainServlet extends GenericServlet{

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        Datastore datastore = DaoFactory.getDatastore();
        User user = (User) request.getSession().getAttribute("user");
        String projectName = request.getParameter("id");
        Project project;
        if(JspHelper.getSessionObject(request, "project") != null) //Hope that the project is available
            project = JspHelper.getSessionObject(request, "project");
        else {
            project = datastore
                    .createQuery(Project.class)
                    .field("id")
                    .equal(projectName)
                    .get();
            request.getSession().setAttribute("project", project);
        }
        if(user.getType()== UserType.STUDENT){
            List<Group> groups = datastore
                    .createQuery(Group.class)
                    .field("groupStudent")
                    .equal(user)
                    .asList();



            List<Group> allGroup = project.getGroups();
            Group studentGroup = new Group();
            for (Group g : allGroup) {
                for (Group gStudent : groups) {
                    if (g.getGroupid().equals(gStudent.getGroupid())) {
                        studentGroup = g;
                    }
                }
            }

            request.setAttribute("groups", allGroup);
            request.setAttribute("projectName", project.getId());
            request.setAttribute("groupStudent", studentGroup);
            request.setAttribute("tutors", project.getTutors());
            request.setAttribute("tags", project.getTags());
            request.getSession().setAttribute("group", studentGroup);
            request.getRequestDispatcher("/tokenMain.jsp").forward(request, response);
            return;
        }

        if(user.getType()== UserType.TUTOR){
            List<Project> projects = datastore
                    .createQuery(Project.class)
                    .field("tutors")
                    .contains(user.getId())
                    .asList();

            Tutor tutor = (Tutor) datastore
                    .createQuery(Tutor.class)
                    .field("user")
                    .equal(user);

            request.setAttribute("projects", projects);
            request.setAttribute("tutor", tutor);
            request.getRequestDispatcher("/tokenMain.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("/tokenMain.jsp").forward(request, response);
    }
}
