package names.clients;

import dataObjects.Client;

import java.sql.SQLException;

/**
 * Created by Vasia on 24/01/2015.
 */
public interface ClientDetailsService {
    Client getDetails(int nameId, int accountId) throws SQLException, InstantiationException, IllegalAccessException;
    void deleteAccount(int nameId, int accountId) throws IllegalAccessException, SQLException, InstantiationException;
}
