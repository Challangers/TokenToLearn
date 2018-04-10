package ovh.challangers.tokentolearn.Servlet;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import ovh.challangers.tokentolearn.beans.*;
import ovh.challangers.tokentolearn.controlers.database.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Servlet for create a new project
 */
@WebServlet(name = "CreateGroup", urlPatterns = "/createGroup")
public class GroupCreationServlet extends GenericServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

        Datastore datastore = DaoFactory.getDatastore();

        List<Student> students = datastore
                .createQuery(Student.class)
                .field("user")
                .in(Arrays.asList(request.getParameterValues("students")))
                .asList();

        Project project = datastore
                .createQuery(Project.class)
                .field("id")
                .in(Arrays.asList(request.getParameterValues("project")))
                .asList().get(0);

        Group group = new Group();
        group.setGroupid(request.getParameter("name"));
        group.setGroupStudent(students);
        group.setToken(project.getInitialToken());
        UpdateOperations<Project> updateProject = DaoFactory.getDatastore().createUpdateOperations(Project.class)
                .addToSet("groups", group);

        datastore.save(group);
        datastore.update(project, updateProject);
    }
}