package ovh.challangers.tokentolearn.beans;

import org.mongodb.morphia.annotations.*;

import java.util.List;

@Entity("group")
@Indexes(
        @Index(value = "groupId", fields = @Field("groupId"))
)
public class Group {
    @Id
    private String groupId;

    @Reference
    private List<Student> groupStudent;
    private int token;

    public String getGroupid() {
        return groupId;
    }

    public void setGroupid(String groupid) {
        this.groupId = groupid;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public List<Student> getGroupStudent() {
        return groupStudent;
    }

    public void setGroupStudent(List<Student> groupStudent) {
        this.groupStudent = groupStudent;
    }
}
