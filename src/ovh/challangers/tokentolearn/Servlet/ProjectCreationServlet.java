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
import java.util.stream.Collectors;

/**
 * Servlet for create a new project
 */
@WebServlet(name = "AddProject", urlPatterns = "/addProject")
public class ProjectCreationServlet extends GenericServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

        User user = (User) request.getSession().getAttribute("user");

        if(user.getType() != UserType.MANAGER) return;

        Datastore datastore = DaoFactory.getDatastore();
        List<Tag> tags = datastore
                .createQuery(Tag.class)
                .field("id")
                .in(Arrays.asList(request.getParameterValues("tags")))
                .asList();
        List<Tutor> tutors = datastore
                .createQuery(Tutor.class)
                .field("user")
                .in(Arrays.asList(request.getParameterValues("tutors")))
                .asList();
        Manager manager = datastore
                .createQuery(Manager.class)
                .field("user")
                .in(Arrays.asList(request.getParameterValues("manager")))
                .asList().get(0);


        Project project = new Project();
        project.setOwner(manager);
        project.setId(request.getParameter("name"));
        project.setInitialToken(Integer.parseInt(request.getParameter("initialToken")));
        project.setTags(tags);
        project.setTutors(tutors.stream().map(Tutor::getUser).collect(Collectors.toList()));

        datastore.save(project);

        List<Student> students = datastore
                .createQuery(Student.class)
                .field("user")
                .in(Arrays.asList(request.getParameterValues("students")))
                .asList();
        for(Student stu:students){
            UpdateOperations<Student> updateStudent = DaoFactory.getDatastore().createUpdateOperations(Student.class)
                    .addToSet("projects", project);
            datastore.update(stu, updateStudent);
        }
        response.sendRedirect(request.getContextPath() + "/tokenMain.jsp");
        return;
    }
}