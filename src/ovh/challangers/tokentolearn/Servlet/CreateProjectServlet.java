package ovh.challangers.tokentolearn.Servlet;

import ovh.challangers.tokentolearn.beans.*;
import ovh.challangers.tokentolearn.controlers.database.DaoFactory;
import ovh.challangers.tokentolearn.misc.JspHelper;
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

        String projectName = ServletUtil.retrieveValue(request,"project");

        if (request.getSession().getAttribute("user") == null && JspHelper.<User>getSessionObject(request, "user").getType().equals(UserType.MANAGER)) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        if (request.getSession().getAttribute("mode").equals("create")) {

            List<Student> allStudents = DaoFactory.getDatastore().createQuery(Student.class).asList();
            List<Tag> allTags = DaoFactory.getDatastore().createQuery(Tag.class).asList();
            List<Tutor> allTutors = DaoFactory.getDatastore().createQuery(Tutor.class).asList();


            request.setAttribute("tutors", allTutors);
            request.setAttribute("tags", allTags);
            request.setAttribute("Students", allStudents);
            request.getRequestDispatcher("/CreateProject.jsp").forward(request, response);
        } else {
            Project project = DaoFactory.getDatastore().createQuery(Project.class).field("id").equal(projectName).get();
            List<Tutor> newTutors = DaoFactory.getDatastore().createQuery(Tutor.class).field("id").notIn(project.getTutors()).asList();
            List<Student> newStudents = DaoFactory.getDatastore().createQuery(Student.class).field("project").notEqual(project).asList();
            List<Tag> newTag = DaoFactory.getDatastore().createQuery(Tag.class).field("id").notIn(project.getTags()).asList();
            int tokens = project.getInitialToken();

            request.setAttribute("newTutors", newTutors);
            request.setAttribute("newTags", newTag);
            request.setAttribute("newStudents", newStudents);
            request.setAttribute("tokens",tokens);
            request.getRequestDispatcher("/CreateProject.jsp").forward(request, response);

        }
    }
}
