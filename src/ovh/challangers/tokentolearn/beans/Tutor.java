package ovh.challangers.tokentolearn.beans;

import org.mongodb.morphia.annotations.*;

import java.util.Iterator;
import java.util.List;

@Entity("tutor")
public class Tutor {
    @Reference
    @Id
    private User user;

    @Reference
    private Tag tag;

    private Status status;

    @Embedded
    private List<WaitingQueue> waitingQueue;
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

    public List<WaitingQueue> getWaitingqueue() {
        return waitingQueue;
    }

    public WaitingQueue popNext(Canal canal) {
        boolean found = false;
        Iterator<WaitingQueue> iterQueue = waitingQueue.iterator();
        while(!found){
            if(iterQueue.hasNext()){
                WaitingQueue next = iterQueue.next();
                if(canal == Canal.ANY || next.value.canal == canal){
                    waitingQueue.remove(next);

                    return next;
                }
            }else found = true;
        }
        return null;
    }

    public void setWaitingqueue(List<WaitingQueue> waitingqueue) {
        this.waitingQueue = waitingqueue;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public static class WaitingQueue {
        public Project key;
        public Intervention value;

        public WaitingQueue() {
        }
    }
}
