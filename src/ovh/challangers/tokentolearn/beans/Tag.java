package ovh.challangers.tokentolearn.beans;

import org.mongodb.morphia.annotations.*;

@Entity("tag")
@Indexes(
        @Index(value = "id", fields = @Field("id"))
)
public class Tag {
    @Id
    private String id;
}
