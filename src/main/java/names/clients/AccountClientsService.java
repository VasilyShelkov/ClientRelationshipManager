package names.clients;

import dataObjects.Client;
import dataObjects.Name;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasia on 11/01/2015.
 */
public interface AccountClientsService {
    List<Name> getClients(int accountId) throws SQLException, InstantiationException, IllegalAccessException;
    Client createClient(Client client) throws SQLException, InstantiationException, IllegalAccessException;
}
