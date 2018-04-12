package ovh.challangers.tokentolearn.Servlet;

import ovh.challangers.tokentolearn.beans.*;
import ovh.challangers.tokentolearn.controlers.database.DaoFactory;
import ovh.challangers.tokentolearn.misc.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidParameterException;

@WebServlet(name = "GoInterventionServlet", value = "/intervention")
public class GoInterventionServlet extends HttpServlet {
    /**
     * @param request  {
     *                 do: what to do (request, start, end);
     *                 project: the project to start;
     *                 tutor: the id of the tutor;
     *                 canal: (0, 1, 2, -1) (DISCORD, DIRECT, OTHER, ANY)
     *                 }
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User current = JspHelper.getSessionObject(request, "user");

        switch (request.getParameter("do")) {
            case "request":
                if (current.getType().equals(UserType.STUDENT)) {
                    Group group = JspHelper.getSessionObject(request, "group");

                    Tutor tutor = DaoFactory.getDatastore().find(Tutor.class)
                            .field("user").equal(
                                    DaoFactory.getDatastore().find(User.class)
                                            .field("id").equal(request.getParameter("tutor")).get()
                            ).get(); // Tutor requested

                    Intervention interv = new Intervention();
                    Tutor.WaitingQueue waitingQueue = new Tutor.WaitingQueue();
                    interv.group = group;
                    interv.groupId = group.getGroupid();
                    interv.canal = Canal.values()[Integer.parseInt(request.getParameter("canal"))];
                    if (interv.canal == null) throw new InvalidParameterException();

                    waitingQueue.value = interv;
                    waitingQueue.key = JspHelper.getSessionObject(request, "project");

                    DaoFactory.getDatastore().save(interv);
                    DaoFactory.getDatastore().update(tutor,
                            DaoFactory.getDatastore().createUpdateOperations(Tutor.class)
                                    .addToSet("waitingQueue", waitingQueue)
                    );
                }
                break;
            case "start":
                if (current.getType().equals(UserType.TUTOR)) {
                    Tutor tutor = DaoFactory.getDatastore().find(Tutor.class)
                            .field("user").equal(current)
                            .get();
                    Project project = DaoFactory.getDatastore().find(Project.class)
                            .field("id").equal(request.getParameter("project"))
                            .get();

                    //switch (Integer.parseInt(request.getParameter("canal"))){
                    //    case 0:
                            // START DISCORD BOT

                    //        tutor.getWaitingqueue().get()
                    //}
                }
        }
        response.sendRedirect(request.getContextPath() + "/tokenMain");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
