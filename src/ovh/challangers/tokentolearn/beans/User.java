package ovh.challangers.tokentolearn.beans;

import org.mongodb.morphia.annotations.*;

import java.util.List;

@Entity("user")
@Indexes(
        @Index(value = "id", fields = @Field("id"))
)
public class User {
    @Id
    private String id;
    private String password;
    private UserType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof User && id.equals(((User) obj).id);
    }
}
