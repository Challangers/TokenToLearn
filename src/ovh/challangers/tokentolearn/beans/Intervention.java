package ovh.challangers.tokentolearn.beans;

import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

public class Intervention {
    @Id
    @Reference
    public Group group;

    public Canal canal;
}
