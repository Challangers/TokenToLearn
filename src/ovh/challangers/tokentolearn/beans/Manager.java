package ovh.challangers.tokentolearn.beans;

import org.mongodb.morphia.annotations.*;

@Entity("manager")
public class Manager {
    @Reference
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
