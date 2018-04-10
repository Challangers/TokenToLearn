package ovh.challangers.tokentolearn.beans;

import org.mongodb.morphia.annotations.*;

import java.util.List;

@Entity("project")
@Indexes(
        @Index(value = "id", fields = @Field("id"))
)
public class Project {
    @Id
    private String id;
    private int initialToken;

    @Reference
    private Manager owner;

    @Reference
    private List<Tutor> tutors;

    @Reference
    private List<Tag> tags;

    @Reference
    private List<Group> groups;

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

    public List<Tutor> getTutors() {
        return tutors;
    }

    public void setTutors(List<Tutor> tutors) {
        this.tutors = tutors;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGroups(Group group) { this.groups.add(group); }

}
