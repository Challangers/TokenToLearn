package ovh.challangers.tokentolearn.beans;

import org.mongodb.morphia.annotations.*;

import java.util.List;

@Entity("groups")
@Indexes(
        @Index(value = "groupId", fields = @Field("groupId"))
)
public class Group {
    @Id
    private String groupId;

    @Reference
    private List<User> groupStudent;
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

    public List<User> getGroupStudent() {
        return groupStudent;
    }

    public void setGroupStudent(List<User> groupStudent) {
        this.groupStudent = groupStudent;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Group && groupId.equals(((Group)obj).groupId);
    }
}
