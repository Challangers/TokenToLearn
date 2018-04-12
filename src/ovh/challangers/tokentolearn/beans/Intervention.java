package ovh.challangers.tokentolearn.beans;

import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Objects;

public class Intervention {
    @Id
    public String groupId;

    @Reference
    public Group group;

    public Canal canal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intervention that = (Intervention) o;
        return Objects.equals(group, that.group);
    }
}
