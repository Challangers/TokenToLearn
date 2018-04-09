package ovh.challangers.tokentolearn.beans;

import java.util.List;

public class Group {
    private String groupId;
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
