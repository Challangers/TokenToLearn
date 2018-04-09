package ovh.challangers.tokentolearn.controlers.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class DaoFactory {

    private static final String DB_URL = "mongodb://localhost:9003/";

    private static DaoFactory instance;

    public static DaoFactory getInstance() {
        if (instance == null) instance = new DaoFactory();
        return instance;
    }

    public MongoClient getConnection() {
        return new MongoClient(new MongoClientURI(DB_URL));
    }

}