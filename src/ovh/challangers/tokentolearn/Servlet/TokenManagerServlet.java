package ovh.challangers.tokentolearn.Servlet;

import org.mongodb.morphia.query.UpdateOperations;
import ovh.challangers.tokentolearn.beans.Group;
import ovh.challangers.tokentolearn.beans.User;
import ovh.challangers.tokentolearn.beans.UserType;
import ovh.challangers.tokentolearn.controlers.database.DaoFactory;
import ovh.challangers.tokentolearn.misc.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TokenManagerServlet", value="/manage/token")
public class TokenManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(JspHelper.getSessionBoolean(request,"logged")){
            if(JspHelper.<User>getSessionObject(request, "user").getType().equals(UserType.TUTOR)){
                String groupId = request.getParameter("groupid");

                int tokenSpent = 0;
                switch (request.getParameter("mode")){
                    case "manualtoken":
                        tokenSpent = Integer.parseInt(request.getParameter("tokenspent"));

                    case "manualtime":
                    case "discord":
                        tokenSpent = (int) (Long.parseLong(request.getParameter("timemilli")) / 600000);
                }

                Group group = DaoFactory.getDatastore().createQuery(Group.class)
                        .field("id").equal(groupId)
                        .get();
                if(group != null){
                    UpdateOperations<Group> addToken = DaoFactory.getDatastore().createUpdateOperations(Group.class)
                            .inc("token", tokenSpent);

                    DaoFactory.getDatastore().update(group, addToken);
                }
            }
        }
    }
}
