package ovh.challangers.tokentolearn.controlers.database;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class DaoFactory {

    private static final String DB_URL = "mongodb://localhost:9003/";

    private static final Morphia morphia = new Morphia();
    private static DaoFactory instance;



    public static DaoFactory getInstance() {
        // create the Datastore connecting to the default port on the local host
        if (instance == null){
            instance = new DaoFactory();
            morphia.mapPackage("ovh.challangers.tokentolearn.beans");
        }
        return instance;
    }

    public Datastore datastore() {
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "tokentolearn");
        datastore.ensureIndexes();
        return datastore;
    }

}