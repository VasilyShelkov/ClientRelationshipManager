package names.clients;

import dataObjects.Client;

import java.sql.SQLException;

/**
 * Created by Vasia on 24/01/2015.
 */
public interface ClientDetailsService {
    Client getDetails(int nameId) throws SQLException, InstantiationException, IllegalAccessException;
    void deleteAccount(int nameId) throws IllegalAccessException, SQLException, InstantiationException;
}
