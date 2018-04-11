package ovh.challangers.tokentolearn.beans;

import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

public class CurrentIntervention {
    @Id
    @Reference
    public Group group;

    @Reference
    public Tutor tutor;

    public Canal canal;

    public Date start;
}
