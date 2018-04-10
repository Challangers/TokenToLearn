package ovh.challangers.tokentolearn.beans;

import org.mongodb.morphia.annotations.*;

import java.util.Queue;

@Entity("tutor")
public class Tutor {
    @Reference
    private User user;

    @Reference
    private Tag tag;

    private Status status;

    @Reference
    private Queue<Student> waitingQueue;
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

    public Queue<Student> getWaitingqueue() {
        return waitingQueue;
    }

    public void setWaitingqueue(Queue<Student> waitingqueue) {
        this.waitingQueue = waitingqueue;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
}
