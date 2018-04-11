package ovh.challangers.tokentolearn.beans;

import org.mongodb.morphia.annotations.*;

import java.util.Map;

@Entity("tutor")
public class Tutor {
    @Reference
    @Id
    private User user;

    @Reference
    private Tag tag;

    private Status status;

    @Reference
    private Map<Project, Intervention> waitingQueue;
    private int tokens;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<Project, Intervention> getWaitingqueue() {
        return waitingQueue;
    }

    public void setWaitingqueue(Map<Project, Intervention> waitingqueue) {
        this.waitingQueue = waitingqueue;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
}
