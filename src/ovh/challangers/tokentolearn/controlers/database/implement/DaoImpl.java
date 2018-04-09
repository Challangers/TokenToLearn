package ovh.challangers.tokentolearn.controlers.database.implement;

import ovh.challangers.tokentolearn.controlers.database.interfaces.IDao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Base DAO implementation
 */
public class DaoImpl implements IDao {

    /**
     * Connection
     */
    Connection connection;

    /**
     * Constructor
     *
     * @param connection Connection to database
     */
    DaoImpl(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean connectionAlive() {
        boolean alive = false;

        try {
            if (!this.connection.isClosed())
                alive = true;
        } catch (SQLException e) {
            System.err.println("Connexion avec la BDD fermée");
        }

        return alive;
    }

    @Override
    public void closeConnection() {
        try {
            if (!this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Impossible de fermer la connexion");
        }
    }
}

