package ovh.challangers.tokentolearn.beans;

import java.util.List;

public class Project {
    private String id;
    private int initialToken;
    private Manager owner;
    private Tutor tutors;
    private List<Tag> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getInitialToken() {
        return initialToken;
    }

    public void setInitialToken(int initialToken) {
        this.initialToken = initialToken;
    }

    public Manager getOwner() {
        return owner;
    }

    public void setOwner(Manager owner) {
        this.owner = owner;
    }

    public Tutor getTutors() {
        return tutors;
    }

    public void setTutors(Tutor tutors) {
        this.tutors = tutors;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
