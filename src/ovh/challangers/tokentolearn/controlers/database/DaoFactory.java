package ovh.challangers.tokentolearn.controlers.database;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class DaoFactory {

    private static final String DB_URL = "51.255.173.143";

    private static final Morphia morphia = new Morphia();
    private static final int DB_PORT = 27017;
    private static Datastore datastore;

    public static Datastore getDatastore() {
        if(datastore == null){
            morphia.mapPackage("ovh.challangers.tokentolearn.beans");
            datastore = morphia.createDatastore(new MongoClient(DB_URL, DB_PORT), "tokentolearn");
            datastore.ensureIndexes();
        }
        return datastore;
    }

}